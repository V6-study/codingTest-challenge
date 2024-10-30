import java.util.*;
import java.io.*;

public class Main
{        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        if (N >= K) {
            System.out.println(N - K);
            return;
        }
        
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next <= 100000 && visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                    
                    if (next == K) {
                        System.out.println(visited[next]);
                        return;
                    }
                }
            }
        }
    }
}
