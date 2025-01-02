import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 좌표를 문자열 "x,y" 형태로 저장
        HashMap<String, Integer> visits = new HashMap<>();
        visits.put("0,0", 0);  // 시작점
        
        int x = 0, y = 0;  // 현재 위치
        int time = 0;
        int coolTime = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int steps = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < steps; j++) {
                // 방향에 따라 좌표 갱신
                switch (dir) {
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'S': y--; break;
                    case 'W': x--; break;
                }
                time++;
                
                String pos = x + "," + y;
                if (visits.containsKey(pos)) {
                    coolTime = Math.min(coolTime, time - visits.get(pos));
                }
                visits.put(pos, time);
            }
        }
        
        System.out.println(coolTime == Integer.MAX_VALUE ? -1 : coolTime);
    }
}
