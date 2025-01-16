import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static long maxSize;
    static int minSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        maxSize = 0;
        minSize = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxSize += arr[i]; // 모든 강의의 길이 합
            minSize = Math.max(minSize, arr[i]); // 가장 긴 강의 길이
        }

        System.out.println(find());
    }

    private static long find() {
        long low = minSize;
        long high = maxSize;

        while (low < high) {
            long mid = (low + high) / 2; // 중간값
            if (count(mid) > m) { // 블루레이 개수가 m보다 많으면 크기를 늘려야 함
                low = mid + 1;
            } else { // m 이하라면 크기를 줄일 수 있음
                high = mid;
            }
        }

        return low; // 최소 크기 반환
    }

    private static int count(long mid) {
        int cnt = 1; // 최소 블루레이 하나는 필요
        long size = 0;

        for (int i : arr) {
            if (size + i > mid) { // 현재 블루레이에 더 이상 담을 수 없다면
                cnt++; // 새 블루레이 필요
                size = i; // 새로운 블루레이에 현재 강의 추가
            } else {
                size += i; // 현재 블루레이에 추가
            }
        }

        return cnt; // 사용된 블루레이 개수 반환
    }
}
