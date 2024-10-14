// https://www.acmicpc.net/problem/10986
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long m = Integer.parseInt(br.readLine().split(" ")[1]);
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        for(long n : arr) {
            sum = (sum+n)%m;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        long answer = 0, cnt;
        for(long key : map.keySet()) {
            cnt = map.get(key);
            if(key == 0){cnt++;}
            answer += cnt*(cnt-1)/2;
        }
        System.out.println(answer);
    }
}
