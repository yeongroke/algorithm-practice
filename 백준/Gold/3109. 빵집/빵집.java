import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dy[] = {-1, 0, 1};
    static int dx[] = {1, 1, 1};
    static int R, C, answer;
    static boolean[][] pass;
    static char[][] input;
    static boolean flag;

    // solution method
    static void dfs(int y, int x) {
        if(x == C - 1) {
            flag = true;
            answer ++;
            return;
        }

        for(int i=0; i<3; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if(tempX >= 0 && tempY >= 0 && tempX < C && tempY < R) {
                if(!pass[tempY][tempX] && input[tempY][tempX] == '.') {
                    pass[tempY][tempX] = true;
                    dfs(tempY, tempX);
                    if(flag) return;
                }
            }
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[R][C];
        for(int i=0; i<R; i++) {
            input[i] = br.readLine().toCharArray();
        }

        pass = new boolean[R][C];

        for(int i=0; i<R; i++) {
            flag = false;
            dfs(i, 0);
        }
        System.out.println(answer);
    }
}
