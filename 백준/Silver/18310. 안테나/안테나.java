import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] input;

    // solution method
    static void solution() {
        Arrays.sort(input);
        System.out.println(input[(N-1)/2]);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new int[N];
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}
