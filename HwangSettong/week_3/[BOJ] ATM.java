// https://www.acmicpc.net/problem/11399
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(p);
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += p[i] * (n-i);
        }
        System.out.println(answer);

    }
}
