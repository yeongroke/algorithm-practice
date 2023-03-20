import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Garden[] input;

    static class Garden implements Comparable<Garden> {
        int start;
        int end;

        public Garden(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Garden f) {
            if (this.start != f.start) {
                return this.start - f.start;
            } else {
                return -this.end + f.end;
            }
        }
    }

    // solution method
    static void solution() {
        Arrays.sort(input);
        int startDay = 301;
        int endDay = 1201;
        int count = 0;
        int max = 0;
        int startIndex = 0;
        boolean isValid = false;

        while(startDay < endDay) {
            isValid = false;
            for(int i=startIndex; i<N; i++) {
                if(input[i].start > startDay)
                    break;
                if(max < input[i].end) {
                    max = input[i].end;
                    startIndex = i + 1;
                    isValid = true;
                }
            }
            if(isValid) {
                startDay = max;
                count += 1;
            } else {
                break;
            }
        }
        
        if(max < endDay) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        input = new Garden[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = new Garden(Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken()));
        }
        solution();
    }
}
