import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // solution method
    static int solution(int N, int T, int[] input) {
        int answer = 0;

        int[] team = new int[N-1];
        for(int i=0; i<N-1; i++) {
            team[i] = input[i+1] - input[i];
        }

        Arrays.sort(team);
        for(int i=0; i<N-T; i++) {
            answer += team[i];
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, T, input));
    }
}
