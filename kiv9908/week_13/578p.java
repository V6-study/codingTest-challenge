import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        
        int num = 1;

        int startRow = 0, endRow = n-1, startCol = 0, endCol = n-1;

        while (startRow<=endRow && startCol<=endCol) {
            for (int i = startCol; i <= endCol; i++) {
                arr[startRow][i] = num++;
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                arr[i][endCol] = num++;
            }
            endCol--;

            for(int i = endCol; i >= startCol; i--) {
                arr[endRow][i] = num++;
            }
            endRow--;

            if(startCol <= endCol){
                for(int i = endRow; i >= startRow; i--) {
                    arr[i][startCol] = num++;
                }
                startCol++;
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
