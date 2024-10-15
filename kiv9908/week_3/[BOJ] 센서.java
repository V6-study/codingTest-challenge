package week_3.센서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        List<Integer> dis = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        // k가 n보다 크거나 같으면 모든 센서를 개별로 커버 가능하므로 거리는 0
        if (k >= n) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i < n; i++) {
            dis.add(list.get(i) - list.get(i-1));
        }

        Collections.sort(dis, Collections.reverseOrder());

        for (int i = k - 1; i < dis.size(); i++) {
            answer += dis.get(i);
        }

        System.out.println(answer);

    }
}
