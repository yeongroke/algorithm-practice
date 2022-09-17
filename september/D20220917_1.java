package daliy_coding.september;

/*
* 프로그래머스 피보나치 수
* */
public class D20220917_1 {
    // solution method
    static int solution(int n) {
        int[] answer = new int[n+1];

        for(int i=0; i<=n; i++) {
            if(i == 0) answer[i] = 0;
            else if(i ==1) answer[i] = 1;
            else {
                int sum = answer[i-2] + answer[i-1];
                answer[i] = sum % 12345667;
            }
        }

        return answer[n];
    }

    // coding test run
    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
