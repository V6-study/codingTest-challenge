import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int k = Integer.parseInt(st.nextToken());
       int n = Integer.parseInt(st.nextToken());
       int[] arr = new int[k];
       for (int i = 0; i < k; i++) {
           arr[i] = Integer.parseInt(br.readLine());
       }
       Arrays.sort(arr);
       long low = 1;
       long high = arr[k-1];
       long answer = 0;
       while (low <= high) {
           long mid = (low + high) / 2;
           int count = 0;
           for (int i : arr) {
               count += (i / mid);
           }
           if (count >= n) {
               low = mid + 1;
               answer = mid;
           } else {
               high = mid - 1;
           }
       }
       System.out.println(answer);
   }
}