import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(sc.nextLine());
        }    
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k / coins[i] > 0) {
                count += (k/coins[i]);
                k -= (k/coins[i])*coins[i];
            }
        }
        System.out.println(count);
    }
}
