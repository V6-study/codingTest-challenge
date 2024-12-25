import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String[]> list = new ArrayList<>();

        // 입력이 없을 때까지 반복
        while (!((line = br.readLine()).equals("end"))) {
            boolean isValid = true;

            // 1. 모음(a, e, i, o, u) 하나를 반드시 포함하여야 한다.
            if (!line.matches(".*[aeiou].*")) { // 정규식으로 모음 포함 여부 확인
                isValid = false;
            }

            // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            if (hasThreeConsecutive(line)) {
                isValid = false;
            }

            // 3. 같은 글자가 연속적으로 두 번 오면 안 되나, ee와 oo는 허용한다.
            if (!isAllowedRepetition(line)) {
                isValid = false;
            }

            // 결과 저장
            String result = "<"+line+">" + " is " + (isValid ? "acceptable." : "not acceptable.");
            list.add(new String[] { line, result});
        }

        // 결과 출력
        for (String[] s : list) {
            System.out.println(s[1]);
        }
    }

    // 조건 2: 모음/자음이 3개 연속으로 오는지 확인
    private static boolean hasThreeConsecutive(String line) {
        int vowelCount = 0, consonantCount = 0;
        for (char c : line.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) { // 모음 체크
                vowelCount++;
                consonantCount = 0;
            } else { // 자음 체크
                consonantCount++;
                vowelCount = 0;
            }

            if (vowelCount >= 3 || consonantCount >= 3) {
                return true; // 모음 또는 자음 3개 연속
            }
        }
        return false;
    }

    // 조건 3: 연속 글자 확인 (ee와 oo는 허용)
    private static boolean isAllowedRepetition(String line) {
        for (int i = 1; i < line.length(); i++) {
            char prev = line.charAt(i - 1);
            char curr = line.charAt(i);

            if (prev == curr && !(prev == 'e' || prev == 'o')) {
                return false; // 같은 글자가 연속되며 ee와 oo 제외
            }
        }
        return true;
    }
}
