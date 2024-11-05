import java.util.*;
import java.io.*;

public class Main
{        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MAX_VALUE;
        String input = br.readLine();
        
        String[] subtract = input.split("-");
        for (int i = 0; i < subtract.length; i++) {
            int temp = 0;
            
            // -를 기준으로 나눈 문자열끼리 더해준다.
            String[] addition = subtract[i].split("\\+");
            for (int j = 0; j < addition.length; j++) {
                temp += Integer.parseInt(addition[j]);
            }
            
            // 첫 번째 숫자인지 판별한다.
            if (answer == Integer.MAX_VALUE) {
                answer = temp;
            } else {
                answer -= temp;
            }
        }
        System.out.println(answer);
    }
}
