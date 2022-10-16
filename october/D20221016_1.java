package october;

import java.util.Queue;
import java.util.LinkedList;

class D20221016_1 {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
    public int solution(int[][] maps) {
        int ans=bfs(maps);
        if(ans==1) return -1;
        else return ans;
    }

    static int bfs(int [][] maps){
        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0,0));
        int answer=1;
        while(!q.isEmpty()){
            int size =q.size();
            for(int j =0;j<size;j++){
                Pair cur = q.poll();
                if(cur.x==maps.length-1&&cur.y==maps[0].length-1)return answer;

                for(int i =0;i<4;i++){
                    int nx = cur.x - dx[i];
                    int ny = cur.y - dy[i];
                    if(nx>maps.length-1||ny>maps[0].length-1||nx<0||ny<0)continue;
                    if(maps[nx][ny]!=1)continue;
                    maps[nx][ny]=-1;
                    q.offer(new Pair(nx,ny));
                }
            }
            answer++;
        }
        return 1;
    }
}
