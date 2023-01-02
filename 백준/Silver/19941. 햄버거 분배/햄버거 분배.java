import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // solution method
    static int solution(int N, int T, char[] input) {
        int answer = 0;

        boolean[] eat = new boolean[N];

        for(int i=0; i<N; i++){
            if(input[i] == 'P') {
                int startIndex = Math.max(i-T, 0);
                int endIndex = Math.min(i+T, N-1);

                for(int j=startIndex; j<=endIndex; j++){
                    if(input[j] == 'H' && !eat[j]){
                        eat[j] = true;
                        answer ++;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        char[] input = new char[N];
        for(int i=0; i<N; i++) {
            input[i] = s.charAt(i);
        }

        System.out.println(solution(N, T, input));
    }
}
