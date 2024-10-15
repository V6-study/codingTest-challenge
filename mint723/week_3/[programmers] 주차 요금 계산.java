// https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        // 기본 시간 / 기본 요금 / 단위 시간 / 단위 요금
        // fees[0] / fees[1] / fees[2] / fees[3]
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        // 시각(시:분) / 차량 번호 / 내역
        // 00:00       / 0000    / IN OUT
        Stack<Map<String, String>> histories = new Stack<>();
        Map<String, Integer> cars = new HashMap<>();
        
        for(String record : records){
            String[] arr = record.split(" ");
            if(arr[2].equals("IN")){
                Map<String, String> map = new HashMap<>();
                map.put(arr[1], arr[0]);
                histories.push(map);
            }else{
                Queue<Map<String, String>> q = new LinkedList<>();
                while(!histories.isEmpty() && !histories.peek().containsKey(arr[1])){
                    q.offer(histories.pop());
                }
                if(!histories.isEmpty()){
                    Map<String, String> history = histories.pop();
                    String[] time = history.get(arr[1]).split(":");
                    String[] lastTime = arr[0].split(":");
                    
                    int totalTime = (Integer.parseInt(lastTime[0]) * 60 + Integer.parseInt(lastTime[1])) - 
                        (Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
                    if(cars.containsKey(arr[1])){
                        cars.put(arr[1], cars.get(arr[1])+totalTime);
                    }else{
                        cars.put(arr[1], totalTime);
                    }
                    
                }
                while(!q.isEmpty()){
                    histories.push(q.poll());
                }
            }
        }
        
        while(!histories.isEmpty()){
            Map<String, String> history = histories.pop();
            List<String> list = new ArrayList<>(history.keySet());
            String[] time = history.get(list.get(0)).split(":");
            
            int totalTime = (23 * 60 + 59) - 
                        (Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
            
            if(cars.containsKey(list.get(0))){
                cars.put(list.get(0), cars.get(list.get(0))+totalTime);
            }else{
                cars.put(list.get(0), totalTime);
            }
        }

        List<String> carNumbers = new ArrayList<>(cars.keySet());
        Collections.sort(carNumbers);
        
        for(int i=0; i<carNumbers.size(); i++){
            int totalTime = cars.get(carNumbers.get(i));
            if(totalTime<=basicTime){
                answer.add(basicFee);
            }else{
                int fee = basicFee + (int)Math.ceil(((totalTime - basicTime)*1.0) / unitTime) * unitFee;
                answer.add(fee);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
