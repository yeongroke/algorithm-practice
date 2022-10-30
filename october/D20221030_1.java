/*
* LeetCode - Medium
* 45. Jump Game II
* */
public class D20221030_1 {
    // solution method
    static int solution(int[] nums) {
        if(nums.length == 1)
            return 0;
        int answer = 0;

        int nowIndex = 0, nextIndex = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nextIndex < nums[i] + i)
                nextIndex = nums[i] + i;
            if(i == nowIndex) {
                nowIndex = nextIndex;
                answer ++;
            }
        }

        return answer;
    }

    static int[] nums = {2,3,1,1,4};

    // coding test run
    public static void main(String[] args) {
        System.out.println(solution(nums));
    }
}
