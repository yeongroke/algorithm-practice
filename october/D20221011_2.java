public class D20221011_2 {
    static String input = "11101010000001010000100100010001";

    static String solution(String bits) {
        StringBuilder sb= new StringBuilder();

        for (int i = 0, j = 8; j <= 32; j += 8, i += 8) {
            String s = bits.substring(i, j);
            int number = 0;
            for (int k = 0; k < 8; k++) {
                if (s.charAt(k) == '1')
                    number += 1 << 7-k;
            }

            sb.append(Integer.toString((number))+'.');
        }
        sb.setLength(sb.length()-1);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(input));
    }
}
