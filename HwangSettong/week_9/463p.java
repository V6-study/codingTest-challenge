package 코딩테스트_합격자_되기.백트래킹.문제43_463p;
/*

오름차순으로 정렬되어 있어야 하므로 작은 숫자부터 순차적으로 탐색한다.
백트래킹을 활용해야 하므로 백트래킹 조건을 설정한다.
ㄴ 숫자 조합 합이 10 이상인 경우 백트래킹한다.
* 만약 숫자 조합 합이 10이 되면 그 숫자 조합을 저장한다.

*/
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> result; // 합이 10이 되는 숫자 조합을 담는 리스트
    static int N; // 1부터 N까지의 숫자만 허용

    // backtracking 함수 정의
    static void backtracking(int start, int sum, ArrayList<Integer> list){
        if(sum >= 10){ // 백트래킹 조건에 맞으면 return
            if(sum == 10){ result.add(list);} // 숫자 조합 합이 10이 되면 그 숫자 조합을 저장
            return;
        }
        for(int i = start+1; i <= N; i++){ // 다음 숫자 넣기
            ArrayList<Integer> nextList = new ArrayList<>(list); // 새로운 리스트 객체 만듦.
            nextList.add(i); // i~N까지의 숫자 중 하나 넣기
            backtracking(i, sum+i, nextList); // backtracking 재귀
        }

    }

    // solution 함수 정의
    static ArrayList<ArrayList<Integer>> solution (int n){
        result = new ArrayList<>(); // result
        N = n; // N 초기화
        backtracking(0, 0 ,new ArrayList<>()); // 백트래킹 함수 호출
        return result;
    }


    public static void main(String[] args) {
        System.out.println(solution(5).toString());
        System.out.println(solution(2).toString());
        System.out.println(solution(7).toString());
    }
}
