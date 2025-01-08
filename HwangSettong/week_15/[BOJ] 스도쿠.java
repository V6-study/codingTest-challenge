// https://www.acmicpc.net/problem/2239
import java.io.*;
import java.util.*;

public class Main {
    private static int[][] board = new int[9][9];
    private static ArrayList<int[]> empty = new ArrayList<>();

    private static boolean checkNumber(int i, int j, int n){
        for(int k = 0; k < 9; k++){
            if(board[i][k] == n || board[k][j] == n) return false;
            if(board[i/3*3 + k/3][j/3*3 + k%3] == n) return false;
        }
        return true;
    }

    private static boolean sudoku(int idx){
        if(idx == empty.size()) return true;
        int i = empty.get(idx)[0];
        int j = empty.get(idx)[1];

        for(int n = 1; n <= 9; n++){
            if(checkNumber(i, j, n)){
                board[i][j] = n;
                if(sudoku(idx+1)) return true;
            }
        }
        board[i][j] = 0; // 백트래킹 전에 빈칸으로 돌려놓기
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 0) empty.add(new int[]{i, j});
            }
        }

        sudoku(0);

        Arrays.stream(board).forEach(arr->{
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
        });

    }
}
