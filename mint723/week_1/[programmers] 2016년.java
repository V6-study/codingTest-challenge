import java.util.*;
class Solution {
    public String solution(int a, int b) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 31); map.put(2, 29); map.put(3, 31); map.put(4, 30);
        map.put(5, 31); map.put(6, 30); map.put(7, 31); map.put(8, 31);
        map.put(9, 30); map.put(10, 31); map.put(11, 30); map.put(12, 31);
        
        Map<Integer, String> day = new HashMap<>();
        day.put(0,"FRI"); day.put(1,"SAT"); day.put(2,"SUN"); 
        day.put(3,"MON"); day.put(4,"TUE"); day.put(5,"WED"); 
        day.put(6,"THU");
        
        int calcDate = 0;
        for(int i=1; i<a; i++){
            calcDate += map.get(i);
        }
        calcDate += b - 1;
        while(calcDate>6){
            calcDate-=7;
        }
        return day.get(calcDate%7);
        
    }
}
