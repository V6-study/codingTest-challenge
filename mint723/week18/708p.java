import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] todayInfo = split(today);
        int todayYear = todayInfo[0];
        int todayMonth = todayInfo[1];
        int todayDay = todayInfo[2];
        
        int n = privacies.length;

        int[] years = new int[n];
        int[] months = new int[n];
        int[] days = new int[n];
        char[] types = new char[n];

        //각 배열에 날짜와 타입 추출하여 할당
        for (int i = 0; i < privacies.length; i++) {
            int[] info = split(privacies[i]);
            int year = info[0];
            int month = info[1];
            int day = info[2];
            char type = privacies[i].charAt(privacies[i].length()-1);
            years[i] = year;
            months[i] = month;
            days[i] = day;
            types[i] = type;
        }


        //맵에 타입과 타입 별 기간 할당
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            map.put(terms[i].charAt(0),Integer.parseInt(terms[i].substring(2)));
        }
        //해시맵을 통해 타입 별 기간을 달에 더함
        for (int i = 0; i < types.length; i++) {
            months[i]+=map.get(types[i]);

            while(months[i]>12){
                years[i]+=1;
                months[i]-=12;
            }
        }
        //현재 날짜와 비교
        //비교 후 현재 날짜가 더 크면 result 에 인덱스 저장
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            if(todayYear>years[i]){
                result.add(i+1);
            }else if(todayYear==years[i]&&todayMonth>months[i]){
                result.add(i+1);
            }else if(todayYear==years[i]&&todayMonth==months[i]&&todayDay>=days[i]){
                result.add(i+1);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i]= result.get(i);
        }
        return answer;
    }
    
    int[] split(String s){
        int year = Integer.parseInt(s.substring(0,4));
        int month = Integer.parseInt(s.substring(5,7));
        int day = Integer.parseInt(s.substring(8,10));
        
        return new int[]{year, month, day};
    }
}
