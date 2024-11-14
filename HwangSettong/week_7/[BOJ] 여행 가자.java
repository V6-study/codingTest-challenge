//https://www.acmicpc.net/problem/1976
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    // a노드의 root 노드 찾기
    static int findRoot(int a){
        if(a==parent[a]){
            return a;
        }
        return parent[a] = findRoot(parent[a]); // 경로 압축
    }

    // 집합 합치기
    static void union(int a, int b){
        parent[findRoot(a)] = findRoot(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 전체 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행할 도시의 수

        // parent 초기화
        parent = new int[N];
        for(int i = 0; i<N; i++){
            parent[i] = i;
        }

        // 집합 만들기
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                if(temp[j].equals("1")){
                    union(i, j);
                }
            }
        }

        // 여행 도시 입력 받아서 한 집합에 있는지 확인하기
        int[] trip = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int root = findRoot(trip[0]-1);
        for(int i = 1; i<M; i++){
            if(findRoot(trip[i]-1) != root){ // 집합이 다르면 NO출력
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES"); // 전부 같으면 YES 출력


    }
}
