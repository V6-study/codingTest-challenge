import java.util.*;

class Solution {
    static int N, K;
    static String[] userId;
    static String[] bannedId;
    static HashSet<HashSet<String>> combination = new HashSet<>(); 

    public static void dfs(HashSet<String> set, int depth) {
        if (depth == K) {
            combination.add(set);
            return;
        }

        for (String id : userId) {
            if (set.contains(id)) {
                continue;
            }

            if (check(id, bannedId[depth])) {
                set.add(id);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(id);
            }
        }
    }

    public static boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }

        return true;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        K = banned_id.length;

        userId = user_id;
        bannedId = banned_id;

        dfs(new HashSet<>(), 0);

        return combination.size();
    }
}
