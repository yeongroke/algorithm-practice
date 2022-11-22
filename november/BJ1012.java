import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1012 {
    static int[][] map;
    static boolean[][] check;
    static int cnt=0;
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {1,-1,0,0};
    static int m,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i<t;i++){
            m = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            map = new int[m][n];
            check = new boolean[m][n];
            for(int j = 0; j<k;j++){
                int x = Integer.parseInt(br.readLine());
                int y = Integer.parseInt(br.readLine());

                map[x][y] = 1;
            }
            for(int x = 0; x<m;x++){
                for(int y = 0; y<n;y++){
                    if(map[x][y] == 1 && !check[x][y]){
                        cnt++;
                        dfs(x,y);
                    }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }

    private static void dfs(int x, int y) {
        check[x][y] = true;

        for(int i = 0; i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx <m && ny<n){
                if(map[nx][ny] == 1 && !check[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}
