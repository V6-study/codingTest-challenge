// https://www.acmicpc.net/problem/1987
import java.io.*;
import java.util.*;

public class Main {
    private static int[] dr = {0,1,0,-1};
    private static int[] dc = {1,0,-1,0};
    private static int[] rc;
    private static String[] map;
    private static HashSet<Character> visited = new HashSet<>(); // 방문한 알파벳 저장
    private static int maxDist = 1; // 최대 갈 수 있는 거리

    private static void dfs(int r, int c, int dist){
        if(visited.contains(map[r].charAt(c))){
            if(dist > maxDist) maxDist = dist; // 현재 거리가 최대면 값 변경
            return;
        }

        visited.add(map[r].charAt(c)); // visited에 값 추가
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nc < 0 || nr >= rc[0] || nc >= rc[1]) continue; // map 범위 밖이면 continue
            dfs(nr, nc, dist+1); // 재귀호출로 탐색
        }
        visited.remove(map[r].charAt(c)); // 백트래킹을 위해 visited에 값 삭제
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new String[rc[0]];
        for (int i = 0; i < rc[0]; i++) {
            map[i] = br.readLine();
        }
        dfs(0,0,0);
        System.out.println(maxDist);
    }
}
