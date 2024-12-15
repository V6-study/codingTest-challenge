// https://www.acmicpc.net/problem/1181
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(set);
        list.sort((o1,o2) -> {
            int length1 = o1.length();
            int length2 = o2.length();
            if (length1 == length2) {
                return o1.compareTo(o2);
            }
            return length1 - length2; // Integer.compare(length1,length2);
        });
        for(String s : list) {
            System.out.println(s);
        }
    }
}