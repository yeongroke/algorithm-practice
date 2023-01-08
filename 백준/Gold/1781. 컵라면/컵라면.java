import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // solution method
    static int solution(int N, int[][] input) {
        int answer = 0;

        Arrays.sort(input, (o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            q.offer(input[i][1]);
            if(input[i][0] < q.size()) {
                q.poll();
            }
        }

        while(!q.isEmpty()) {
            answer += q.poll();
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[][] input = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, input));
    }
}
