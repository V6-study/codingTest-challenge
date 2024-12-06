public class Solution {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "algorithm";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }

    static String solution(String s){
        int[] counts = new int[26];

        for(char c : s.toCharArray()){
            counts[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            for(int j=0; j<counts[i]; j++){
                sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }
}
