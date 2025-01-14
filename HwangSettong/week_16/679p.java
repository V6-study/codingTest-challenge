import java.util.*;

public class Main {
    private static int[] solution(int amount){
        int[] money = {100, 50, 10, 1}; // 거스름돈
        List<Integer> change = new ArrayList<>();
        for(int m : money){
            int cnt = amount / m;
            while(cnt-- > 0){
                change.add(m);
            }
            amount %= m;
        }
        return change.stream().mapToInt(i->i).toArray();
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(123)));
        System.out.println(Arrays.toString(solution(350)));
    }
}
