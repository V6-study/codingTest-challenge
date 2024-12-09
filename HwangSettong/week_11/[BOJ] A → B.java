import java.io.*;
import java.util.*;

public class Main {
    private static long bfs(int n, int target){
        if(n == target) return 1;
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{n, 1L});
        long result = -1;
        long[] info;
        while(!queue.isEmpty()){
            info = queue.poll();
            // 다음 연산 결과가 target과 같으면 연산 값 return
            if(info[0] * 2 == target || info[0]*10+1 == target) return info[1]+1;
            // 연산 결과가 target보다 작을 때만 다음 연산 추가
            if(info[0] * 2 < target) queue.add(new long[]{info[0]*2, info[1]+1});
            if(info[0] * 10 + 1 < target) queue.add(new long[]{info[0]*10+1, info[1]+1});

        }
        return result;

    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        System.out.print(bfs(input[0], input[1]));
    }
}
