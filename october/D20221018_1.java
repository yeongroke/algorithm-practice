public class D20221018_1 {

    static int nx = 0;
    static int ny = 0;

    static class Pair {
        int x;
        Boolean boom;
        Pair(int x , boolean boom) {
            this.x = x;
            this.boom = boom;
        }
    }

    static Pair[][] solution(Pair[][] boomMaps) {
        for(int i=0; i<boomMaps.length; i++) {
            nx = i;
            for(int j=0; j<boomMaps[i].length; j++) {
                ny = j;
                int ans=findBoom(boomMaps);
                if(ans==0) {
                    boomMaps[i][j].x = 0;
                } else {
                    boomMaps[i][j].x = ans;
                }
            }
        }
        return boomMaps;
    }

    static int findBoom(Pair [][] boomMap){
        int dx[]={0,1,0,-1, 1,-1,-1,1};
        int dy[]={1,0,-1,0, 1,1,-1,-1};
        int count = 0;
        for(int i=0; i<8; i++) {
            if(nx==boomMap.length-1&&ny==boomMap[0].length-1) return count;
            int nowx = dx[i] + nx;
            int nowy = dy[i] + ny;

            if(nowx>boomMap.length-1||nowy>boomMap[0].length-1||nowx<0||nowy<0) continue;
            if(boomMap[nowx][nowy].boom != true) continue;
            count ++;
        }

        return count;
    }

    public static void main(String[] args) {
        Pair[][] boomArray = new Pair[10][10];
        for(int i=0; i<boomArray.length; i++) {
            for(int j=0; j<boomArray[i].length; j++) {
                boomArray[i][j] = new Pair(0, false);
            }
        }
        boomArray[0][3] = new Pair(0, true);
        boomArray[1][1] = new Pair(0, true);
        boomArray[1][2] = new Pair(0, true);
        boomArray[1][5] = new Pair(0, true);
        boomArray[3][4] = new Pair(0, true);
        boomArray[4][8] = new Pair(0, true);
        boomArray[5][5] = new Pair(0, true);
        boomArray[7][8] = new Pair(0, true);
        boomArray[8][6] = new Pair(0, true);
        boomArray[9][5] = new Pair(0, true);

        Pair[][] setBoomArray = solution(boomArray);

        for(int i=0; i<setBoomArray.length; i++) {
            for(int j=0; j<setBoomArray[i].length; j++) {
                System.out.print(setBoomArray[i][j].x + " ");
            }
            System.out.println();
        }
    }
}
