// https://www.acmicpc.net/problem/15686
import java.io.*;
import java.util.*;

public class Main {
    private static int m;
    private static int n;
    private static int[][] cd; // chicken distance; 치킨거리
    private static int answer = Integer.MAX_VALUE;


    private static void backtrack(int start_r, int count, int[] arr){
        if(count > m) return; // m개 뽑았으면 백트래킹
        int[] nextArr;
        int temp;
        for(int r = start_r; r < cd.length; r++){
            temp = 0;
            nextArr = new int[arr.length];
            // 각 집마다 뽑은 치킨집 중 최소거리 저장하기
            for(int c = 0; c < arr.length; c++) {
                
                nextArr[c] = arr[c] == 0 ? cd[r][c] : Math.min(arr[c], cd[r][c]);
                temp += nextArr[c]; 
            }
            // 최대 m개 이므로 m개보다 적게 뽑았을 경우에도 최소 치킨거리가 나올 수 있음
            if(count <= m && answer > temp){
                answer = temp;
            }
            backtrack(r+1, count+1, nextArr);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        ArrayList<int[]> chicken = new ArrayList<>(); // 치킨 위치 list
        ArrayList<int[]> home = new ArrayList<>(); // 집 위치 list
        for(int r = 0; r < n; r++) {
            input = br.readLine().split(" ");
            for(int c = 0; c < n; c++) {
                if(input[c].equals("1")) home.add(new int[] {r,c});
                if(input[c].equals("2")) chicken.add(new int[] {r,c});
            }
        }
        
        m = Math.min(m, chicken.size()); // m보다 치킨 집 수가 더 적으면 값 바꿔주기
        // 각 치킨집 별 집마다 치킨 거리 저장
        cd = new int[chicken.size()][home.size()];
        for(int r = 0; r < chicken.size(); r++) {
            for(int  c= 0; c < home.size(); c++) {
                cd[r][c] = Math.abs(home.get(c)[0]-chicken.get(r)[0]) + Math.abs(home.get(c)[1]-chicken.get(r)[1]);
            }
        }

        backtrack(0, 1, new int[home.size()]);

        System.out.println(answer);
    }
}
