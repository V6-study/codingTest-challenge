// https://www.acmicpc.net/problem/2776

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            Set<Integer> yeonjong = new HashSet<>();
            for(int j = 0; j < n; j++) {
                yeonjong.add(Integer.parseInt(st.nextToken()));
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] donggyu = new int[m];
            for(int j = 0; j < m; j++) {
                donggyu[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < m; j++) {
                if (yeonjong.contains(donggyu[j])) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
            System.out.print(sb);

        }

    }
}
