// https://www.acmicpc.net/problem/13549
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)-> o1[1] - o2[1]); // {위치, 시간}을 담는다. 시간이 짧은 것 부터 dequeue
        HashSet<Integer> visit = new HashSet<>(); // q에 담긴 적 있는 위치를 저장
        q.offer(new int[]{n, 0});
        visit.add(n);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] < 0 || cur[0] > 100000) continue; // 가능한 위치 범위를 벗어남.
            visit.add(cur[0]); // 방문 처리
            // 만약 현재 위치가 k와 같으면 시간 출력하고 loop 탈출
            if(cur[0] == k){
                System.out.println(cur[1]);
                break;
            }
            // x+1 로 이동. x가 k보다 작아야 의미가 있음.
            if(cur[0] < k && !visit.contains(cur[0] + 1)){
                q.offer(new int[]{cur[0]+1, cur[1] + 1});
            }
            // x-1 로 이동. x가 0보다 커야 의미가 있음.
            if(!visit.contains(cur[0]-1)){
                q.offer(new int[]{cur[0]-1, cur[1] + 1});
            }
            // 2*x로 순간이동(시간 0초 걸림). x가 k보다 작아야 의미가 있음.
            if(cur[0] < k && !visit.contains(2*cur[0])){
                q.offer(new int[]{2*cur[0], cur[1]});
            }
        }
    }
}
