// https://www.acmicpc.net/problem/9935
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder original = new StringBuilder(br.readLine());
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < original.length(); i++) {
            sb.append(original.charAt(i)); // 한 글자씩 추가
            if(sb.indexOf(bomb, sb.length()-bomb.length())>-1){ // 끝에 문자열 bomb인지 확인
                sb.delete(sb.length()-bomb.length(), sb.length()); // bomb이면 삭제
            }
        }

        br.close();
        bw.write((sb.length() == 0 ? "FRULA":sb.toString()));
        bw.flush();
        bw.close();
    }
}
