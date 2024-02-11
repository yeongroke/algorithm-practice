import java.util.Stack;

class Solution {
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> input = new Stack<>();

        for(int i=numbers.length-1; i>=0; i--){
            while(!input.isEmpty()){
                if(input.peek() > numbers[i]) {
                    answer[i] = input.peek();
                    break;
                } else {
                    input.pop();
                }
            }
            if(input.isEmpty()) {
                answer[i] = -1;
            }
            input.push(numbers[i]);
        }
        return answer;
    }
}