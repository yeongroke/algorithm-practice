import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] input;

    // solution method
    static void solution() {
        long answer = 0;
        Arrays.sort(input);

        for(int i=0; i<N; i++) {
            answer += Math.abs(input[i] - (i+1));
        }
        System.out.println(answer);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        input = new int[N];
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }
}
