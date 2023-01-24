import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        for(int tempIndex=0; tempIndex<T; tempIndex++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            boolean[] check = new boolean[N+1];
            int[][] input = new int[M][2];
            int answer = 0;

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                input[i][0] = Integer.parseInt(st.nextToken());
                input[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input, Comparator.comparingInt(o -> o[1]));

            for(int i=0; i<M; i++) {
                for(int j=input[i][0]; j<=input[i][1]; j++) {
                    if(!check[j]) {
                        answer ++;
                        check[j] = true;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
