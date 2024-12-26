class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int sqrt = (int) Math.sqrt(total);
        for (int y = 3; y <= sqrt; y++) {
            if (total % y == 0) {
                int x = total / y;
                if (2 * (x + y - 2) == brown) {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        return answer;
    }
}
