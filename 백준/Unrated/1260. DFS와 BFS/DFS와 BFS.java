import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[][] xy;
    static boolean[] pass;
    static Queue<Integer> queue;

    // solution method

    static void dfs(int start) {
        pass[start] = true;
        System.out.print(start + " ");
        for(int i=1; i<=N; i++) {
            if(xy[start][i] == 1 && !pass[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        queue = new LinkedList<>();
        queue.add(start);
        pass[start] = true;
        System.out.print(start + " ");
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i=1; i<xy.length; i++) {
                if(xy[temp][i] == 1 && !pass[i]) {
                    queue.add(i);
                    pass[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        xy = new int[1001][1001];
        pass = new boolean[1001];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            xy[tx][ty] = xy[ty][tx] = 1;
        }

        dfs(V);
        System.out.println();
        Arrays.fill(pass, false);
        bfs(V);
    }
}
