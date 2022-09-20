package daliy_coding.september;

import java.util.Objects;
import java.util.Stack;

/*
* 프로그래머스 영어 끝말잇기
* */
public class D20220920_1 {
    static int n = 2;
    static String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

    // solution method
    static int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        Stack<String> stack = new Stack<>();
        for(int i=0; i< words.length; i++) {
            System.out.println("i -> " +i);
            if(stack.contains(words[i])
                    || (!stack.isEmpty() && !Objects.equals(stack.peek().charAt(stack.peek().length()-1), words[i].charAt(0)))) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;

                break;
            } else {
                stack.add(words[i]);
            }
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) {
        for (int i : solution(n, words)) {
            System.out.println(i);
        }
    }
}
