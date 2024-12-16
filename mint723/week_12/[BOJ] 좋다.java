// https://www.acmicpc.net/problem/1253
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int min = 0;
            int max = N-1;

            while(min < max){

                // 자기 자신을 더하지 않는 조건
                if(i==min){
                    min++;
                    continue;
                }

                if(i==max){
                    max--;
                    continue;
                }

                int sum = arr[min] + arr[max];
                if(sum > num){
                    max--;
                }else if(sum < num){
                    min++;
                }else{
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}
