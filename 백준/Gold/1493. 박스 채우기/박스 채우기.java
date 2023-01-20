import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int L, W, H, N;
    static int[] cube;

    // solution method
    static void solution() {
        long temp = 0;
        long answer = 0;
        for(int i=N-1; i>=0; i--) {
            temp <<= 3;
            long test = (long) (L >> i) * (W >> i) * (H >> i) - temp;
            long newCube = Math.min(cube[i], test);

            temp += newCube;
            answer += newCube;
        }
        System.out.println(temp == (long) L * W * H ? answer : -1);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        cube = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int tempIndex = Integer.parseInt(st.nextToken());
            cube[tempIndex] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
}
