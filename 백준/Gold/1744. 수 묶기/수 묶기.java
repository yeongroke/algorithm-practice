import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    // solution method
    static int solution(int N, List<Integer> p, List<Integer> m, int zeroCount, int oneCount) {

        Collections.sort(p);
        Collections.reverse(p);
        Collections.sort(m);

        if(p.size()%2 == 1) {
            p.add(1);
        }

        if(m.size()%2 == 1) {
            if(zeroCount > 0) {
                m.add(0);
            }
            else {
                m.add(1);
            }
        }

        int answer = oneCount;
        for(int i=0; i<p.size(); i+=2) {
            answer += p.get(i) * p.get(i+1);
        }
        for(int i=0; i<m.size(); i+=2) {
            answer += m.get(i) * m.get(i+1);
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> p = new ArrayList<>();
        List<Integer> m = new ArrayList<>();

        int zeroCount = 0;
        int oneCount = 0;

        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp == 1)
                oneCount ++;
            else if (temp > 0)
                p.add(temp);
            else if (temp < 0)
                m.add(temp);
            else
                zeroCount ++;
        }

        System.out.println(solution(N, p, m, zeroCount, oneCount));
    }
}
