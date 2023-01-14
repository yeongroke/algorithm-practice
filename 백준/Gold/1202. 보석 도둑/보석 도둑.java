import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] input;
    static int[] bags;

    // solution method
    static void solution() {
        Arrays.sort(input, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        });
        Arrays.sort(bags);

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;

        int tempIndex = 0;
        for(int i=0; i<K; i++) {
            while (tempIndex < N && input[tempIndex][0] <= bags[i]) {
                q.offer(input[tempIndex++][1]);
            }

            if (!q.isEmpty()) {
                answer += q.poll();
            }
        }

        System.out.println(answer);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        bags = new int[K];
        for(int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        solution();
    }
}
