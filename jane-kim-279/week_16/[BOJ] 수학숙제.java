import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<BigInteger> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String input = br.readLine();
            boolean cont = false;

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (Character.isDigit(c)) {
                    sb.append(c);
                    cont = true;
                } else if (Character.isLetter(c)) {
                    cont = false;
                }

                if (!cont && sb.length() > 0) { // 숫자 입력이 끝난 경우
                    answer.add(new BigInteger(sb.toString()));
                    sb.setLength(0);
                }

                if (j == input.length() - 1 && sb.length() > 0) { // 마지막 입력인 경우
                    answer.add(new BigInteger(sb.toString()));
                }
            }
        }

        Collections.sort(answer);
        for (BigInteger l : answer) {
            System.out.println(l);
        }
    }
}
