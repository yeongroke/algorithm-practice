import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // solution method
    static int solution(int N, int L, int[] input) {
        int answer = 1;

        Arrays.sort(input);
        
        int temp = input[0];
        for(int i=1; i<N; i++) {
            if(input[i] - temp >= L) {
                answer ++;
                temp = input[i];
            }
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, L, input));
    }
}
