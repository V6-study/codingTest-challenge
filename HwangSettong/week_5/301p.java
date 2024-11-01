// https://www.acmicpc.net/problem/1991
import java.io.*;
import java.util.*;


public class Main {
    static HashMap<String, String[]> map = new HashMap<>(); // key : 값 , value : [왼쪽 자식 값, 오른쪽 자식 값]
    static StringBuilder preorder = new StringBuilder(); // 전위순회
    static StringBuilder inorder = new StringBuilder(); // 중위순회
    static StringBuilder postorder = new StringBuilder(); // 후위순회

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // map으로 tree 만들기
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            map.put(s[0], new String[]{s[1], s[2]});
        }

        dfs("A"); // dfs로 트리 순회. root 값은 "A"

        // 결과 출력
        System.out.println(preorder.toString());
        System.out.println(inorder.toString());
        System.out.println(postorder.toString());

        br.close();
    }

    // 트리탐색
    static void dfs(String root) {
        if(".".equals(root)){ return; }
        preorder.append(root); // (전위순회) 자식들 탐색하기 전 값 입력
        dfs(map.get(root)[0]); // 왼쪽 자식 탐색
        inorder.append(root); // (중위순회) 왼쪽 자식 탐색한 후 값 입력
        dfs(map.get(root)[1]); // 오른쪽 자식 탐색
        postorder.append(root); // (후위순회) 자식들 다 탐색한 후 값 입력
    }
}


