// https://www.acmicpc.net/problem/18870
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        // 좌표 중복 제거, 정렬 후 index와 좌표 값 해시에 저장
        long[] distinct = Arrays.stream(str.split(" ")).mapToLong(Long::parseLong).distinct().sorted().toArray();
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < distinct.length; i++){
            map.put(distinct[i], i);
        }
        // 해시 값으로 좌표 수정 후 출력
        StringTokenizer st = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            sb.append(map.get(Long.parseLong(st.nextToken()))+" ");
        }
        System.out.println(sb);
    }
}
