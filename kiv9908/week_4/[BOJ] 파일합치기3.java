import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long answer = 0;

            while (pq.size() > 1) { 
                long a = pq.poll();
                long b = pq.poll();
                long sum = a + b;
                pq.offer(sum);
                answer += sum;
            }

            System.out.println(answer);
        }
    }
}
