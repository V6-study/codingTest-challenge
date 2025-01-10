// https://www.acmicpc.net/problem/2630

import java.io.*;
import java.util.*;

public class Main {
    private static int blue = 0;
    private static int white = 0;
    private static int[][] paper;

    // 모두 같은 색으로 칠해져 있는지 확인. return 0=white, 1=blue, 2=mix
    private static int checkColor(int i, int j, int n){
        int color = paper[i][j];
        for(int r = i; r < n+i; r++){
            for(int c = j; c < n+j; c++){
                if(paper[r][c] != color) return 2;
            }
        }
        return color;
    }


    // 종이 자르기
    private static void cuttingPaper(int i, int j, int n){
        int check = checkColor(i, j, n);
        // 모두 같은 색이면 그 색의 색종이 개수 증가
        if( check != 2) {
            if(check == 0) white++;
            if(check == 1) blue++;
            return;
        }

        // 종이 4등분 하고 재귀호출
        int nextN = n/2;
        cuttingPaper(i, j, nextN);
        cuttingPaper(i+nextN, j, nextN);
        cuttingPaper(i, j+nextN, nextN);
        cuttingPaper(i+nextN, j+nextN, nextN);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        cuttingPaper(0,0, N);
        System.out.print(white+"\n"+blue);
    }
}
