package daliy_coding.september;

import java.util.Arrays;

/*
* 프로그래머스 최고의집합
* */
public class D20200915 {

    static int inputA = 2;
    static int inputB = 9;

    /*
    * n은 집함의 원소의 개수
    * s는 모든 원소들의 합
    * 1 8
    * 2 7
    * 3 6
    * 4 5
    *
    * 1 7
    * 2 6
    * 3 5
    * 4 4
    * */
    static int[] solution(int n, int s) {
        if(n > s)
            return new int[]{-1};
        
        int[] answer = new int[n];

        int maxIndex = s%n;

        for(int i=0; i<answer.length; i++) {
            answer[i] = s/n;
            if(i < maxIndex)
                answer[i] ++;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        for (int i : solution(inputA, inputB)) {
            System.out.println(i);
        }
    }
}
