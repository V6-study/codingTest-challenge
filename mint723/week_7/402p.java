// https://www.acmicpc.net/problem/24479

import java.util.*;
import java.io.*;

class Main{
    static int N,M;
    static List<Integer>[] map; // 노드간 연결 정보
    static boolean[] visited;
    static int[] answer;
    static int order = 1; // 방문 순서를 기록하는 변수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());

        map = new List[N+1]; // 인접 리스트 생성
        visited = new boolean[N+1]; // 방문 기록

        answer = new int[N+1]; // 정답

        for(int i=1; i<=N; i++){
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());
            map[point1].add(point2);
            map[point2].add(point1);
        }

        for (int i = 1; i <= N; i++) {
            // 정점 번호가 작은것부터 방문하기 위해 정렬
            Collections.sort(map[i]);
        }

        visited[startPoint] = true;
        answer[startPoint] = order++;
        dfs(startPoint);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void dfs(int point){
        for (int next : map[point]) {
            if(!visited[next]){
                answer[next] = order++;
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
