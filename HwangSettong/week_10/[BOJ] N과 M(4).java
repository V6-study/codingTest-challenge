// https://www.acmicpc.net/problem/15652
import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static StringBuilder answer = new StringBuilder();

    private static void dfs(int i, String select, int count){
        if(count == m){ // m개의 숫자를 뽑았으면 return
            answer.append(select);
            answer.append("\n");
            return;
        }
        
        // 같은 수를 여러번 골라도 되므로 다음 탐색 숫자에 i를 포함한다.
        for(int j = i; j <= n; j++){
            dfs(j, select+j+" ", count+1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(1, "", 0);

        System.out.println(answer);
    }
}
