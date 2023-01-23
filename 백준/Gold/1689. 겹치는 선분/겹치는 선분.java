import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] input;

    // solution method
    static void solution() {
        Arrays.sort(input, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int answer = 1;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(input[0][1]);
        for(int i=1; i<N; i++) {
            if(!q.isEmpty() && q.peek() <= input[i][0]) {
                q.poll();
            }
            q.offer(input[i][1]);
            answer = Math.max(answer, q.size());
        }

        System.out.println(answer);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        input = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}
