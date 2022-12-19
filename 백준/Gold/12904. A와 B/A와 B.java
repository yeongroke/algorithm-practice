import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // solution method
    static int solution(String input, String word) {
        while(true) {
            if(input.length() == word.length()) {
                if(input.equals(word))
                    return 1;
                return 0;
            }

            char c = word.charAt(word.length() - 1);
            word = word.substring(0, word.length() - 1);

            if(c == 'B')
                word = new StringBuilder(word).reverse().toString();
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String word = br.readLine();

        System.out.println(solution(input, word));
    }
}
