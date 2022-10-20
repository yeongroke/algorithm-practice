import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class D20221020_1 {
    static int n,k;
    static int arr[][];
    static Map<String , Integer> cntArr;

    static void solution(int a , int b , int[][] c){

        for(int i=0; i<c.length; i++) {
            for(int j=0; j<c[i].length; j++) {
                if(!cntArr.containsKey(c[i][j])) {
                    cntArr.put(Integer.toString(c[i][j]),1);
                } else {
                    cntArr.put(Integer.toString(c[i][j]),cntArr.get(Integer.toString(c[i][j])) + 1);
                }
            }
        }
        Stream<Map.Entry<String, Integer>> sorted =
                cntArr.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue());
        sorted.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        solution(n,k,arr);
    }
}
