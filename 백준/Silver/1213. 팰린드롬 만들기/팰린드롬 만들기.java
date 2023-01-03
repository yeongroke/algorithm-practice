import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // solution method
    static String solution(String input, int[] array) {
        String answer = "I'm Sorry Hansoo";

        int count = 0;
        int same = 0;
        for(int i=0; i<array.length; i++) {
            if(array[i] % 2 != 0) {
                count ++;
                same = i;
            }
        }

        if(count > 1 || (count == 1 && input.length() % 2 == 0)) {
            return answer;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            for(int j=0; j<array[i]/2; j++) {
                sb.append((char)(i + 'A'));
            }
        }

        answer = sb.toString();

        if(count == 1) {
            answer += (char)(same + 'A');
        }

        answer += sb.reverse().toString();

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] array = new int[26];

        for(int i=0; i<input.length(); i++) {
            array[input.charAt(i) - 'A'] ++;
        }

        System.out.println(solution(input, array));
    }
}
