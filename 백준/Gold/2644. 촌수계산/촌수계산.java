import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2644 {
    static List<Integer>[] input;
    static boolean[] passed;
    static int answer = -1;
    static int x,y;

    // solution method
    static void solution() {
        dfs(x,y, 0);
        System.out.println(answer);
    }

    static void dfs(int start, int end, int cnt) {
        if(start == end) {
            answer = cnt;
            return;
        }

        passed[start] = true;
        for(int i = 0; i< input[start].size(); i++) {
            int next = input[start].get(i);
            if(!passed[next]) {
                dfs(next, end, cnt+1);
            }
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        input = new ArrayList[n+1];
        passed = new boolean[n+1];
        for(int i=1; i<n+1; i++) {
            input[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int l = Integer.parseInt(br.readLine());

        for(int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            input[p].add(c);
            input[c].add(p);
        }

        solution();
    }
}
