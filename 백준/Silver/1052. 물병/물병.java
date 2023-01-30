import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    // solution method
    static void solution() {
        if(N <= K) {
            System.out.println(0);
        } else {
            int answer = 0;
            int bot = 0;
            while(true) {
                answer = 0;
                int temp = N;
                while(temp != 0) {
                    if(temp%2 == 1) answer ++;
                    temp /= 2;
                }
                if(answer <= K) break;
                N ++;
                bot ++;
            }
            System.out.println(bot);
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        solution();
    }
}
