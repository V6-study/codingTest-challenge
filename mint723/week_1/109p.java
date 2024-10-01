import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4,2,2,1,3,4})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    private static int[] solution(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
