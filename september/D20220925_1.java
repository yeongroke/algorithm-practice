package daliy_coding.september;

import java.util.Arrays;

/*
* 프로그래머스 구명보트
* */
public class D20220925_1 {
    static int[] people = {70, 50, 80, 50};
    static int limit = 100;

    // solution method
    static int solution(int[] people, int limit) {
        int answer = 0;

        int minIndex = 0;

        Arrays.sort(people);

        for(int i=people.length-1; i>=minIndex; i--) {
            if(people[i] + people[minIndex] > limit) {
                answer ++;
            } else {
                minIndex ++;
                answer ++;
            }
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) {
        System.out.println(solution(people, limit));
    }
}
