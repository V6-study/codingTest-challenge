// https://www.acmicpc.net/problem/1005

import java.io.*;
import java.util.*;

public class Main {
    private static int[] buildTime;  // 각 건물을 짓는데 걸리는 시간
    private static HashMap<Integer, ArrayList<Integer>> map; // key: 도착 건물, value: 완료해야 될 건물 list
    private static Integer[] memo; // 계산된 시간 저장

    private static int getTime(int w){
        if(!map.containsKey(w)){
            memo[w] = buildTime[w];
            return buildTime[w];
        }
        int time = 0;
        for(int pre: map.get(w)){
            // 먼저 완료해야 될 건물 중 시간 max 값 구하기
            if(memo[pre] == null){
                time = Math.max(time, getTime(pre)); // 계산된 적 없는 건물이면 재귀호출
            }else{
                time = Math.max(time, memo[pre]); // 계산된 적 있는 건물이면 저장된 값 이용
            }
        }
        time += buildTime[w];
        memo[w] = time; // 시간 계산했으면 memo에 저장
        return time;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        while(TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물 수
            int K = Integer.parseInt(st.nextToken()); // 규칙 수
            memo = new Integer[N]; // memo 초기화
            buildTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // buildTime 초기화
            
            // map 만들기
            map = new HashMap<>();
            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                if(!map.containsKey(y)) map.put(y, new ArrayList<>());
                map.get(y).add(x);
            }
            
            // 건물 W 입력 받고 걸리는 시간 계산
            int W = Integer.parseInt(br.readLine())-1;
            bw.write(getTime(W)+"\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}
