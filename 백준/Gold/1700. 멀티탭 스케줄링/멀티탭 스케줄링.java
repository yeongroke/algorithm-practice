import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // solution method
    static int solution(int N, int K, int[] input) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<K; i++) {
            if(!set.contains(input[i])) {
                if (N <= set.size()) {
                    List<Integer> list = new ArrayList<>();
                    Set<Integer> other = new HashSet<>(set);

                    for(int j=i; j<K; j++) {
                        if(set.contains(input[j]) && !list.contains(input[j])) {
                            list.add(input[j]);
                            other.remove(input[j]);
                        }
                    }

                    if(list.size() == N) {
                        set.remove(list.get(list.size() - 1));
                    } else {
                        set.remove(List.of(other).get(0));
                    }
                    answer++;
                }
                set.add(input[i]);
            }
        }
        return answer;
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] input = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, K, input));
    }
}
