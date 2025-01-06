//https://www.acmicpc.net/problem/15681
import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] connectNode; // 입력받은 노드 연결 정보
    private static HashSet<Integer>[] tree; // 노드 별 자식 노드 set
    private static int[] size; // 노드 별 자식 개수

    private static void createTree(int current, int parent){
        tree[current] = new HashSet<>();
        for(int child : connectNode[current]){
            // 연결된 노드 중 부모와 같은 것은 제외하고, 나머지 노드들 자식 list에 추가
            if(child == parent) continue;
            tree[current].add(child);
            createTree(child, current); // 재귀호출로 현재의 자식 노드 탐색
        }
    }

    private static void countSubTreeNode(int current){
        size[current] = 1; // 자기 자신을 포함
        for(int child : tree[current]){
            countSubTreeNode(child); // 재귀호출로 현재의 자식 노드 탐색
            size[current] += size[child]; // 자식 노드의 자식 수를 더함
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken())-1;
        int Q = Integer.parseInt(st.nextToken());

        connectNode = new ArrayList[N];
        for(int n=1; n<N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken())-1;
            int V = Integer.parseInt(st.nextToken())-1;
            if(connectNode[U] == null) connectNode[U] = new ArrayList<>();
            if(connectNode[V] == null) connectNode[V] = new ArrayList<>();
            connectNode[U].add(V);
            connectNode[V].add(U);
        }

        tree = new HashSet[N];
        createTree(R, -1);
        size = new int[N];
        countSubTreeNode(R);

        for(int q=0; q<Q; q++){
            System.out.println(size[Integer.parseInt(br.readLine())-1]);
        }
    }
}
