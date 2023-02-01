import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] input;
    static int[] maxHeight = new int[1000002];

    // solution method
    static void solution() {
        int count = 0, nowH = 0;
        for(int i=0; i<N; i++) {
            nowH = input[i];
            if(maxHeight[nowH + 1] == 0) {
                count++;
            } else {
                maxHeight[nowH + 1]--;
            }
            maxHeight[nowH]++;
        }
        System.out.println(count);
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
