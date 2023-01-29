import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class box implements Comparable<box> {
        int fromNum;
        int toNum;
        int boxCount;

        public box(int toNum, int fromNum, int boxCount) {
            this.fromNum = toNum;
            this.toNum = fromNum;
            this.boxCount =  boxCount;
        }

        @Override
        public int compareTo(box o) {
            if(this.toNum == o.toNum) return this.fromNum-o.fromNum;
            return this.toNum-o.toNum;
        }
    }

    static int N, C, M;
    static box[] boxes;

    // solution method
    static void solution() {
        Arrays.sort(boxes);

        int box[] = new int[N+1];
        int max, tempCount, total = 0;
        for(int i=0; i<M; i++) {
            max = 0;
            for(int j=boxes[i].fromNum; j<boxes[i].toNum; j++) {
                max = Math.max(max, box[j]);
            }
            tempCount = Math.min(C-max, boxes[i].boxCount);
            total += tempCount;
            for(int j=boxes[i].fromNum; j<boxes[i].toNum; j++) {
                box[j] += tempCount;
            }
        }
        System.out.println(total+box[N]);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        boxes = new box[M];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            boxes[i] = new box(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        solution();
    }
}
