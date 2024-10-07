import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Double> rate = new HashMap<>();
        int total = stages.length;
        Arrays.sort(stages);
        for(int stage : stages){
            if(map.containsKey(stage)){
                map.put(stage, map.get(stage) + 1);
            }else{
                map.put(stage, 1);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=N; i++){
            if(map.containsKey(i)){
                rate.put(i, (Double)(map.get(i)*1.0/total));
                total -= map.get(i);
            }else{
                rate.put(i, 0*1.0);
            }
            list.add(i);
        }
        
        Collections.sort(list, (o1, o2) -> {
            
            int compare = Double.compare(rate.get(o2), rate.get(o1));
            if(compare == 0){
                return o1 - o2;
            } else {
                return compare;
            }
        });
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
