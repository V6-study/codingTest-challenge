// https://school.programmers.co.kr/learn/courses/30/lessons/150370#
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> terms_= new HashMap<>();
        for(String t : terms){
            terms_.put(t.split(" ")[0], Integer.parseInt((t.split(" ")[1])));
        }
        int[] today_ = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i<privacies.length; i++){
            int[] date = Arrays.stream(privacies[i].split(" ")[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
            int term = terms_.get(privacies[i].split(" ")[1]);
            
            date[0] += (date[1]+term) / 12;
            date[1] = (date[1]+term) % 12;
            if(date[1] == 0){
                date[1] = 12;
                date[0]--;
            }
            
            if(date[0] < today_[0]) answer.add(i+1);
            if(date[0] == today_[0]){
                if(date[1] < today_[1]) answer.add(i+1);
                if(date[1] == today_[1]){
                    if(date[2] <= today_[2]) answer.add(i+1);
                }
            }
        }
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
