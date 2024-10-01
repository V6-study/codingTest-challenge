import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] org = {4, 2, 2, 1, 3, 4};
        System.out.println(Arrays.toString(solution(org)));
    }

    static int[] solution(int[] arr) {
        // 중복 제거
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

        // 내림차순 정렬
        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
