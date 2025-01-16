
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] items = {{10, 19}, {7, 10}, {6, 10}};
        int weight_limit = 15;
        System.out.println(greedy(items, weight_limit));
    }

    private static double greedy(int[][] items, int weight_limit) {
        double answer = 0;
        // 가치/무게 비율 기준으로 내림차순 정렬
        Arrays.sort(items, (o1, o2) -> Double.compare(
                (double) o2[1] / o2[0], (double) o1[1] / o1[0]
        ));
        for (int i = 0; i < items.length; i++) {
            int weight = items[i][0];
            int value = items[i][1];
            double unitWeight = (double) value / weight; // 단위 무게당 가치

            // 현재 물건을 담을 수 있는 만큼 담기
            if (weight_limit >= weight) {
                answer += value; // 전체 물건 담기
                weight_limit -= weight;
            } else {
                answer += weight_limit * unitWeight; // 남은 무게만큼 비율로 담기
                break;
            }
        }

        return answer;
    }
}
