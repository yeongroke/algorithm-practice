import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] input;

    // solution method
    static void solution() {
        long sum = 0;
        for(int i=0; i<M; i++){
            Arrays.sort(input);
            long add = input[0] + input[1];
            input[0] = add;
            input[1] = add;
        }
        for(int i=0; i<input.length; i++){
            sum += input[i];
        }
        System.out.println(sum);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st =  new StringTokenizer(br.readLine());
        input = new long[N];
        for(int i=0; i<N; i++) {
            input[i] = Long.valueOf(st.nextToken());
        }

        solution();
    }
}
