import java.util.*;

class Solution {
    static int[] Stones;

    public static int binarySearch(int left, int right, int k) {
        if (left <= right) {
            int mid = (left + right) / 2;

            if (checkCross(mid, k)) {
                return binarySearch(mid + 1, right, k);
            } else {
                return binarySearch(left, mid - 1, k);
            }
        }

        return left;
    }

    public static boolean checkCross(int M, int k) {
        int zero = 0;
        for (int i = 0; i < Stones.length; i++) {
            if (Stones[i] - M <= 0) {
                zero++;
                if (zero >= k) {
                    return false;
                }
            } else {
                zero = 0;
            }
        }
        return true;
    }

    public int solution(int[] stones, int k) {
        Stones = stones;
        int answer = binarySearch(0, 200000001, k);
        return answer;
    }
}
