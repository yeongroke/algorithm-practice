import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    // solution method
    static int solution(int N, long[] input) {
        int answer = 0;
        PriorityQueue<Long> q = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            q.add(input[i]);
        }

        while(q.size()!=1) {
            long temp = q.poll()+q.poll();
            answer += temp;
            q.add(temp);
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] input = new long[N];
        for(int i=0; i<N; i++) {
            input[i] = (Long.parseLong(br.readLine()));
        }

        System.out.println(solution(N, input));
    }
}
