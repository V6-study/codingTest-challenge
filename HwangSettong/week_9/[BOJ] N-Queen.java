/*
문제 링크 : https://www.acmicpc.net/problem/9663

N-Queen 백트래킹 조건:
2. 같은 행에 퀸이 있을 때
3. 대각선 방향에 퀸이 있을 때
4. 퀸을 n개 이상 두었을 때 -> 이때는 결과에 1 더해준다.
*/


import java.io.*;

public class Main {
    static int n;
    static boolean[][] board;
    static int result = 0;


    // 백트래킹 함수 정의
    static void backtracking(int x, int y, int cnt){
        if(checkQueen(x, y, board)) return; //  같은 행, 대각선 방향에 퀸이 있으면 return
        if(cnt == n){ // 퀸을 n개 두었으면 result에 1 더해주고 return
            result++;
            return;
        }
        board[x][y] = true; // 퀸 두었음을 표시
        for(int i = 0; i < n; i++){
            // 백트래킹 함수 재귀. 열(x)은 1씩 증가. 행(y)는 순차적으로 탐색하기
            backtracking( x+1, i, cnt + 1);
        }
        board[x][y] = false; // 탐색 했으면 두기 전 상태로 돌아가기
    }


    // 같은 행, 대각선 방향에 퀸이 있는지 확인하는 함수. 있으면 true, 없으면 false
    static boolean checkQueen(int x, int y, boolean[][] board){
        for(int i=0; i<n; i++){
            // 같은 행에 퀸이 있는지 확인
            if(board[i][y]){
                return true;
            }
            // 대각선 방향에 퀸이 있는지 확인
            if( x-i >= 0 && y-i >= 0 && board[x-i][y-i]){
                return true;
            }
            if( x+i < n && y+i < n && board[x+i][y+i]){
                return true;
            }
            if( x-i >= 0 && y+i < n && board[x-i][y+i]){
                return true;
            }
            if( x+i < n && y-i >= 0 && board[x+i][y-i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];
        // 첫번째 열에서 몇번째 행을 선택할건지 정하기.
        for(int i = 0; i < n; i++){
            backtracking(0, i, 1); // 백트래킹 함수 호출
        }
        System.out.println(result);

    }
}
