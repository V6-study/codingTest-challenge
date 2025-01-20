// https://www.acmicpc.net/problem/9252
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][][] lengthLCS(String str1, String str2) {
        int[][][] LCS = new int[str1.length()+1][str2.length()+1][2];
        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) { // 공통 부분
                    LCS[i][j][0] = LCS[i-1][j-1][0] + 1; // 최장 길이에서 1 더하기
                    LCS[i][j][1] = 1; // i-1, j-1 이동
                }else if(LCS[i][j-1][0] > LCS[i-1][j][0]) {
                    LCS[i][j][0] = LCS[i][j-1][0];
                    LCS[i][j][1] = 2; // j-1 이동
                }else{
                    LCS[i][j][0] = LCS[i-1][j][0];
                    LCS[i][j][1] = 3; // i-1 이동
                }
            }
        }
        System.out.println(LCS[str1.length()][str2.length()][0]); // 최장 부분 수열 출력
        return LCS;
    }
    
    private static void getLCS(String str1, String str2, int[][][] LCS) {
        StringBuilder sb = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        while(i > 0 && j > 0){
            if(LCS[i][j][1] == 1){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(LCS[i][j][1] == 2) j--;
            else if(LCS[i][j][1] == 3) i--;
        }
        System.out.println(sb.reverse());
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][][] LCS = lengthLCS(str1, str2);
        getLCS(str1, str2, LCS);
    }
}
