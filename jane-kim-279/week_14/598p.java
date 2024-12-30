class Solution {
    static int N, M;

    public int[] solution(String[] keyinput, int[] board) {
        N = board[0] / 2;
        M = board[1] / 2;
        int x = 0, y = 0;
      
        for (String input : keyinput) {
            if (input.equals("left") && check(x - 1, y)) {
                x -= 1;
            } else if (input.equals("right") && check(x + 1, y)) {
                x += 1;
            } else if (input.equals("up") && check(x, y + 1)) {
                y += 1;
            } else if (input.equals("down") && check(x, y - 1)) {
                y -= 1;
            }
        }
        int[] answer = {x, y};
        return answer;
    }

    public static boolean check(int x, int y) {
        return Math.abs(x) <= N && Math.abs(y) <= M;
    }
}
