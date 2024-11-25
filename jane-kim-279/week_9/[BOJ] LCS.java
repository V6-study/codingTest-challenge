//https://www.acmicpc.net/problem/9251
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");
        int[][] map = new int[a.length+1][b.length+1]; // 수열의 길이를 저장하는 map

        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i].equals(b[j])) { // 만약 a[i]와 b[j]가 같은 문자라면 map[i+1][j+1]에 map[i][j]+1 을 넣는다.
                    map[i+1][j+1] = map[i][j] + 1;
                    answer = Math.max(answer, map[i+1][j+1]); // answer 값 큰걸로 변경
                }else{ // 다른 문자라면 map[i+1][j+1]에 map[i][j+1]과 map[i+1][j] 중 큰 값을 넣는다.
                    map[i+1][j+1] = Math.max(map[i+1][j], map[i][j+1]);
                }
            }
        }
        System.out.println(answer);
    }
}
