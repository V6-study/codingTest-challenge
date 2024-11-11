// https://www.acmicpc.net/problem/1717
// [골든래빗] 코딩테스트 합격자 되기 자바편의 347p 문제

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr; // 각 인덱스는 노드 번호(0~n). 값은 집합 노드.

    // union 연산을 수행하는 함수
    static void union(int a, int b){
        arr[a] = a;
        arr[b] = a;
    }

    // 집합의 루트를 찾는 함수
    static int findRoot(int n){
        if(arr[n] == -1 || arr[n] == n){
            return n;
        }
        return findRoot(arr[n]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0]; // 최대 노드 번호
        int m = input[1]; // 연산 수

        arr = new int[n+1];
        Arrays.fill(arr,-1); // arr의 값을 -1로 채움.

        StringBuilder sb = new StringBuilder();
        int aRoot, bRoot;
        for (int i = 1; i <= m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            aRoot = findRoot(input[1]);
            bRoot = findRoot(input[2]);

            // union 연산
            if(input[0] == 0){
                union(aRoot, bRoot);
            }
            // find 연산
            else{
                if(aRoot == bRoot){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }
        }
        br.close();
        System.out.print(sb);
    }
}
