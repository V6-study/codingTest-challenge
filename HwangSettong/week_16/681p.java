import java.util.Arrays;

public class Main {
    private static double solution(int[][] items, int weight_limit){
        // items를 무게 당 가치가 높은 순으로 정렬
        Arrays.sort(items, (o1, o2) -> {
            if((double)o1[1]/o1[0] > (double)o2[1]/o2[0]) return -1;
            if((double)o1[1]/o1[0] < (double)o2[1]/o2[0]) return 1;
            return 0;
        });
        double res = 0;
        for(int[] item : items){
            if(weight_limit >= item[0]) res += item[1]; // item의 무게가 제한에 걸리지 않으면 배낭에 추가
            else res += (double)weight_limit*item[1]/item[0]; // item의 무게가 제한에 걸리면 쪼개서 추가
            weight_limit -= item[0]; // 배낭에 담았으면 무게 제한 감소
            if(weight_limit <= 0) break; // 더 이상 담을 수 없으면 break
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{10,19}, {7,10}, {6,10}}, 15));
        System.out.println(solution(new int[][] {{10,60}, {20,100}, {30,120}}, 50));
    }
}
