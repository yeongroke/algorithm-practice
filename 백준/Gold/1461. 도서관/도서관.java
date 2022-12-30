import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // solution method
    static int solution(int N, int K, int[] input) {
        int answer = 0;
        
        PriorityQueue<Integer> m = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<input.length; i++) {
            if(input[i] >= 0) {
                p.add(input[i]);
            } else {
                m.add(Math.abs(input[i]));
            }
        }

        int endCount = 0;

        if(p.isEmpty())
            endCount = m.peek();
        else if(m.isEmpty())
            endCount = p.peek();
        else
            endCount = Math.max(m.peek(), p.peek());


        while(!p.isEmpty()) {
            answer += p.peek() * 2;
            for(int i=0; i<K; i++) {
                p.poll();
            }
        }

        while(!m.isEmpty()) {
            answer += m.peek() * 2;
            for(int i=0; i<K; i++) {
                m.poll();
            }
        }

        answer -= endCount;

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] input = new int[N];
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, K, input));
    }
}
