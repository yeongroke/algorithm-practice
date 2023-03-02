import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, D, F;
    static int[][] temp;
    static PriorityQueue<Integer> input = new PriorityQueue<>(Collections.reverseOrder());

    // solution method
    static void solution() {
        int count = 0;
        int index = 0;

        Arrays.sort(temp, Comparator.comparingInt(o -> o[0]));

        while(F < D) {
            while(index < temp.length && temp[index][0] <= F) {
                input.offer(temp[index++][1]);
            }

            if(input.isEmpty()) {
                count =- 1; break;
            } else {
                count++;
                F += input.poll();
            }
        }
        System.out.println(count);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        temp = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            temp[i][0] = Integer.parseInt(st.nextToken());
            temp[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        solution();
    }
}
