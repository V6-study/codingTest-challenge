// https://www.acmicpc.net/problem/1931

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        Collections.sort(list,(o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int answer = 0;
        int lastTime = -1;

        for (int[] ints : list) {
            if (ints[0] >= lastTime){
                lastTime = ints[1];
                answer ++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
