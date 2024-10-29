// https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> categories = new HashMap<>(); 
        Map<String, Map<Integer, Integer>> count = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            
            if(!categories.containsKey(genres[i])){
                Map<Integer, Integer> map = new HashMap<>();
                categories.put(genres[i], plays[i]);
                map.put(i, plays[i]);
                count.put(genres[i], map);
            }
            else{
                categories.put(genres[i], categories.get(genres[i])+plays[i]);
                Map<Integer, Integer> map = count.get(genres[i]);
                map.put(i, plays[i]);
                count.put(genres[i], map);
            }
        }
        
        List<String> list = new ArrayList<>(categories.keySet());
        
        Collections.sort(list, (o1, o2) -> {
            return categories.get(o2) - categories.get(o1);
        });
        
        List<Integer> answer = new ArrayList<>();
        
        for(String s : list){
            Map<Integer, Integer> map = count.get(s);
            List<Integer> countList = new ArrayList<>(map.keySet());
            Collections.sort(countList, (o1, o2) -> {
                if(map.get(o1) == map.get(o2))
                    return o1 - o2;
                return map.get(o2)-map.get(o1);
            });
            int n = Math.min(countList.size(), 2);
            
            for(int i=0; i<n; i++){
                answer.add(countList.get(i));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
