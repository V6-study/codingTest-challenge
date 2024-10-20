// https://www.acmicpc.net/problem/21758
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] honey = new long[n];
        long totalHoney = 0;
        long answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            honey[i] = Long.parseLong(st.nextToken());
            totalHoney += honey[i];
        }

        // 벌 왼쪽 고정, 꿀통 오른쪽 고정
        long fixSum = totalHoney - honey[0];
        long moveSum = fixSum;
        for (int i = 1; i < n-1; i++) {
            long sum = fixSum - honey[i];
            moveSum -= honey[i];
            sum += moveSum;
            answer = Math.max(answer, sum);
        }

        // 벌 오른쪽 고정, 꿀통 왼쪽 고정
        fixSum = totalHoney - honey[n-1];
        moveSum = fixSum;
        for (int i = n-2; i > 0; i--) {
            long sum = fixSum - honey[i];
            moveSum -= honey[i];
            sum += moveSum;
            answer = Math.max(answer, sum);
        }

        // 벌 양쪽, 꿀통 움직임
        long bee1 = 0;
        long bee2 = totalHoney - honey[n-1] ;
        for (int i = 1; i < n-1; i++) {
            bee1 += honey[i];
            bee2 -= honey[i-1];
            answer = Math.max(answer, bee1+bee2);
        }
        System.out.println(answer);
    }
}
