//https://www.acmicpc.net/problem/1697
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        Queue<int[]> pos = new LinkedList<>(); // {time, n} 선입선출
        HashSet<Integer> visit = new HashSet<>();
        pos.add(new int[] {0, n});
        visit.add(n);
        int answer = 0;
        while(!pos.isEmpty() && n != k){
            int[] now = pos.poll();
            // 동생 위치 도달하면 시간 출력 후 break
            if(now[1]+1 == k || now[1]-1 == k || now[1]*2 == k) {
                answer = now[0]+1;
                break;
            }
            // 수빈이 위치 변경

            if(!visit.contains(now[1]+1) && now[1]+1 <= 100000){ // x+1
                visit.add(now[1]+1);
                pos.offer(new int[] {now[0]+1, now[1]+1});
            }
            if(!visit.contains(now[1]-1) && now[1]-1 >= 0){ // x-1
                visit.add(now[1]-1);
                pos.offer(new int[] {now[0]+1, now[1]-1});
            }
            if(!visit.contains(now[1]*2) && now[1]*2 <= 100000){ // x*2
                visit.add(now[1]*2);
                pos.offer(new int[] {now[0]+1, now[1]*2});
            }
        }
        System.out.println(answer);
    }
}
