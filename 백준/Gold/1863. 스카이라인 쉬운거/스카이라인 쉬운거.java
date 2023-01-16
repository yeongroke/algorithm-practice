import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] input;

    // solution method
    static void solution() {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            while(!stack.isEmpty() && stack.peek() > input[i][1]) {
                answer ++;
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() == input[i][1])
                continue;
            stack.push(input[i][1]);
        }

        while(!stack.isEmpty()) {
            if(stack.peek() > 0)
                answer ++;

            stack.pop();
        }

        System.out.println(answer);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        input = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}
