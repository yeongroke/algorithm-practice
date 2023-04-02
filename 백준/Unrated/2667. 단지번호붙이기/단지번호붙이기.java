import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[][] input;
    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();
    static int count, visitCount;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    // solution method
    static void solution() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && input[i][j] == 1) {
                    count = 0;
                    visitCount++;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
    }


    static void dfs(int x, int y) {
        visited[x][y] = true;
        input[x][y] = visitCount;
        count ++;

        for(int i=0; i<4; i++) {
            int tempX = dx[i] + x;
            int tempY = dy[i] + y;

            if(tempX >= 0 && tempX < N && tempY >= 0 && tempY < N && !visited[tempX][tempY] && input[tempX][tempY] == 1) {
                visited[tempX][tempY] = true;
                input[tempX][tempY] = visitCount;

                dfs(tempX, tempY);
            }
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String temp = br.readLine();

            for(int j=0; j<N; j++) {
                input[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }

        solution();

        System.out.println(visitCount);

        answer.stream().sorted().forEach(System.out::println);
    }
}
