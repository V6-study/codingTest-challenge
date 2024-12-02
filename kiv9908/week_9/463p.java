import java.util.ArrayList;

public class Solution {

    private static ArrayList<ArrayList<Integer>> result;
    private static int n;
    private static void backtrack (int sum, ArrayList<Integer> selectedNums, int start){
        if(sum == 10){
            result.add(selectedNums);
            return;
        }

        for(int i = start; i < n+1; i++){
            if(sum + i <= 10){
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backtrack(sum+i, list, i+1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> solution(int N){
        result = new ArrayList<>();
        n = N;
        backtrack(0, new ArrayList<>(), 1);
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,2,7};
        for(int i : nums){
            ArrayList<ArrayList<Integer>> result = solution(i);
            System.out.println(result);
        }

    }
}