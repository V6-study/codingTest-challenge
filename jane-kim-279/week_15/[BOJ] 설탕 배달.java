import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n % 5 != 0) {
            n -= 3;
            count++;
        }
        if (n < 0) count = -1;
        else count += n / 5;
        System.out.println(count);
    }
}
