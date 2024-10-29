// https://school.programmers.co.kr/learn/courses/30/lessons/42579
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreCnt = new HashMap<>(); // 장르별 재생 횟수
        HashMap<String, Deque<Integer>> genreBest = new HashMap<>(); // 장르별 많이 재생된 음악 2개
        for(int i = 0; i<genres.length ; i++){
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0)+plays[i]); // 장르별 재생 횟수 더해주기
            
            if(genreBest.containsKey(genres[i])){ // genreBest에 있는 장르일 때
                if(plays[genreBest.get(genres[i]).getFirst()] < plays[i]){ // 맨 앞에 있는 음악이 현재 음악보다 재생횟수가 적으면
                    genreBest.get(genres[i]).offerFirst(i); // 맨 앞에 현재 음악을 추가해줌
                    // 음악 수가 2보다 크면 마지막꺼 삭제
                    if(genreBest.get(genres[i]).size() > 2){  
                        genreBest.get(genres[i]).pollLast();
                    }
                } else if (genreBest.get(genres[i]).size() == 1){ // 음악 수가 1개면 마지막에 현재 음악 추가
                    genreBest.get(genres[i]).offerLast(i);
                } else if (plays[genreBest.get(genres[i]).getLast()] < plays[i]){ // 마지막 음악이 현재 음악보다 재생횟수가 적으면            
                    genreBest.get(genres[i]).pollLast(); // 마지막꺼 삭제하고
                    genreBest.get(genres[i]).offerLast(i); // 현재 음악 마지막에 추가
                }
            }else{ // genreBest에 없는 장르일 때
                // deque 만들어서 현재 음악 추가 후 genreBest에 추가
                Deque<Integer> temp = new LinkedList<>();
                temp.push(i);
                genreBest.put(genres[i], temp);
            }
        }
        
        // genre 재생횟수 많은 순으로 key 정렬
        List<String> genreSet = new ArrayList<>(genreCnt.keySet());
        genreSet.sort((o1, o2) -> genreCnt.get(o2).compareTo(genreCnt.get(o1))); 
        // 정렬된 key 순회하면서 answer 만들기
        List<Integer> answer = new ArrayList<>();
        for(String genre : genreSet){
            for(Integer i: genreBest.get(genre)){
                answer.add(i);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
