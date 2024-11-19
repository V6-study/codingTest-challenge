import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, n;
    static String[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new String[r][c];

        // 초기 상태 입력받기
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }

        if (n == 1) { // 초기 상태 출력
            printMap(map, sb);
        } else if (n % 2 == 0) { // 모든 칸이 폭탄으로 채워짐
            fillWithBombs(sb);
        } else { // 폭발 상태 계산
            String[][] afterFirstExplosion = explode(map); // 3초 후 상태
            if (n % 4 == 3) { // 3초 후 상태
                printMap(afterFirstExplosion, sb);
            } else { // 5초 후 상태
                printMap(explode(afterFirstExplosion), sb); // 두 번째 폭발 후 상태
            }
        }
    }

    // 폭발 후 상태를 계산
    private static String[][] explode(String[][] currentMap) {
        String[][] result = new String[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = "O"; // 초기화: 모든 칸에 폭탄
            }
        }

        // 폭탄 폭발 시뮬레이션
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (currentMap[i][j].equals("O")) {
                    result[i][j] = "."; // 폭탄이 있던 칸
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                            result[ny][nx] = "."; // 인접 칸도 파괴
                        }
                    }
                }
            }
        }
        return result;
    }

    // 모든 칸을 폭탄으로 채움
    private static void fillWithBombs(StringBuilder sb) {
        for (int i = 0; i < r; i++) {
            sb.append("O".repeat(c)).append("\n");
        }
        System.out.print(sb);
    }

    // 격자판 출력
    private static void printMap(String[][] map, StringBuilder sb) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
