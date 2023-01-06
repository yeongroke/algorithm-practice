import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // solution method
    static int solution(int N, int[][] input) {
        int answer = 0;

        Arrays.sort(input, (o1, o2) -> o2[0]-o1[0]);

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int tempIndex = 0;

        for(int dDay=input[0][0]; dDay>0; dDay--) {
            while(tempIndex < N && input[tempIndex][0] == dDay) {
                q.add(input[tempIndex][1]);
                tempIndex ++;
            }
            if(!q.isEmpty()) {
                answer += q.poll();
            }
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
