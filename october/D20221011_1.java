
import java.io.IOException;
import java.util.Arrays;

public class D20221011_1 {
    static int a;
    static int[][] input={
            {3,3},{2,2},{1,1}
    };

    static int solution(int n, int[][] trees) {
        int answer = 1;

        Arrays.sort(trees,(i,j)->Integer.compare(i[0],j[0]));

        int x,y;
        x = trees[0][0];
        y = trees[0][1];
        for(int i=1; i<trees.length; i++) {
            if(x<trees[i][0] && y<trees[i][1]) continue;
            x = trees[i][0];
            y = trees[i][1];
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution(5,input));
    }
}
