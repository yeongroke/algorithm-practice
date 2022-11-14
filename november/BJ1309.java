package daliy_2022coding.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 백준 1309 
* */
public class BJ1309 {
    // solution method
    static int solution(int n) {
        int[][] dp = new int[n+1][3];

        Arrays.fill(dp[1], 1);
        for(int i=2; i<=n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] +dp[i-1][2])%9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
        }

        return (dp[n][0] + dp[n][1] + dp[n][2])%9901;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
}
