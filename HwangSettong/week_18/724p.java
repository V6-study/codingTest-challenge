// https://school.programmers.co.kr/learn/courses/30/lessons/81302
class Solution {   
    int check(String[] place){
        for(int x = 0; x<5; x++){
            for(int y = 0; y<5; y++){
                if(place[x].charAt(y) != 'P') continue;
                if(y<4 && place[x].charAt(y+1) == 'P') return 0;
                if(x<4 && place[x+1].charAt(y) == 'P') return 0;
                if(y<3 && place[x].charAt(y+2) == 'P' && place[x].charAt(y+1) == 'O') return 0;
                if(x<3 && place[x+2].charAt(y) == 'P' && place[x+1].charAt(y) == 'O') return 0;
                if(x<4 && y<4 && place[x+1].charAt(y+1) == 'P' && (place[x+1].charAt(y) == 'O'|| place[x].charAt(y+1) == 'O')) return 0;
                if(x<4 && y>0 && place[x+1].charAt(y-1) == 'P' && (place[x+1].charAt(y) == 'O'|| place[x].charAt(y-1) == 'O')) return 0;
            }
        }
        return 1;
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i<5; i++){
            answer[i] = check(places[i]);
        }
        return answer;
    }
}
/*
(x,y) 기준으로 지키지 않은 경우
1. (x,y+1)가 P인 경우
2. (x+1,y)가 P인 경우
3. (x,y+2)가 P이고, (x,y+1)가 0인 경우
4. (x+2,y)가 P인 경우, (x+1,y)가 0인 경우
5. (x+1,y+1)가 P이고, (x+1,y)나 (x,y+1)가 O인 경우
6. (x+1,y-1)가 P이고, (x+1,y)나 (x,y-1)가 O인 경우
*/
