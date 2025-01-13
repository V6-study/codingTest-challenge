import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N,M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 나무 높이 입력 받기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        // 자를 수 있는 나무 최소 수 탐색
        long sum = 0L;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sum += cur;
            if(sum - ((long) (pq.isEmpty() ? 0 : pq.peek()) * (N-pq.size())) >= M) break;
        }
        // 절단기 높이 h의 최댓값 탐색
        // h = (sum-M) / 자를 수 있는 나무 수
        System.out.println( (int) Math.ceil( (sum-M) / (N - pq.size()) ) );
    }
}
