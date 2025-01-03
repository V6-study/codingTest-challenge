package week_14.분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int start = Math.max(1,Integer.parseInt(n) - n.length() * 9);
        int end = Integer.parseInt(n);
        int answer = 0;

        for (int m = start; m <= end; m++) {
            char[] arr = String.valueOf(m).toCharArray();
            int sum = 0;
            for (char c : arr) {
                sum += c - '0';
            }
            sum += m;
            if(end==sum){
                answer = m;
                break;

            }
        }

        System.out.println(answer);

    }
}
