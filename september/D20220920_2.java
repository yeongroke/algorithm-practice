package daliy_coding.september;

import java.util.Objects;
import java.util.Stack;

/*
* 프로그래머스 영어 끝말잇기
* */
public class D20220920_1 {
    static int n = 2;
    static String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

    // coding test run
    public static void main(String[] args) {
        for (int i : solution(n, words)) {
            System.out.println(i);
        }
    }
}
