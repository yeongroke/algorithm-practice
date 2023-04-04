import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C, L;
    static int[][] input;
    static boolean[] visit;
    static int count = 0;

    // solution method
    static void solution() {
        dfs(1);

        System.out.println(count-1);
    }

    static void dfs(int index) {
        count ++;
        visit[index] = true;

        for(int i=1; i<=C; i++) {
            if(input[index][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        C = Integer.parseInt(br.readLine());
        L = Integer.parseInt(br.readLine());

        input = new int[C+1][C+1];
        visit = new boolean[C+1];
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            int tempX = Integer.parseInt(st.nextToken());
            int tempY = Integer.parseInt(st.nextToken());

            input[tempX][tempY] = input[tempY][tempX] =  1;
        }

        solution();
    }
}
