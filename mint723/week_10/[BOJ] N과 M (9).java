// https://www.acmicpc.net/problem/15663
import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());;
        }
        Arrays.sort(arr);

        dfs(0,new int[M]);
        set.forEach(System.out::println);
    }

    static void dfs(int depth, int[] list){
        if(depth == M){
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < M; i++) {
                sb.append(list[i]).append(' ');
            }

            set.add(sb.toString());
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                list[depth] = arr[i];
                dfs(depth+1, list);
                visited[i] = false;
            }
        }
    }
}
