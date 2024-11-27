// https://github.com/retrogemHK/codingtest_java/blob/main/solution/43.java

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(2));
        System.out.println(solution(7));
    }

    static List<List<Integer>> result;
    static int n;
    static void backtrack(int sum, List<Integer> selectedNums, int start){
        if(sum == 10){
            result.add(selectedNums);
            return;
        }

        for (int i = start; i <= n; i++) {
            if(sum + i <= 10){
                List<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backtrack(sum + i, list, i + 1);
            }
        }
    }

    public static List<List<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;
        backtrack(0, new ArrayList<>(), 1);

        return result;
    }
}
