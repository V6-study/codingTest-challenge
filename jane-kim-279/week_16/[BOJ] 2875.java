import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int answer = 0;
        while (n >= 2 && m >= 1 && n + m - k >= 3) {
            answer++;
            n -= 2;
            m -= 1;            
        }
        System.out.println(answer);
    }
}
