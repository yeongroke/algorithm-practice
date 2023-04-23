import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char input[];
    static int K, size;
    static int answer = -1;
    static boolean[][] pass;
    static Queue<Pair> q = new LinkedList<>();
    static class Pair{
        int index;
        int count;
        public Pair(int index, int count) {
            super();
            this.index = index;
            this.count = count;
        }
    }

    static void solution() {
        size = input.length;
        int a = Integer.parseInt(String.valueOf(input));

        pass[a][0] = true;
        q.add(new Pair(a, 0));

        while(!q.isEmpty()) {
            Pair temp = q.poll();
            char[] tempIndex = String.valueOf(temp.index).toCharArray();

            if(temp.count == K) {
                answer = Math.max(answer, temp.index);
                continue;
            }

            for(int i=0; i<size-1; i++) {
                for(int j=i+1; j<size; j++) {
                    char buf = tempIndex[i];
                    tempIndex[i] = tempIndex[j];
                    tempIndex[j] = buf;
                    a = Integer.parseInt(String.valueOf(tempIndex));

                    if(tempIndex[0] == '0' || pass[a][temp.count + 1]) {
                        buf = tempIndex[i];
                        tempIndex[i] = tempIndex[j];
                        tempIndex[j] = buf;
                        continue;
                    }

                    pass[a][temp.count + 1] = true;
                    q.add(new Pair(a, temp.count + 1));
                    buf = tempIndex[i];
                    tempIndex[i] = tempIndex[j];
                    tempIndex[j] = buf;
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());
        pass = new boolean[1000001][11];

        solution();
    }
}
