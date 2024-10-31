// https://www.acmicpc.net/problem/16953

import java.io.*;
import java.util.*;

class Main {
    static long num;
    static int goal;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        dfs(num, 1);

        System.out.println(answer);
        br.close();
    }

    static void dfs(long num, int count){
        if(num == goal){
            answer = count;
        }else if(num<goal){
            dfs(num*2, count+1);
            int tmp = Integer.parseInt(String.valueOf(num)+"1");
            dfs(tmp, count+1);
        }
    }
}
