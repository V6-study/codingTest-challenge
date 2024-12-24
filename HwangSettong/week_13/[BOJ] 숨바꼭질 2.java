// https://www.acmicpc.net/problem/12851
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int minSec = 100000;
        int[] visited = new int[100001]; // 위치X 방문할 때 최소 시간 저장
        Arrays.fill(visited, 100000); // 100,000으로 초기화
        Queue<int[]> queue = new LinkedList<>(); // {현재위치, 시간}
        queue.add(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            visited[info[0]] = Math.min(visited[info[0]], info[1]);
            if(minSec < info[1]) continue; // 최소 시간보다 더 시간이 걸리면 넘어가기
            if(info[0] == k){ // 현재 위치가 동생의 위치일 때
                if(minSec > info[1]){ // 원래 최소 시간보다 현재 시간이 더 작으면 minSec 변경 후 cnt 초기화
                    minSec = info[1];
                    cnt = 1;
                }else{ // (최소 시간==현재 시간)이면 카운트(cnt) +1
                    cnt++;
                }
                continue;
            }

            // 다음 경로 추가
            if(minSec > info[1]){
                if(info[0] < k && info[0] < 100000 && visited[info[0]+1] >= info[1]+1) queue.add(new int[]{info[0]+1, info[1] + 1});
                if(info[0] < k && info[0] <= 50000 && visited[info[0]*2] >= info[1]+1) queue.add(new int[]{info[0]*2, info[1] + 1});
                if(info[0]>0 && visited[info[0]-1] >= info[1]+1) queue.add(new int[]{info[0]-1, info[1] + 1});
            }
        }
        System.out.println(minSec+"\n"+cnt);
    }
}
