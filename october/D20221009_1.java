package daliy_2022coding.october;

import java.util.Scanner;

/*
* 백준 1110번 더하기 사이클
*
* */
public class D20221009_1 {
    // solution method
    static int solution(int n) {
        int answer = 0;
        int copy = n;

        while(true) {
            n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);
            answer ++;
            if(n == copy)
                break;
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution(n));
    }
}
