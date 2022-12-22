import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Long> q;
    // solution method
    static long[] solution(int N, int[][] input) {
        long[] answer = new long[N];

        for(int i=0; i<input.length; i++) {
            q = new PriorityQueue<>();
            for(int j=0; j<input[i].length; j++) {
                q.offer((long) input[i][j]);
            }
            long total = 0;
            long sumResult = 0;
            while(true) {
                long one = q.poll();
                long two = q.poll();

                sumResult = one + two;
                total += sumResult;
                if(q.isEmpty()) break;

                q.offer(sumResult);
            }
            answer[i] = total;
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[][] input = new int[N][];

        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(br.readLine());
            input[i] = new int[temp];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<temp; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[] solution = solution(N, input);
        for(long s : solution) {
            System.out.println(s);
        }
    }
}
