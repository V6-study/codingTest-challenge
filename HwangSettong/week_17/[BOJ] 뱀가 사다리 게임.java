// https://www.acmicpc.net/problem/16928
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> warp = new HashMap<>();
        for (int i = 0; i < n+k; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            warp.put(u, v);
        }

        boolean[] map = new boolean[100];
        Queue<int[]> path = new LinkedList<>();
        path.add(new int[] {0,0}); // {position, time}
        map[0] = true;
        while (!path.isEmpty()) {
            int[] cur = path.poll();
            // 주사위 굴리기
            for(int i = 1; i<=6; i++){
                int next = cur[0]+i;
                // 100번째 칸 도달했으면 시간 출력 후 종료
                if(next == 99){
                    System.out.println(cur[1]+1);
                    return;
                }
                // 방문했거나 예정이면 continue
                if(map[next]) continue;
                map[next] = true; // 방문 표시
                // 다음 경로 추가
                if(warp.containsKey(next)){
                    if(!map[warp.get(next)]){
                        map[warp.get(next)] = true;
                        path.add(new int[] {warp.get(next),cur[1]+1});

                    }
                }else{
                    path.add(new int[] {next, cur[1]+1});
                }
            }
        }
    }
}
