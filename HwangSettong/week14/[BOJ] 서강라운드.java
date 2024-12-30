// https://www.acmicpc.net/problem/14938
import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int[] items;

    private static int dijkstra(int root, int minLen){
        Integer[] distance = new Integer[map.length];
        boolean[] visited = new boolean[map.length];
        distance[root] = 0;
        int current = root;
        int getItem = 0;
        while(true){
            if(distance[current] > minLen) break; // 수색 범위 초과
            visited[current] = true; // 방문 지역 표시
            getItem += items[current]; // 방문 지역 아이템 개수 더해주기
            int min = 1000000, next = current;
            for(int node = 0; node < distance.length; node++){
                if(map[current][node] != 0){
                    int temp = distance[current] + map[current][node]; // 이어진 경로의 비용 계산
                    distance[node] = distance[node]==null? temp : Math.min(temp, distance[node]); // 이어진 경로의 최소 비용 저장
                }
                if(!visited[node] && distance[node] != null && distance[node] < min){ // 비용이 가작 적은 경로로 다음 지역 선택
                    min = distance[node];
                    next = node;
                }
            }
            if(next == current) break; // 다음 지역 선택 안됐으면 break
            current = next;
        }
        return getItem;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지역 수
        int m = Integer.parseInt(st.nextToken()); // 수색 범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수
        items = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[n][n];
        while(r-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int l = Integer.parseInt(st.nextToken());
            map[b][a] = map[a][b] = map[a][b]==0?l:Math.min(l, map[a][b]);
        }

        // 각 지역에 떨어졌을 때 가질 수 있는 아이템 수 구하고 최대 값 저장
        int answer = 0;
        for(int i = 0; i<n; i++ ){
            answer = Math.max(answer, dijkstra(i, m));
        }
        
        // 출력
        System.out.println(answer);
    }

}
