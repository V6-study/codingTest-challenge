// https://www.acmicpc.net/problem/1932
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 삼각형의 크기
        // 정수 삼각형 입력받기
        ArrayList<Integer>[] tri = new ArrayList[n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tri[i] = new ArrayList<>();
            while(st.hasMoreTokens()) {
                tri[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int temp1, temp2;
        // 가장 윗 줄부터 합 계산해 나가기
        for(int i=1; i<n; i++) {
            tri[i].set(0, tri[i - 1].get(0) + tri[i].get(0)); // 가장 왼쪽 끝의 값은 항상 전 줄 왼쪽 끝 값을 더한거
            // 양 끝을 제외하고는 전 줄의 왼쪽, 오른쪽 값을 더한 값 중 큰 값을 저장
            for (int j = 1; j < i; j++) {
                temp1 = tri[i].get(j) + tri[i - 1].get(j - 1);
                temp2 = tri[i].get(j) + tri[i - 1].get(j);
                tri[i].set(j, Math.max(temp1, temp2));
            }
            tri[i].set(i, tri[i - 1].get(i - 1) + tri[i].get(i)); // 가장 오른쪽 끝의 값은 항상 전 줄 오른쪽 끝 값을 더한거
        }
        tri[n-1].stream().max(Integer::compareTo).ifPresent(System.out::println); // 가장 마지막 줄의 max값 구하기
    }
}
