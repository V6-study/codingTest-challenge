// https://www.acmicpc.net/problem/11650
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x,y});
        }
        list.sort((o1,o2) -> {
            int x1 = o1[0];
            int x2 = o2[0];
            if(x1 == x2) {
                int y1 = o1[1];
                int y2 = o2[1];
                return Integer.compare(y1,y2);
            }
            return Integer.compare(x1,x2);
        });
        StringBuilder sb = new StringBuilder();
        for (int[] xy : list) {
            sb.append(xy[0]).append(" ").append(xy[1]).append("\n");
        }
        System.out.println(sb);
    }
}
