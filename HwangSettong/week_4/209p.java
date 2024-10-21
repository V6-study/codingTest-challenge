// https://school.programmers.co.kr/learn/courses/30/lessons/159994
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 두 card 배열 index 변수와 goal 배열 index 변수 정의
        int idx1 = 0, idx2 =0; 
        
        // goal 배열 loop
        for(int i = 0; i<goal.length; i++){
            if(idx1 < cards1.length && cards1[idx1].equals(goal[i])){ // goal안의 현재 단어가 cards1에서 추출 가능할 때
                idx1++; // 
            }else if(idx2 < cards2.length && cards2[idx2].equals(goal[i])){  // goal안의 현재 단어가 cards2에서 추출 가능할 때
                idx2++;
            }else{ // cards1, cards2에서 추출 불가능할 때
                return "No";
            }
        }
        return "Yes";
    }
}
