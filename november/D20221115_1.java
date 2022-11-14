import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class D20221115_1 {
    // r <= a[i].length();
    static int r = 3;
    static int[][] a = { // 0 1 2
    /* 0*/    {1, 0, 0, 0}, // 0
    /* 1*/    {1, 1, 0, 1}, // 0 1
    /* 2*/    {1, 1, 1, 1}, // 0 1 2
    /* 3*/    {1, 0, 1, 1}, // 0 2
    /* 4*/    {1, 1, 0, 1}, // 0 1
    /* 5*/    {0, 1, 1, 1}  // 1 2
    };

    static int solution(int[][] needs , int r) {
        int answer = 0;

        int count = 1;
        ArrayList<String> input = new ArrayList<>();
        for(int i=0; i<needs.length; i++) {
            String temp = "";
            for(int j=0; j<needs[i].length; j++) {
                temp += Integer.toString(needs[i][j]);
                if(needs[i][j] == 1) {
                    count ++;
                }
            }
            input.add(temp);
        }

        Map<String, Integer> dup_count = new HashMap<String, Integer>();

        for(int i = 0 ; i < input.size() ; i++){
            if (dup_count.containsKey(input.get(i))) {
                dup_count.put(input.get(i), dup_count.get(input.get(i))  + 1);
            } else {
                dup_count.put(input.get(i) , 1);
            }
        }
        int max_dup = 0;
        String max_key = "";
        for(String key : dup_count.keySet()) {
            if(max_dup < dup_count.get(key)) {
                max_dup = dup_count.get(key);
                max_key = key;
            }
        }

        ArrayList<Integer> exclude_keys = new ArrayList<>();
        for(int i=0; i<max_key.length(); i++) {
            if(max_key.charAt(i)-'0' == 0) {
                exclude_keys.add(i);
            }
        }

        for(String key : dup_count.keySet()) {
            for(int i=0; i<exclude_keys.size(); i++) {
                if(key.charAt(i) - '0' != 0) {
                    count ++;
                }
            }
            if(count == 0) {
                max_dup += dup_count.get(key);
            }
            count = 0;
        }
        answer = max_dup;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(a,r));
    }
}
