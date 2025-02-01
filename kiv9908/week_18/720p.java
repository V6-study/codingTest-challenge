import java.util.*;

public class Solution {
    static Set<Set<String>> resultSet = new HashSet<>();

    public static int solution(String[] user_id, String[] banned_id) {
        backtrack(new HashSet<>(), user_id, banned_id, 0);
        return resultSet.size();
    }

    private static void backtrack(Set<String> currentSet, String[] user_id, String[] banned_id, int index) {
        // 모든 banned_id를 처리했으면 결과를 저장
        if (index == banned_id.length) {
            resultSet.add(new HashSet<>(currentSet));
            return;
        }

        // 현재 banned_id[index]와 매칭 가능한 user_id를 찾음
        for (String user : user_id) {
            if (!currentSet.contains(user) && isMatch(banned_id[index], user)) {
                currentSet.add(user); // user_id를 추가
                backtrack(currentSet, user_id, banned_id, index + 1); // 다음 단계로 이동
                currentSet.remove(user); // 백트래킹 (이전 상태로 되돌림)
            }
        }
    }

    private static boolean isMatch(String banned, String user) {
        if (banned.length() != user.length()) {
            return false;
        }

        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) != '*' && banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}
