//https://www.acmicpc.net/problem/11404
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;

    static int[] dijkstra(int start) {
        int[] result = new int[n];
        HashSet<Integer> visited = new HashSet<>();
        while(!visited.contains(start)) {
            visited.add(start); // 저장한 마을은 visited에 추가
            int minCost = Integer.MAX_VALUE, nextIdx = start; // result에 저장되는 비용 중 최소 값과 그 인덱스 (다음 경로가 됨)
            for (int i = 0; i < n; i++) {
                if(!visited.contains(i)){ // 방문한 적 없는 마을
                    // 현재 마을과 이어져 있고, 저장된 cost가 없거나(= 0일 때), 현재 계산되는 cost가 저장된 cost보다 더 작으면 값 교체
                    if (map[start][i] != 0 && (result[i] == 0 || result[i] > result[start] + map[start][i])) {
                        result[i] = result[start] + map[start][i];
                    }
                    // 앞으로 방문할 수 있고, 현재 result에 저장된 비용이 최소 값이면 다음 탐색 경로 변경
                    if (result[i] != 0 && result[i] < minCost) {
                        minCost = result[i];
                        nextIdx = i;
                    }
                }
            }
            start = nextIdx; // 다음 탐색 경로를 출발지로 바꿔주기
        }
        return result;
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 마을 수
        int m = Integer.parseInt(br.readLine()); // 버스 수
        // map 초기화
        map = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            // a->b 노선의 버스가 여러개일 수 있음, 최소 비용만 저장
            map[a][b] = map[a][b]==0? c : Math.min(map[a][b], c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){ // 각 출발지의 cost 배열 StringBuilder에 담기
            Arrays.stream(dijkstra(i)).forEach(e->sb.append(e+" "));
            sb.append("\n");
        }
        System.out.println(sb); // 결과 출력


    }
}
