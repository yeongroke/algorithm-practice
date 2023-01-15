import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, S;
    static Position[] input;

    // solution method
    static int solution(int start, int target, boolean left) {
        int nowCap = K;
        int nowLoc = start;
        int answer = 0, nowTarget = 0, finish = 0;

        while (finish<target) {
            if(nowCap == 0) {
                answer += (nowTarget*2);
                nowCap = K;
                nowTarget = 0;
            }
            if(input[nowLoc].cap<=nowCap) {
                nowCap -= input[nowLoc].cap;
                nowTarget = Math.max(nowTarget, Math.abs(S - input[nowLoc].loc));
            } else {
                nowTarget=Math.max(nowTarget,Math.abs(S - input[nowLoc].loc));
                input[nowLoc].cap -= nowCap;
                answer += (nowTarget*2);
                nowTarget = Math.abs(S-input[nowLoc].loc);
                int div = input[nowLoc].cap/K;
                int mod = input[nowLoc].cap%K;
                answer += (nowTarget*div*2);
                if(mod == 0) {
                    nowTarget = 0;
                    nowCap = K;
                } else {
                    nowCap = K-mod;
                }
            }
            if(left) nowLoc ++;
            else nowLoc --;
            finish ++;
        }
        answer += (nowTarget * 2);
        return answer;
    }

    static class Position implements Comparable<Position> {
        int loc;
        int cap;

        public Position(int loc, int cap) {
            this.loc = loc;
            this.cap = cap;
        }

        @Override
        public int compareTo(Position o) {
            return this.loc-o.loc;
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        input = new Position[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            input[i] = new Position(loc, Integer.parseInt(st.nextToken()));
            if(loc < S) left ++;
        }
        Arrays.sort(input);

        System.out.println(solution(0, left,true)+ solution(N-1, N-left,false));
    }
}
