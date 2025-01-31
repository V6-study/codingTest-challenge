import java.util.*;
class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        // 오늘 날짜
        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);
        
        // 약관 종류
        Map<String, Integer> term = new HashMap<>();
        for(String t : terms){
            term.put(t.split(" ")[0],Integer.parseInt(t.split(" ")[1]));
        }
        
        // 오늘 날짜 - 수집 일자 계산 후, 약관 종류별 보관기간 비교
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++){
            String date = privacies[i].split(" ")[0];
            int type = term.get(privacies[i].split(" ")[1])*28;
            int cal = (year-Integer.parseInt(date.split("\\.")[0]))*12*28
                      + (month-Integer.parseInt(date.split("\\.")[1]))*28
                      + (day-Integer.parseInt(date.split("\\.")[2]));
            if (cal >= type) {
                list.add(i+1);
            }
        }
        
        return list;
    }
}
