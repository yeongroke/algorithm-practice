package daliy_2022coding.october;

import java.util.*;

/*
* 프로그래머스 올바른 괄호
* */
public class D20221007_1 {

    static String s = "(())())";

    // solution method
    static boolean solution(String s) {
        boolean answer = true;

        if(s.charAt(0) == ')')
            return false;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty() && s.charAt(i) == ')')
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }

    // coding test run
    public static void main(String[] args) {
        System.out.println(solution(s));
    }
}
