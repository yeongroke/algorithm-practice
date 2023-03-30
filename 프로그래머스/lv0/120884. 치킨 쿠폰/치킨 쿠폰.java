class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int temp = chicken;

        while(true) {
            int left = temp % 10;
            answer += temp / 10;
            temp = left + temp / 10;
            if(temp < 10) break;
        }
        return answer;
    }
}