// https://www.acmicpc.net/problem/6550
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // 입력이 없을 때까지 반복
        while ((line = br.readLine()) != null) {
            String[] inputs = line.split(" ");
            String s = inputs[0]; // 첫 번째 문자열
            String t = inputs[1]; // 두 번째 문자열

            int sIndex = 0; // s의 현재 위치를 추적

            for (int i = 0; i < t.length(); i++) {
                if (sIndex < s.length() && s.charAt(sIndex) == t.charAt(i)) {
                    sIndex++; // s의 다음 문자로 이동
                }
            }

            // sIndex가 s의 길이와 같다면 s가 t의 부분 문자열임
            if (sIndex == s.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
