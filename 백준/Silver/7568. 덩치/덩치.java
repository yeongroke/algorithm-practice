import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] input;

    // solution method
    static void solution() {
        for(int i=0; i<N; i++) {
            int rank = 1;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;

                if (input[i][0] < input[j][0] && input[i][1] < input[j][1]) {
                    rank++;
                }
            }

            System.out.print(rank + " ");
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        input = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}
