import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[] input;

    // solution method
    static void solution() {
        int result = 0;
        for(int i=1; i<W-1; i++) {
            int left = 0;
            int right = 0;

            for(int j=0; j<i; j++) {
                left = Math.max(input[j], left);
            }

            for(int j=i+1; j<W; j++) {
                right = Math.max(input[j], right);
            }

            if(input[i] < left && input[i] < right) 
                result += Math.min(left, right) - input[i];
        }
        System.out.println(result);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        input = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}
