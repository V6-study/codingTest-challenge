import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(0,s.length()-2).replace("{","");
        String[] arr = s.split("},");
        Arrays.sort(arr,(o1,o2) -> {
            int length1 = o1.length();
            int length2 = o2.length();
            return Integer.compare(length1,length2);
        });
        
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[arr.length];
        
        for(int i = 0;i<arr.length;i++){
            String[] numbers = arr[i].split(",");
            for(String num : numbers){
                if(!set.contains(num)){
                    set.add(num);
                    answer[i] = Integer.parseInt(num);
                }
            }
        }
        return answer;
    }
}