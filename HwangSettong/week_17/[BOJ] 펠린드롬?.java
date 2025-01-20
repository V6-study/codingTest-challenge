//https://www.acmicpc.net/problem/10942
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 펠린드롬 가능 여부 배열
        int[][] p = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++){
            int p1=i, p2=i, p3=i+1;
            boolean check1 = true, check2 = true;
            while(p1>=0 && p2<arr.length && p3<=arr.length){
                if(check1 && arr[p1]==arr[p2]){
                    p[p1][p2] = 1;
                }else if(arr[p1] != arr[p2]){
                    check1 = false;
                }
                if(check2 && p3 < arr.length && arr[p1]==arr[p3]){
                    p[p1][p3] = 1;
                }else if( p3 < arr.length  && arr[p1] != arr[p3]){
                    check2 = false;
                }
                p1--;
                p2++;
                p3++;
            }
        }
        int cnt = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(cnt-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            bw.write(p[start][end] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
