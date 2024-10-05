import java.util.*;

public class Main
{    
	public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
	}
	
	static int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length;
        int y = arr2[0].length;
        int[][] result = new int[x][y];
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                for(int k=0; k<arr1[0].length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return result;
	}
}
