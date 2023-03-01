import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[] input;

    // solution method
    static void solution() {
        Arrays.sort(input, ((x, y) -> (y + x).compareTo(x + y)));

        StringBuilder sb = new StringBuilder();
        for(String s : input) {
            sb.append(s);
        }

        if (sb.charAt(0) == '0') {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new String[N];

        for(int i=0; i<N; i++) {
            input[i] = st.nextToken();
        }

        solution();
    }
}
