class Solution {
    static final int MAX_TIME = 1_450;
    static final int HOUR = 60;
    static final int CLEAN_TIME = 10;

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] rooms = new int[MAX_TIME];

        for(String[] now : book_time) {
            String in = now[0];
            String out = now[1];

            rooms[calTime(in)] += 1;
            rooms[calTime(out) + CLEAN_TIME] += -1;
        }

        for(int i=1; i<MAX_TIME; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }

        return answer;
    }

    private static int calTime(String time){
        String[] split = time.split(":");
        return ((Integer.parseInt(split[0]) * HOUR) + Integer.parseInt(split[1]));
    }
}