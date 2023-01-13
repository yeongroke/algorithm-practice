import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] input;

    // solution method
    static void solution() {
        Arrays.sort(input, Comparator.comparingInt(o -> o[1]));

        int count = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            while(!q.isEmpty() && q.peek() <= input[i][1]) {
                q.poll();
            }
            q.add(input[i][2]);
            count = Math.max(count, q.size());
        }
        System.out.println(count);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        input = new int[N][3];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            input[i][2] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}
