import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 백준 2565번 전깃줄
 * */
public class D20221025_1 {
    static class Cable {
        int start,end;

        public Cable(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int count;
    static Cable[] cables;
    static int[] dp;
    // solution method
    static int solution(int n) {
        if(dp[n] < 1) {
            dp[n] = 1;

            for(int i = n + 1; i < count; i++) {
                if(cables[n].end < cables[i].end) {
                    dp[n] = Math.max(dp[n], solution(i) + 1);
                }
            }
        }

        return dp[n];
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        StringTokenizer st;
        cables = new Cable[count];
        dp = new int[count];
        for(int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            cables[i] = new Cable(l,r);
        }

        Arrays.sort(cables, Comparator.comparingInt(c -> c.start));

        int max = 0;
        for(int i = 0; i < count; i++) {
            max = Math.max(max, solution(i));
        }

        System.out.print(count - max);
    }
}
