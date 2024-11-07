// https://www.acmicpc.net/problem/15663

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr; // 전역변수로 arr 지정
    static HashMap<String, Integer> map = new HashMap<>();// 이미 출력한 수열을 담는 리스트
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void dfs(int c, int n, int m, String s) throws IOException {
        if(m == 1 && map.getOrDefault(s, 0) == 0){ // 숫자를 m만큼 뽑았고, 출력한 적이 없으면 출력 후 리턴
            bw.write(s + "\n");
            map.put(s, 1);
            return;
        }
        int temp = arr[c]; // arr[c]값을 temp에 담음
        arr[c] = 0; // arr[c]를 0으로 만들어서 이미 뽑은 숫자임을 체크
        for(int i = 0; i < n; i++){
            if(arr[i] != 0){ // arr[c]가 0이 아니면 (뽑은 숫자가 아니면)
                dfs(i, n, m-1, s+" "+arr[i]); // 재귀 호출
            }
        }
        arr[c] = temp; // arr[c]에 다시 원래 값 넣어줌
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        for(int i = 0; i < n; i++){
            dfs(i, n, m, arr[i]+"");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
