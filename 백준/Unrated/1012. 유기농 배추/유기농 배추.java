import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K;
    static int[][] input;
    static boolean[][] pass;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    // solution method
    static void solution() {
        int answer = 0;

        for(int x=0; x<M; x++) {
            for(int y=0; y<N; y++) {
                if(input[x][y] == 1 && !pass[x][y]) {
                    dfs(x, y);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        pass[x][y] = true;

        for(int i=0; i<4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if(tempX >= 0 && tempY >= 0 && tempX < M && tempY < N) {
                if(!pass[tempX][tempY] && input[tempX][tempY] == 1) {
                    dfs(tempX, tempY);
                }
            }
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            input = new int[M][N];
            pass = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int inputX = Integer.parseInt(st.nextToken());
                int inputY = Integer.parseInt(st.nextToken());
                input[inputX][inputY] = 1;
            }
            solution();
        }
    }
}
