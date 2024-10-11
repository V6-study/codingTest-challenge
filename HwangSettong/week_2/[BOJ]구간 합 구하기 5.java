//https://www.acmicpc.net/problem/11660
import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[nm[0]+1][nm[0]+1];
        int[] temp;
        for(int i = 1 ; i <= nm[0] ; i++){
            temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i][0] = arr[i-1][nm[0]];
            for(int j = 1 ; j <= nm[0] ; j++){
                arr[i][j] = temp[j-1] + arr[i][j-1];
            }
        }
        int x1,x2,y1,y2;
        for(int i = 0 ; i < nm[1] ; i++){
            int answer=0;
            temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            x1 = temp[0];
            y1 = temp[1];
            x2 = temp[2];
            y2 = temp[3];
            for(int j = x1; j<=x2 ; j++) {
                answer += arr[j][y2] - arr[j][y1 - 1];
            }
            System.out.println(answer);
        }
    }
}
