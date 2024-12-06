class Solution {
    private static String solution(String s) {
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}
