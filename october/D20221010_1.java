package laund;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class D20221010_1 {

    static int solution(String s) {

        // aabbbbaaaaabbabbbaaaa
        // 2 4 5 2 1 3 4
        // 3 1 0 3 4 2 1
        // 14
        StringBuilder sb = new StringBuilder(s);

        List<Integer> list = new ArrayList<>();

        int answer = 0;
        int cnt = 1;
        int max = 0;
        for(int i=0; i<s.length()-1; i++) {
            while (i < s.length()-1 && sb.charAt(i) == sb.charAt(i + 1)){
                cnt++;
            }
            if (max < cnt) {
                max = cnt;
            }
            list.add(cnt);
            cnt = 1;
        }

        for(int a : list){
            answer += max - a;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution("aabbbbaaaaabbabbbaaaa"));
    }
}
