import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = input[0];
        int b = input[1];
        int answer = 0;
        while (a != b) {
            if (a > b) {
                answer = -1;
                break;
            }
            if (b % 2 != 0 && b % 10 != 1) {
                answer = -1;
                break;
            }           

            if (b % 10 == 1) {
                answer++;
                b /= 10;
            } else if (b % 2 == 0) {
                answer++;
                b /= 2;
            }
        }
        answer = answer == -1 ? -1 : answer + 1; 
        System.out.println(answer);
    }
}
