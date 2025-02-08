// https://school.programmers.co.kr/learn/courses/30/lessons/86051
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int length = numbers.length;
        boolean[] memo = new boolean[10];
        
        
        for(int i = 0;i<length;i++){
            memo[numbers[i]] = true;
        }
        
        for(int i = 1;i<10;i++){
            if(!memo[i]){
                answer += i;
            }
        }
        
        return answer;
    }
}
