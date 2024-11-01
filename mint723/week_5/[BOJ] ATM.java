// https://www.acmicpc.net/problem/11399

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int answer = 0;

        for(int i=1; i<=N; i++) {
            int num = 0;
            for(int j=0; j<i; j++){
                num+=list.get(j);
            }
            answer+=num;
        }

        System.out.println(answer);
        br.close();
    }

}
