import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<Long> result = new ArrayList<>();

        while (result.size() < n) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            while (st.hasMoreTokens() && result.size() < n) {
                result.add(reverseNumber(st.nextToken()));
            }
        }

        Collections.sort(result);
        for (Long num : result) {
            System.out.println(num);
        }
    }

    private static Long reverseNumber(String s) {
        StringBuilder sb = new StringBuilder(s.trim()).reverse();
        return Long.parseLong(sb.toString());
    }

}
