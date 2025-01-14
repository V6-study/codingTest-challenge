https://www.acmicpc.net/problem/11724
import java.io.*;
import java.util.*;

public class Main {
    private static int[] root; // node의 root를 저장하는 배열

    // node의 root 찾기
    private static int find(int node){
        if(root[node] == node) return node;
        return root[node] = find(root[node]);
    }

    // 두 node(u, v)가 포함된 집합 합치기
    private static int union(int u, int v){
        int root1 = find(u); // u의 root 노드 찾기
        int root2 = find(v); // v의 root 노드 찾기

        // 두 root 중 작은 값을 기준으로 합치기
        if(root1 < root2){
            root[root2] = root1;
            return root1;
        }
        else{
            root[root1] = root2;
            return root2;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        root = new int[n];
        for(int i = 0; i < n; i++) {
            root[i] = i;
        }

        while(e-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            union(u, v);
        }

        HashSet<Integer> roots = new HashSet<>();
        for(int r: root){
            roots.add(find(r));
        }

        System.out.println(roots.size());
    }
}
