// https://www.acmicpc.net/problem/1339
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, int[]> map = new HashMap<>(); // key: 알파벳, value: 각 자리(index) 별로 등장한 횟수
        int N = Integer.parseInt(br.readLine());

        // 입력 받으면서 map 채워넣기
        for(int n = 1; n <= N; n++) {
            String[] word = br.readLine().split("");
            int t = 8-word.length;
            for(int i = 0; i<word.length; i++) {
                if(map.containsKey(word[i])) {
                    map.get(word[i])[i+t]++;
                }else{
                    int[] temp = new int[8];
                    temp[i+t]++;
                    map.put(word[i], temp);
                }
            }
        }


        int answer = 0;
        int num = 9;
        while(!map.isEmpty()){
            int max = -1;
            String maxAl = null;
            // 알파벳 순회하면서 값이 num으로 대체될 때 가장 큰 것 찾기
            for(String key : map.keySet()){
                int[] arr = map.get(key);
                int temp = 0;
                for(int i = 0; i<8; i++){
                    temp += num * Math.pow(10, 7-i) * arr[i];
                }
                if(max < temp){
                    max = temp;
                    maxAl = key;
                }
            }
            // 계산 값 가장 큰 것 answer에 더해주고, countByIdx에서 알파벳 삭제.
            answer += max;
            map.remove(maxAl);
            // num 1씩 줄이기
            num --;
        }
        System.out.println(answer);
    }
}
