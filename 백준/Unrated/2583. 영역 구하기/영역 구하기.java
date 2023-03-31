import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int[][] input;
    static int count = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static List<Integer> answer = new ArrayList<>();

    // solution method
    static void solution() {
        for(int x=0; x<M; x++) {
            for(int y=0; y<N; y++) {
                if(input[x][y] == 0) {
                    count = 0;
                    dfs(x, y);
                    answer.add(count);
                }
            }
        }
    }

    static void dfs(int x, int y) {
        input[x][y] = 1;
        count++;
        for(int i=0; i<4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if(tempX >= 0 && tempY >= 0 && tempX < M && tempY < N && input[tempX][tempY] == 0) {
                dfs(tempX, tempY);
            }
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new int[M][N];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int tempX1 = Integer.parseInt(st.nextToken());
            int tempY1 = Integer.parseInt(st.nextToken());
            int tempX2 = Integer.parseInt(st.nextToken());
            int tempY2 = Integer.parseInt(st.nextToken());

            for(int x=tempY1; x<tempY2; x++) {
                for(int y=tempX1; y<tempX2; y++) {
                    input[x][y] = 1;
                }
            }
        }

        solution();

        System.out.println(answer.size());
        answer.stream().sorted().forEach(integer -> System.out.print(integer + " "));
    }
}
