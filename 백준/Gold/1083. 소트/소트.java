import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static List<Integer> input = new ArrayList<>();

    // solution method
    static void solution() {
        int now = 0, newIndex = 0;
        while(now < S && newIndex < N - 1) {
            int maxNum = input.get(newIndex), maxIdx = -1;

            int idx = newIndex + 1, count = 1;
            while(now+count <= S && idx < N) {
                int num = input.get(idx);
                if(num > maxNum) {
                    maxNum = num;
                    maxIdx = idx;
                }
                count++;
                idx++;
            }

            if(maxIdx != -1) {
                input.remove(maxIdx);
                input.add(newIndex, maxNum);
                now += maxIdx - newIndex;
            }
            newIndex++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : input) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            input.add(Integer.parseInt(st.nextToken()));
        }
        S = Integer.parseInt(br.readLine());

        solution();
    }
}
