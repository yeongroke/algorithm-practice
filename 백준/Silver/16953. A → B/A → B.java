import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int solution(int one, int two) {
        int answer = 1;

        while (two != one) {
            if(two < one) {
                answer = -1;
                break;
            }
            String str = String.valueOf(two);
            if(two % 2 == 0) {
                two /= 2;
            } else if(str.charAt(str.length() - 1) == '1') {
                str = str.substring(0, str.length() - 1);
                two = Integer.parseInt(str);
            } else {
                answer = -1;
                break;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());

        System.out.println(solution(one, two));
    }
}
