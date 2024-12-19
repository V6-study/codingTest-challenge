//https://www.acmicpc.net/problem/10830
import java.io.*;
import java.util.*;
 
public class Main {
    private static long[][] origin;
    private static int n;
 
    private static long[][] multiply(long[][] m1, long[][] m2){ // 행렬 곱
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++){
                    res[i][j] = (res[i][j]+m1[i][k] * m2[k][j])% 1000; // 행렬의 각 원소는 1,000보다 작거나 같은 자연수 또는 0
                }
            }
        }
        return res;
    }
 
    private static long[][] recursive(long b, long[][] m){ // 분할 정복 방식으로 거듭제곱 구현
        if(b == 1){
            return m;
        }
        long[][] temp = recursive(b/2, m);
        if(b%2 == 0){
            return multiply(temp, temp);
        }else{
            return multiply(multiply(temp, temp), origin);
        }
    }
 
 
    private static void print2D(long[][] matrix){ // 행렬 출력
        Arrays.stream(matrix).forEach(i->{
            Arrays.stream(i).forEach(x->System.out.print((x%1000)+" "));
            System.out.println();
        });
    }
 
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
 
        // n*n 행렬 만들기
        origin = new long[n][n];
        for(int i = 0; i < n; i++) {
            origin[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
 
        print2D(recursive(b, origin.clone()));
 
    }
}
