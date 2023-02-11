import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, sum;
    static int[] input;

    // solution method
    static void solution() {
        int answer = 0;

        while(sum != 0) {
            int tempCount = 0;
            for(int i=0; i<N; i++) {
                if(input[i]%2 == 1) {
                    input[i]--;
                    tempCount++;
                }
            }

            if(tempCount > 0) {
                sum -= tempCount;
                answer += tempCount;
            } else {
                for(int i=0; i<N; i++) {
                    input[i] /= 2;
                }
                sum /= 2;
                answer++;
            }
        }

        System.out.print(answer);

    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new int[N];
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            sum += input[i];
        }
        solution();
    }
}
