//https://www.acmicpc.net/problem/11725
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();

        ArrayList<Integer> temp;
        for(int i = 1; i < n; i++){
            int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 간선 표시
            temp = tree.getOrDefault(nodes[0] , new ArrayList<Integer>());
            temp.add(nodes[1]);
            tree.put(nodes[0], temp);
            temp = tree.getOrDefault(nodes[1] , new ArrayList<Integer>());
            temp.add(nodes[0]);
            tree.put(nodes[1], temp);
        }


        // tree 탐색하면서 map에 부모 노드담기
        HashMap<Integer, Integer> map = new HashMap<>(); // key:노드, value:key의 부모노드
        Queue<Integer> queue = new LinkedList<>(); // 탐색 경로 큐
        // 트리의 루트 담아주기 (1로 지정됨)
        map.put(1, 0);
        queue.add(1);
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(Integer node: tree.get(current)){
                if(!map.containsKey(node)){
                    map.put(node, current); // map에 node의 부모노드가 current임을 담아줌
                    queue.add(node); // node를 다음 탐색 경로에 추가.
                }
            }
        }

        // 2~n까지 map을 순회하면서 부모노드 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 2 ; i <= n; i++){
            bw.write(map.get(i)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
