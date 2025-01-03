// https://www.acmicpc.net/problem/2467
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pointer1 = 0, pointer2 = Integer.parseInt(br.readLine())-1; // pointer1=0, pointer2=n-1
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 용액 배열
        br.close();

        // 두 용앱의 합이 0에 가까운 것 찾기
        int minSum = 2000000000; // |두 용액의 합|의 최소 값 저장
        int[] res = new int[2]; // |두 용액의 합|이 최소 일 때 두 용액 오름차순 저장
        while(arr[pointer1] < arr[pointer2]){
            if(Math.abs(arr[pointer1]+arr[pointer2]) < minSum){
                minSum = Math.abs(arr[pointer1]+arr[pointer2]);
                res[0] = arr[pointer1];
                res[1] = arr[pointer2];
            }
            // |arr[pointer]|가 더 큰 값의 pointer를 이동 시키기
            if(- arr[pointer1] > arr[pointer2]){
                pointer1++;
            }else{
                pointer2--;
            }
        }
        System.out.println(res[0] +" "+ res[1]);
    }
}
