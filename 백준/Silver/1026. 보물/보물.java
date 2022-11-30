import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // solution method
    static int solution(int N, int[] first, int[] two) {
        int answer = 0;

        Arrays.sort(first);
        Arrays.sort(two);

        for(int i=two.length-1; i>=0; i--) {
            answer += two[i] * first[two.length-(i+1)];
        }
        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] first = new int[N];
        int[] two = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            two[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(N, first, two));
    }
}
