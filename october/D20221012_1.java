package daliy_2022coding.october;

import java.io.*;
import java.util.Arrays;

/*
* 백준 2447번 재귀 별찍기
* */
public class D20221012_1 {
    // solution method
    static void printStar(String[][] star, int x, int y, int n) {
        if (n == 1) {
            star[x][y] = "*";
            return;
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (!(i == 1 && j == 1)) {
                    printStar(star, x+i*(n/3), y+j*(n/3), n/3);
                }
            }
        }
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String [][] star = new String[n][n];

        for (String[] strings : star) {
            Arrays.fill(strings, " ");
        }
        printStar(star, 0, 0, n);

        for (String[] s : star) {
            for (String string : s) {
                bw.write(string + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
