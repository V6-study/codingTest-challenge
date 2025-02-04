//https://school.programmers.co.kr/learn/courses/30/lessons/86051
import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int sum = 0, num = 0;
        for(int n : numbers){
            while(n != num) sum += num++;
            num++;
        }
        for(int i = num; i <= 9; i++) sum+=i;
        return sum;
    }
}
