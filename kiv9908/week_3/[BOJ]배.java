// https://www.acmicpc.net/problem/1092
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> weight = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(weight, Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());

        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes, Collections.reverseOrder());

        if (boxes.get(0) > weight.get(0)) {
            System.out.println(-1);
            return;
        }

        int rounds = 0;
        while (!boxes.isEmpty()) {
            int boxIndex = 0;
            for (int i = 0; i < n && boxIndex < boxes.size(); ) {
                // 크레인이 들 수 있는 가장 무거운 박스를 찾아서 처리
                if (boxes.get(boxIndex) <= weight.get(i)) {
                    boxes.remove(boxIndex);
                    i++;
                } else {
                    boxIndex++;
                }
            }
            rounds++;
        }

        System.out.println(rounds);
    }
}
