package daliy_2022coding.october;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 백준 1978번 소수 찾기
* */
public class D20221009_4 {
    // solution method
    static int solution(int n, String[] input) {
        int answer = 0;

        for(int i=0; i<input.length; i++) {
            int tempCount = 0;
            for(int j=2; j<=Integer.parseInt(input[i]); j++) {
                System.out.println("if 1 : "+ Integer.parseInt(input[i]) + " " + j);
                if(Integer.parseInt(input[i]) % j == 0) {
                    tempCount ++;
                }
                System.out.println("if 2 : "+ tempCount);
                if(tempCount > 1) {
                    break;
                }
            }
            if(tempCount == 1 && Integer.parseInt(input[i]) != 1) {
                answer ++;
            }
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        System.out.println(solution(n, input.split(" ")));
    }
}
