import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 땅인 경우, 상하좌우 탐색
    // 상하좌우 탐색해서 3개 이상 바다이면 .으로 변경

    static boolean[][] visited;
    static int r,c;
    static String[][] map;
    static String[][] mapAfter;
    static Queue<Node> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new String[r][c];
        mapAfter = new String[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = bf.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
                mapAfter[i][j] = map[i][j];
                if (map[i][j].equals("X")) {
                    q.offer(new Node(i, j));
                }
            }
        }
        bfs();
        printMap(mapAfter);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            int cnt = 0;
            for(int k = 0; k < 4; k++) {
                int nr = now.r + dr[k];
                int nc = now.c + dc[k];
                if(nr >=0 && nr < r && nc >=0 && nc < c) {
                    if(map[nr][nc].equals(".")) {
                        cnt++;
                    }
                }else{
                    cnt++;
                }
            }
            if(cnt>=3){
                mapAfter[now.r][now.c] = ".";
            }
        }

    }

    private static void printMap(String[][] mapAfter) {
        int maxR=0, minR=r, maxC=0, minC=c;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(mapAfter[i][j].equals("X")) {
                    maxR = Math.max(maxR, i);
                    minR = Math.min(minR, i);
                    maxC = Math.max(maxC, j);
                    minC = Math.min(minC, j);
                }
            }
        }

        for (int i = minR; i <= maxR; i++) {
            for(int j = minC; j <= maxC; j++) {
                System.out.print(mapAfter[i][j]);
            }
            System.out.println();
        }


    }
}
