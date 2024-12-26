// https://school.programmers.co.kr/learn/courses/30/lessons/42842
class Solution {
    public int[] solution(int brown, int yellow) {
        int width = yellow; // yellow 가로길이
        int length = 1; // yellow 세로길이
        while(width >= length){
            // 계산한 테두리 블록 수가 brown수와 같을 때 return
            if((width+length+2)*2 == brown){
                return new int[] {width+2, length+2};
            }
            // 다음 width, length 값
            while(true){
                if(yellow % (--width) == 0){
                    length = yellow/width;
                    break;
                }
            }
        }
        return new int[2];
    }
}
