//https://school.programmers.co.kr/learn/courses/30/lessons/42746
import java.util.*;
import java.lang.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> a = new ArrayList<>();
        int check = 0;
        for(int n: numbers){
            check+=n;
            a.add(String.valueOf(n));
        }
        if(check == 0){ return "0";}
        
        a.sort( (o1, o2) -> Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2));
        return String.join("",a);
    }
}
