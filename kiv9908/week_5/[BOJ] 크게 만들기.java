import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();

        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peekLast() < arr[i] && k > 0){
                q.removeLast();
                k--;
            }
            q.offerLast(arr[i]);
        }

        StringBuilder answer = new StringBuilder();
        while (q.size() > k) {
            answer.append(q.removeFirst());
        }

        System.out.println(answer);

    }
}