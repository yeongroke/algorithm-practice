package daliy_2022coding.october;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 백준 11720번 숫자의합
*
* */
public class D20221009_2 {
    // solution method
    static int solution(int n, String ints) {
        int answer = 0;

        for(int i=0; i<n; i++) {
            answer += ints.charAt(i) - '0';
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ints = br.readLine();
        ints = br.readLine();
        System.out.println("input -> : "+n+", "+ints);
        System.out.println(solution(n, ints));
    }
}
