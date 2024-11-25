//https://www.acmicpc.net/problem/1967
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] arr; //각 노드별 자식 노드 정보 리스트. {자식노드, 가중치}
    static int answer = 0;
    static int dfs(int idx){
        if(arr[idx] == null) return 0; // 리프노드면 return 0
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 자식 노드의 가중치 합 중 가장 큰 2개의 값만 저장할 것임.
        pq.offer(0);
        for(int i = 0 ; i < arr[idx].size() ; i++){
            int[] info = arr[idx].get(i); // 자식 노드 정보
            int temp = dfs(info[0])+info[1]; // 재귀호출한 값 + 자식노드 가중치 값을 temp 에 저장
            pq.offer(temp);
            if(pq.size()>2){ pq.poll(); } // pq의 사이즈가 2보다 커지면 작은 값 Dequeue.
        }
        answer = Math.max(answer, pq.poll() + pq.peek()); // pq에 저장된 값들을 더한 걸 answer와 비교하고 교체해줌.
        return pq.poll(); // 가장 큰 가중치 합은 return
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // arr 초기화
        arr = new ArrayList[n+1];
        for(int i = 1; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(arr[parent] == null){arr[parent] = new ArrayList<>();}
            arr[parent].add(new int[] {child, weight});
        }
        // dfs 호출. root는 항상 1
        dfs(1);
        System.out.println(answer);
    }
}
