import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // solution method
    static int solution(int N, int K, int[] input) {
        int answer = 0;

        Arrays.sort(input);

        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i<N-1; i++) {
            queue.offer(input[i+1] - input[i]);
        }

        for(int i = 0; i<N-K; i++) {
            answer += queue.poll();
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[N];
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, K, input));
    }
}
