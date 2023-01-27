import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] input;

    // solution method
    static void solution() {
        Arrays.sort(input);

        int max = input[N-1];

        for(int i=0; i<N-1; i++) {
            max = Math.max(max, input[i]*(N-i));
        }

        System.out.println(max);
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
