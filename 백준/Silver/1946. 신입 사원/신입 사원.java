import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // solution method
    static void solution() {

    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        int t;

        for(t=0; t<P; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] pass = new int[N + 1];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());

                int oneTest = Integer.parseInt(st.nextToken());
                int twoTest = Integer.parseInt(st.nextToken());

                pass[oneTest] = twoTest;
            }

            int result = 1;
            int temp = pass[1];
            for(int i=2; i<=N; i++) {
                if (temp > pass[i]) {
                    result++;
                    temp = pass[i];
                }
            }
            System.out.println(result);
        }
    }
}
