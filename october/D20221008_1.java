package daliy_2022coding.october;

/*
* 프로그래머스 예상 대진표
* */
public class D20221008_1 {
    static int n = 8;
    static int a = 4;
    static int b = 7;

    // solution method
    static int solution(int n, int a, int b) {
        int answer = 0;

        while(true) {
            answer ++;
            a = a/2 + a%2;
            b = b/2 + b%2;
            if(a == b)
                break;
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) {
        System.out.println(solution(n,a,b));
    }
}
