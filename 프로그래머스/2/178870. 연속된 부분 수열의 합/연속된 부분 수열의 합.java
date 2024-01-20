class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int start = 0;
        int end = -1;
        int size = sequence.length;
        int[] answer = new int[] {0,size};

        while(true){
            if(sum <= k){
                if(sum == k && answer[1] - answer[0] > end - start)
                    answer = new int[]{start, end};

                end++;

                if(end >= size)
                    break;
                sum += sequence[end];
            }else{
                sum -= sequence[start];
                start++;
            }
        }
        return answer;
    }
}