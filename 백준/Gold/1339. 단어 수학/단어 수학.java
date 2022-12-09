import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    // solution method
    static void solution(Integer[] alpha) {
        Arrays.sort(alpha, Collections.reverseOrder());

        int value = 9, answer = 0;

        for(int i=0; i<alpha.length; i++) {
            if(alpha[i] == 0) {
                break;
            }
            answer += alpha[i] * value--;
        }

        System.out.println(answer);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] alpha = new Integer[26];

        Arrays.fill(alpha, 0);

        for(int i=0; i<n; i++) {
            char[] input = br.readLine().toCharArray();
            int index = 1;

            for(int j=input.length-1; j>=0; j--) {
                alpha[input[j] - 'A'] += index;
                index *= 10;
            }
        }
        solution(alpha);
    }
}
