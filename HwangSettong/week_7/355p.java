// https://school.programmers.co.kr/learn/courses/30/lessons/12981
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        // arr: 지금까지 나온 단어들을 저장하는 ArrayList 정의
        ArrayList<String> arr = new ArrayList<>(); 
        arr.add(words[0]);
        // pre: 이전 단어의 마지막 글자
        char pre = words[0].charAt(words[0].length()-1);
        
        // words를 순회
        for(int i = 1; i<words.length; i++){
            // 만약 이미 나온 단어거나, 전의 마지막 글자와 현재의 첫번째 글자가 다른 경우
            if(arr.contains(words[i]) || words[i].charAt(0) != pre){
                return new int[] {i%n+1, i/n+1}; // 번호와 순서를 리턴
            }
            // 단어 arr에 추가하고, pre 변경
            arr.add(words[i]);
            pre = words[i].charAt(words[i].length()-1);
        }
    
        return new int[] {0, 0};
    }
}
