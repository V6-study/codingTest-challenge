// https://www.acmicpc.net/problem/1931
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> time = new HashMap<>(); //key: 종료시간, value: 시작시간(max)
        HashMap<Integer, Integer> sameTime = new HashMap<>(); //key : 시작시간과 종료시간이 같을 때 시간, value: 몇번이나 발생하는지
        int[] input; // 회의
        for(int n = 0; n < N; n++){
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0] == input[1]){ // 시작시간 == 종료시간인 경우
                sameTime.put(input[0], sameTime.getOrDefault(input[0], 0)+1);
            } else {
                time.put(input[1], Math.max(time.getOrDefault(input[1], 0), input[0]));
            }
        }

        int count = 0;
        ArrayList<Integer> keySet = new ArrayList<>(time.keySet());
        sameTime.keySet().stream().forEach(i->{if(! keySet.contains(i)){keySet.add(i);}});
        Collections.sort(keySet);
        int preEndTime = -1;
        // 회의 종료 시간이 작은 것부터 오름차순으로 순회.
        for(int i = 0; i< keySet.size(); i++){
            int t = keySet.get(i);
            // 회의 시작 시간이 이 전에 구한 종료시간보다 크면 count
            // (아래에서 종료시간=시작시간인 경우 계산할거기 때문에 그 경우는 제외)
            if(time.get(t) != null && time.get(t) != t && time.get(t) >= preEndTime){
                count++;
                preEndTime = t;
            }
            // 회의 종료시간 = 시작시간인 경우가 있으면 그 경우의 수만큼 count
            if(sameTime.containsKey(t)){
                count += sameTime.get(t);
                preEndTime = t;
            }
        }

        System.out.println(count);
        
    }
}
