import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String input;

    // solution method
    static void solution() {
        int count = 0;
        boolean pass = false;
        if(input.charAt(input.length()-1) == 'P'){
            pass = true;
            for(int i=0; i<input.length(); i++) {
                char nowChar = input.charAt(i);
                if(nowChar == 'P') {
                    count++;
                } else if (nowChar == 'A') {
                    if(input.charAt(i + 1) != 'P' || count < 2) {
                        pass = false;
                        break;
                    }
                    count -= 2;
                }
            }
            if (count != 1) {
                pass = false;
            }
        }
        if(pass) System.out.println("PPAP");
        else System.out.println("NP");
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        solution();
    }
}
