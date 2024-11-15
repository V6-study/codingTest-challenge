class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length - 1;
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i * 2 + length - next); // 처음에서 i번째까지 이동하고, 뒤로 이동하는 경우
            move = Math.min(move, (length - next) * 2 + i); // 처음부터 뒤로 이동하고, 다시 앞으로 오는 경우
        }
        return answer + move;
    }
}
