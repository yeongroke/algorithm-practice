import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // solution method
    static String solution(String input) {
        String answer = "";
        String A = "AAAA", B = "BB";

        input = input.replaceAll("XXXX", A);
        answer = input.replaceAll("XX", B);

        if(answer.contains("X")) {
            answer = "-1";
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
