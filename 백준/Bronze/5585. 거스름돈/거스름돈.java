import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // solution method
    static int solution(int n) {
        int answer = 0;

        int[] money = {
                500,100,50,10,5,1
        };

        n = 1000 - n;

        int index = 0;
        while(n > 0) {
            if(money[index] <= n) {
                int moneyCount = n / money[index];
                answer += moneyCount;
                n -= money[index] * moneyCount;
            }
            index ++;
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
}
