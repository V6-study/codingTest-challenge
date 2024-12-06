//https://www.acmicpc.net/problem/15666
import java.io.*;
import java.util.*;

public class Main {
    private static HashSet<String> check = new HashSet<>(); // 정답을 저장하는 set
    private static StringBuilder answer = new StringBuilder(); // 정답
    private static int[] arr; // 입력받는 수 배열

    private static void backtrack(int idx, int m, String s){
        if(m == 0){ // 백트랙 조건 : 더 이상 뽑을 수 없음
            if(!check.contains(s)){ // 중복되는 순열이면 저장 X
                check.add(s);
                answer.append(s+"\n");
            }
            return;
        }

        // 비내림차순이므로 정렬된 arr를 현재 인덱스부터 차례로 탐색
        for(int i = idx; i < arr.length; i++){
            backtrack(i, m-1,s+arr[i]+" ");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().split(" ")[1]);
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr); // arr를 오름차순으로 정렬
        backtrack(0, m, "");
        System.out.print(answer);
    }
}
