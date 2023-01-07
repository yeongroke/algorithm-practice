import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node node) {
            if(x-node.x > 0)
                return -1;
            else if(x-node.x < 0)
                return 1;
            return x-node.x;
        }
    }

    // solution method
    static int solution(int index) {
        int answer = 0;

        for(int i=0; i<input[index].size(); i++) {
            int next = input[index].get(i).y;
            input[index].get(i).x = 1 + solution(next);
        }

        Collections.sort(input[index]);

        for(int i=0; i<input[index].size(); i++) {
            input[index].get(i).x += i;
            answer = Math.max(answer, input[index].get(i).x);
        }

        return answer;
    }

    static int N;
    static List<Node>[] input;

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new ArrayList[N];
        for(int i=0; i<N; i++) {
            input[i] = new ArrayList<>();
        }

        // -1 제거
        st.nextToken();

        for(int i=1; i<N; i++) {
            int tempIndex = Integer.parseInt(st.nextToken());
            input[tempIndex].add(new Node(0, i));
        }
        System.out.println(solution(0));
    }
}
