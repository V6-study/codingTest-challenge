import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,-1,1};

        int[] startPos = new int[2];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == 'I'){
                    startPos[0] = i;
                    startPos[1] = j;
                }
                map[i][j] = c;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startPos[0], startPos[1]});
        visited[startPos[0]][startPos[1]] = true;

        while(!q.isEmpty()){
            int[] info = q.poll();
            int y = info[0];
            int x = info[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny>=0 && nx>= 0 && ny<N && nx<M && !visited[ny][nx] && map[ny][nx] != 'X'){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                    if(map[ny][nx] == 'P')
                        answer++;
                }
            }
        }

        System.out.println(answer==0?"TT":answer);

        br.close();
    }
}
