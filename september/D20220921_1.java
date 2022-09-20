package daliy_coding.september;

import java.util.Arrays;

/*
* 프로그래머스 N개의 최소공배수
* */
public class D20220921_1 {
    static int[] arr = {2,6,8,14};

    // solution method
    static int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];
        int min = arr[0];
        for(int i=1; i<arr.length; i++) {
            // 3. 두 값의 최대공약수
            int gcd = gcd(answer,arr[i]);
            // 4. 두 값의 최소공배수
            answer = answer * arr[i] / gcd;
        }

        return answer;
    }

    static int gcd(int a, int b){
        int x = Math.max(a,b);
        int y = Math.min(a,b);

        while(x % y != 0){
            int r = x % y;
            x = y;
            y = r;
        }
        return y;
    }

    // coding test run
    public static void main(String[] args) {
        System.out.println(solution(arr));
    }
}
