import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    // solution method
    static void solution() {
        long answer = 0;
        long count = 1;
        long length = 10;
        long temp = K == 1 ? 1 : -1;

        for(int i=1 ; i<=N+1 ; i++) {
            if(answer >= K) {
                temp = i - 1;
                break;
            }
            if(i == length) {
                count++;
                length *= 10;
            }

            answer += count;
        }

        if(temp != -1) {
            String str = String.valueOf(temp);
            System.out.println(str.charAt((int)(str.length() - (answer - K) - 1)));
        } else {
            System.out.println(-1);
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
