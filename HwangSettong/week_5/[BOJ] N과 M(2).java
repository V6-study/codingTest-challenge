//https://www.acmicpc.net/problem/15650
import java.io.*;
public class Main {
    static void dfs(int c, int n, int m, String s){
        if(m == 1 && c <= n){
            System.out.println(s);
            return;
        }
        for(int i = c+1; i <= n; i++){
            dfs(i, n, m-1, s+" "+i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        for(int i = 1; i <= n; i++){
            dfs(i, n, m, i+"");
        }
    }
}
