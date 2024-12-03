// https://www.acmicpc.net/problem/1865
import java.io.*;
import java.util.*;

public class Main {
    private static Integer[] dist;
    private static ArrayList<Integer> nodes;
    private static ArrayList<int[]> edges = new ArrayList<>(); // {from, to, time}
    private static int INF = 1000000000; // Integer.MAX_VALUE 쓰면 time 더할 때 오버플로우 발생.

    static boolean bellmanford(int root){
        dist[root] = 0; // 출발지 탐색시간을 0으로 바꿔줌.
        for(int n=0; n<dist.length-1; n++){ // node 수 - 1 만큼 탐색
            for(int[] edge : edges){
                int from = edge[0], to = edge[1], time = edge[2];
                // to에 저장된 시간이 from->to로 가는 시간보다 크면 값 변경
                if(dist[from] + time < dist[to]){
                    dist[to] = dist[from] + time;
                }
            }
        }

        // 탐색 완료 후 음수 사이클 여부 확인.
        for(int[] edge : edges){
            int from = edge[0], to = edge[1], time = edge[2];
            if(dist[from] + time < dist[to]){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int n, m, w; // 지점수, 경로 수, 웜홀 수
        int s, e, t; // 출발지, 도착지, 시간
        tcLoop: while(tc-- > 0) {
            // map과 초기화
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken()); // 지점 수
            m = Integer.parseInt(st.nextToken()); // 경로 수
            w = Integer.parseInt(st.nextToken()); // 웜홀 수
            dist = new Integer[n]; // dist 초기화
            Arrays.fill(dist, INF);
            edges.clear(); // edge 초기화
            while(m-- > 0){ // 경로 입력
                st = new StringTokenizer(br.readLine(), " ");
                s = Integer.parseInt(st.nextToken())-1; // 출발지
                e = Integer.parseInt(st.nextToken())-1; // 도착지
                t = Integer.parseInt(st.nextToken()); // 시간
                edges.add(new int[]{s,e,t});
                edges.add(new int[]{e,s,t});
            }
            while(w-- > 0){ // 웜홀 입력
                st = new StringTokenizer(br.readLine(), " ");
                s = Integer.parseInt(st.nextToken())-1; // 출발지
                e = Integer.parseInt(st.nextToken())-1; // 도착지
                t = Integer.parseInt(st.nextToken()); // 시간
                edges.add(new int[]{s,e,-t});
            }


            if(bellmanford(0)) answer.append("YES\n"); // 음의사이클 있으면 yes
            else answer.append("NO\n"); // 음의사이클 없으면 No
        }
        System.out.println(answer); // answer 출력

    }
}
