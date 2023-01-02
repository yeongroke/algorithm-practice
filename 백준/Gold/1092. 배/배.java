import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // solution method
    static int solution(int N, int B, List<Integer> weight, List<Integer> box) {
        int answer = 0;

        weight.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if(weight.get(0) < box.get(0)){
            return -1;
        }

        while(!box.isEmpty()){
            int tempIndex = 0;
            for(int i=0; i<weight.size(); i++) {
                if(tempIndex == box.size()) {
                    break;
                } else if(weight.get(i) >= box.get(tempIndex)){
                    box.remove(tempIndex);
                } else {
                    tempIndex ++;
                    i--;
                }
            }
            answer++;
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> weight = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            weight.add(Integer.parseInt(st.nextToken()));
        }

        int B = Integer.parseInt(br.readLine());

        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution(N, B, weight, box));
    }
}
