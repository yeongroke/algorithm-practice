package daliy_coding.daliy_2023coding.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1114 {
    static int L, K, C;
    static int[] input;

    // solution method
    static int[] solution() {
        int[] temp = new int[2];
        int left = 1;
        int right = L;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tempCount = check(mid);
            if(tempCount != -1) {
                temp[0] = mid;
                temp[1] = tempCount;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return temp;
    }

    private static int check(int len) {
        int left = K;
        int right = K;
        int temp = 0;
        while(true) {
            left--;
            if(input[right] - input[left] > len) {
                if(left + 1 == right) {
                    return -1;
                }
                right = left + 1;
                left = left + 1;
                temp++;
            }
            if (left == 0) {
                break;
            }
            if (temp == C) {
                break;
            }
        }
        if(input[right] - input[left] > len) {
            return -1;
        }
        if(input[left] > len) {
            return -1;
        }
        return input[left];
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new int[K+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        input[K] = L;
        Arrays.sort(input);

        System.out.println(solution()[0] + " " + solution()[1]);;
    }
}
