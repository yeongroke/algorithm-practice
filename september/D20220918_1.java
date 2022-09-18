package daliy_coding.september;

import java.util.Stack;

public class D20220918_1 {

    // solution method
    static int solution(String s) {
        if(s.length() <= 1)
            return 0;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }

    // coding test run
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }
}
