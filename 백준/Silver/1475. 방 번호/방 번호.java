import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String N;
    static int[] input;
    // solution method
    static void solution() {
        input = new int[10];

        for(char c : N.toCharArray()) {
            int num = c - '0';
            if(num == 9)
                num = 6;
            input[num]++;
        }

        input[6] = (input[6]/2) + (input[6]%2);

        Arrays.sort(input);

        System.out.println(input[9]);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        
        solution();
    }
}
