import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] input;
    static boolean[][] passed;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int count, countW = 0, countB = 0;
    static int tempX, tempY;

    // solution method
    static void solution() {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!passed[i][j]) {
                    count = 0;
                    dfs(j, i, input[i][j]);

                    if (input[i][j] == 'B') {
                        countB += count * count;
                    } else {
                        countW += count * count;
                    }
                }
            }
        }

        System.out.println(countW + " " + countB);
    }

    static void dfs(int x, int y, char team) {
        passed[y][x] = true;
        count++;

        for(int i=0; i<4; i++) {
            tempY = y + dy[i];
            tempX = x + dx[i];

            if(0 <= tempY && tempY < M && 0 <= tempX && tempX < N && input[tempY][tempX] == team && !passed[tempY][tempX]) {
                dfs(tempX, tempY, input[tempY][tempX]);
            }

        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new char[M][N];
        passed = new boolean[M][N];

        for(int i=0; i<M; i++) {
            String temp = br.readLine();
            for(int j=0; j<N; j++) {
                input[i][j] = temp.charAt(j);
            }
        }

        solution();
    }
}
