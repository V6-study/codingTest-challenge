import java.util.Arrays;

public class Main {
    private static int solution(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // 최소 길이 1이므로 1로 다 채워주기
        int lis = 1; // lis 값 저장
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                // n>i && num[n]>num[i]인 값들 중 dp[n]이 가장 큰 것에 +1하여 저장.
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lis = Math.max(lis, dp[i]); // lis 값 최장 값으로 변경
        }
        return lis;
    }

    public static void main(String[] args) {
        System.out.println("tc1 : "+solution(new int[] {1, 4, 2, 3, 1, 5, 7, 3})); //5
        System.out.println("tc2 : "+solution(new int[] {3, 2, 1})); //1
        System.out.println("tc3 : "+solution(new int[] {3, 2, 1, 3})); //2
    }
}
