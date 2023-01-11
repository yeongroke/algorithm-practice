import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] input;

    // solution method
    static void solution() {
        int sum = 0;
        int count = 0;
        for(int i=0; i<N; i++) {
            sum += input[i];
            if(input[i] %2 == 1) {
                count ++;
            }
        }
        if(sum%3 == 0 && count <= sum/3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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
