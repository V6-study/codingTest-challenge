import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i < words.length; i++){
            if(map.isEmpty()){
                map.put(words[i], 1);
            }else{
                if(words[i].startsWith(words[i-1].substring(words[i-1].length()-1))){
                    map.put(words[i], map.getOrDefault(words[i],0)+1);
                    if(map.get(words[i]) >=2){
                        answer[0] = (i % n) + 1;
                        answer[1] = (i / n) +1;
                        break;
                    }
                }else{
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) +1;
                    break;
                }

                
            }
        }

        return answer;
    }
}