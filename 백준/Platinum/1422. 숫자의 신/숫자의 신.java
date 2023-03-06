import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static String[] input;

    // solution method
    static void solution() {
        Arrays.sort(input, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();
        boolean isMax = false;
        int maxSize = 0;
        for(int i=0; i<K; i++) {
            maxSize = Math.max(maxSize, input[i].length());
        }

        for(int i=0; i<K; i++) {
            if(!isMax && input[i].length() == maxSize) {
                isMax = true;
                for(int j=0; j<N-K+1; j++) {
                    sb.append(input[i]);
                }
            } else {
                sb.append(input[i]);
            }
        }
        System.out.println(sb);

    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        input = new String[K];
        for(int i=0; i<K; i++) {
            input[i] = br.readLine();
        }

        solution();
    }
}
