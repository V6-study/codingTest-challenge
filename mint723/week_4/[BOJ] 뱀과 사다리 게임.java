// https://www.acmicpc.net/problem/16928

import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();

        int answer = Integer.MAX_VALUE;

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<int[]> q = new LinkedList<>();
        visited[1] = true;
        q.offer(new int[]{1,1});

        while (!q.isEmpty()){
            int[] info = q.poll();
            int pos = info[0];
            for (int i=1; i<=6; i++){
                int nPos = pos + i;

                if(nPos == 100){
                    answer = Math.min(answer, info[1]);
                    break;
                }
                if(ladder.containsKey(nPos)){
                    Integer np = ladder.get(nPos);
                    if(isNotVisited(np)){
                        q.offer(new int[]{np, info[1]+1});
                        visited[np] = true;
                    }
                }else if(snake.containsKey(nPos)){
                    Integer np = snake.get(nPos);
                    if(isNotVisited(np)){
                        q.offer(new int[]{np, info[1]+1});
                        visited[np] = true;
                    }
                }else{
                    if(isNotVisited(nPos)){
                        q.offer(new int[]{nPos, info[1]+1});
                        visited[nPos] = true;
                    }
                }
            }
        }
        System.out.println(answer);

        br.close();
    }

    static boolean isNotVisited(int pos){
        return pos<=100 && pos>=0 && !visited[pos];
    }
}
