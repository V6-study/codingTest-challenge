import java.io.*;
import java.util.*;

class Main{
    static int N,M;
    static int answer = 1;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static Set<Character> set;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new HashSet<>();

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        visited[0][0] = true;
        set.add(map[0][0]);

        dfs(new int[]{0,0,1});

        System.out.println(answer);
        br.close();
    }

    static void dfs(int[] info){
        int y = info[0];
        int x = info[1];
        int score = info[2];

        answer = Math.max(score, answer);

        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && nx>=0 && ny<N && nx<M && !set.contains(map[ny][nx])){
                set.add(map[ny][nx]);
                visited[ny][nx] = true;
                dfs(new int[]{ny,nx,score+1});
                visited[ny][nx] = false;
                set.remove(map[ny][nx]);
            }
        }
    }
}
