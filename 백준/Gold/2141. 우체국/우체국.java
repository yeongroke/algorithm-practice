import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long max;
    static long[][] input;

    // solution method
    static void solution() {
        Arrays.sort(input, (o1, o2) -> {
            if(o1[0] == o2[0]) return (int) (o1[1] - o2[1]);
            return (int) (o1[0] - o2[0]);
        });

        long sum = 0;
        for(int i=0; i<N; i++) {
            sum += input[i][1];
            if(sum >= (max+1)/2) {
                System.out.println(input[i][0]);
                break;
            }
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        input = new long[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Long.parseLong(st.nextToken());
            input[i][1] = Long.parseLong(st.nextToken());
            max += input[i][1];
        }

        solution();
    }
}
