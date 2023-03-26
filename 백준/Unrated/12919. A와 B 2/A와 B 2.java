import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;

    // solution method
    static int solution(String now, String target) {
        if(now.length() == target.length()) {
            if(now.equals(target)) {
                return 1;
            } else {
                return 0;
            }
        }

        int poss = 0;
        if(now.charAt(0) == 'B') {
            poss += solution(new StringBuilder(now.substring(1)).reverse().toString(), target);
        }
        if(now.charAt(now.length() - 1) == 'A') {
            poss += solution(now.substring(0, now.length() - 1), target);
        }
        return poss > 0 ? 1 : 0;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        System.out.println(solution(T, S));
    }
}
