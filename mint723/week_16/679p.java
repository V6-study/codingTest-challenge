import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(123)));
        System.out.println(Arrays.toString(solution(350)));
    }

    private static int[] solution(int amount) {
        int[] coins = {100, 50, 10, 1};

        List<Integer> list = new ArrayList<>();

        for (int coin : coins) {
            while (amount >= coin) {
                list.add(coin);
                amount -= coin;
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
