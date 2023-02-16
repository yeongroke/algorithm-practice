import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] input;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    // solution method
    static void solution() {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(1, 1));
        visited[1][1] = true;
        while(!q.isEmpty()) {
            Point point = q.remove();
            for(int i=0; i<dx.length; i++) {
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];
                if(xx > 0 && yy > 0 && xx <= M && yy <= N) {
                    if(input[yy][xx] != 0 && !visited[yy][xx]) {
                        visited[yy][xx] = true;
                        input[yy][xx] = input[point.y][point.x] + 1;
                        q.add(new Point(xx, yy));
                    }
                }
            }
        }

        System.out.println(input[N][M]);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i=1; i<=N; i++) {
            String[] temp = br.readLine().split("");
            for(int j=1; j<=M; j++) {
                input[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        solution();
    }
}
