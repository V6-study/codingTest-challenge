public class Main {
    private static int solution(String str1, String str2){
        int[][] map = new int[str1.length()+1][str2.length()+1];
        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    map[i+1][j+1] = map[i][j] + 1;
                }else{
                    map[i+1][j+1] = Math.max(map[i][j+1], map[i+1][j]);
                }
            }
        }
        return map[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        System.out.println("tc1 : "+solution("ABCBDAB", "BDCAB"));
        System.out.println("tc2 : "+solution("AGGTAB", "GXTXAYB"));
    }
}
