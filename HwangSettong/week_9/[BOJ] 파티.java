// https://www.acmicpc.net/problem/1238
import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    static int n, m, x;
    
    static int[] dijkstra(int start){
        int[] time = new int[n];
        boolean[] visited = new boolean[n];
        int node = start;
        while(!visited[node]){
            int minTime = Integer.MAX_VALUE, nextNode = node; // time에 저장된 값 중 최소 값이 다음 노드가 됨.
            visited[node] = true;
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    // time이 계산된 적 없거나, 계산된 소요 시간이 time에 저장된 시간보다 작을 때 값 교체
                    if(map[node][i] != 0 && (time[i]==0 || time[node]+map[node][i] < time[i])){
                        time[i] = time[node]+map[node][i];
                    }
                    // 방문 가능한 것 중, 소요 시간이 최소값인 것 다음 노드로 설정
                    if(time[i] != 0 && time[i]<minTime){
                        minTime = time[i];
                        nextNode = i;
                    }
                }
            }
            node = nextNode; // 다음 탐색 노드
        }
        return time;
    }







    public static void main(String[] args) throws IOException {
        // 값 입력 받고 변수 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 노드 수
        m = Integer.parseInt(st.nextToken()); // 간선 수
        x = Integer.parseInt(st.nextToken())-1; // 전환점
        map = new int[n][n];
        for(int i=0; i<m; i++){
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[info[0]-1][info[1]-1] = info[2];
        }
        br.close();


        int[] fromX = dijkstra(x); // x에서 각 노드로 가는 최소 시간 구하기
        int answer = 0;
        for(int i=0; i<n; i++){
            int toX = dijkstra(i)[x]; // 각 노드에서 x로 가는 최소 시간 구하기
            answer = Math.max(answer, fromX[i] + toX); // 최종 값이 answer보다 크면 값 교체
        }
        
        System.out.println(answer);
        
    }
}
