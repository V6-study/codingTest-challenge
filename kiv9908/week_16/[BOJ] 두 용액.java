import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr;
    // -99 -2 -1 4 98
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] result = twoPointer();
        System.out.println(result[0] + " " + result[1]);

    }

    private static int[] twoPointer() {
        int start = 0;
        int end = n - 1;
        int minSum = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while(start < end) {
            int sum = arr[start] + arr[end];
            if (Math.abs(sum)<Math.abs(minSum)) {
                minSum = sum;
                left = arr[start];
                right = arr[end];
            }
            if (sum < 0) {
                start++;
            }else{
                end--;
            }
        }
        return new int[]{left,right};

    }
}
