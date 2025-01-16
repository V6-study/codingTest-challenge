import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] items1 = {{10, 19}, {7, 10}, {6, 10}};
        System.out.println(solution(items1, 15));
        int[][] items2 = {{10, 60}, {20, 100}, {30, 120}};
        System.out.println(solution(items2, 50));
    }

    private static double solution(int[][] items, int weight_limit) {

        Arrays.sort(items, (o1, o2) -> Double.compare(
                (double) o2[1]/o2[0], (double) o1[1]/o1[0]
        ));

        double answer = 0;
        int remainingWeight = weight_limit;

        for(int[] item : items){
            int weight = item[0];
            int value = item[1];
            double valuePerWeight = (double) value/weight;

            if(weight <= remainingWeight){
                remainingWeight-=weight;
                answer+=value;
            }else{
                answer += valuePerWeight * remainingWeight;
                break;
            }
        }

        return answer;
    }

}
