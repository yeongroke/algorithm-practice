import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] boys, girls;
    static int[][] min;

    // solution method
    static void solution() {
        Arrays.sort(boys);
        Arrays.sort(girls);

        for(int i=1; i<=boys.length; i++) {
            for(int j=1; j<= girls.length; j++) {
                min[i][j] = min[i-1][j-1] + Math.abs(boys[i-1] - girls[j-1]);

                if(i > j) {
                    min[i][j] = Math.min(min[i][j], min[i-1][j]);
                }

                if(i < j) {
                    min[i][j] = Math.min(min[i][j], min[i][j - 1]);
                }
            }
        }

        System.out.println(min[N][M]);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boys = new int[N];
        girls = new int[M];
        min = new int[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            boys[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            girls[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}
