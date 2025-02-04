public class Solution {
    public static int solution(int n, int k) {
        // n을 k진법으로 변환
        String kBase = Integer.toString(n, k);

        // k진법 변환 결과를 "0"으로 나누기
        String[] candidates = kBase.split("0");

        int count = 0;

        // 각 숫자가 소수인지 확인
        for (String candidate : candidates) {
            if (!candidate.isEmpty()) {
                long num = Long.parseLong(candidate);
                if (isPrime(num)) {
                    count++;
                }
            }
        }

        return count;
    }

    // 소수 판별 함수
    public static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}