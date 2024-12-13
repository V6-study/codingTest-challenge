// https://school.programmers.co.kr/learn/courses/30/lessons/42746
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int number : numbers){
            list.add(String.valueOf(number));
        }
        list.sort((o1, o2) -> {
            int num1 = Integer.parseInt(o1 + o2);
            int num2 = Integer.parseInt(o2 + o1);
            return num2 - num1;
        });
            
        StringBuilder sb = new StringBuilder();
        for(String num : list){
            sb.append(num);
        }
    
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}
