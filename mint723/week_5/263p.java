// https://school.programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 중복 신고 제거
        Set<String> distinct = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            distinct.add(report[i]);
        }
        
        // 중복이 제거된 신고를 담은 Iterator 선언
        Iterator<String> distinctReport = distinct.iterator();
        // 신고당한 횟수를 관리하는 Map
        Map<String, Integer> reported = new HashMap<>();
        // 유저가 신고한 ID를 담는 Map
        Map<String, Set<String>> reporter = new HashMap<>();
        
        // Iterator안에 값이 있는 동안 반복 수행
        while (distinctReport.hasNext()){
            // 신고 내역 선언
            String report_history = distinctReport.next();
            // 공백을 기준으로 신고자와 피신고자 구분
            String[] arr = report_history.split(" ");
            // 피신고자
            String reported_id = arr[1];
            // 신고자
            String reporter_id = arr[0];
            // 신고당한 횟수를 관리하는 Map에 피신고자 id가 없으면 신고 당한 횟수를 1로 초기화
            if(!reported.containsKey(reported_id)){
                reported.put(reported_id,1);
            }else{
            // 아닐때는 신고 당한 횟수 + 1
                reported.put(reported_id,reported.get(reported_id)+1);
            }
            // 유저가 신고한 ID를 관리하는 Map에 신고자 id가 없을 때
            if(!reporter.containsKey(reporter_id)){
            // 신고자 아이디와 Set을 초기화하여 담기
                reporter.put(reporter_id,new HashSet<>());    
            }
            // Set에 유저가 신고한 id 추가
            reporter.get(reporter_id).add(reported_id);
            
        }
        
        // id_list의 길이를 갖는 int배열 answer 선언 및 초기화
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            // id_list에 있는 사람이 신고한 내역이 존재할 때
            if(reporter.containsKey(id_list[i])){
                // 신고한 내역(Set)을 Iterator로 변환
                Iterator<String> check = reporter.get(id_list[i]).iterator();
                // Iterator안에 값이 있는 동안 반복 수행
                while(check.hasNext()){
                    // 유저가 신고한 아이디
                    String next = check.next();
                    // 신고한 아이디가 k번 이상 신고 당했을 경우
                    if(reported.get(next)>=k){
                        // 전송된 메일 + 1
                        answer[i]+=1;
                    }
                }
            }

        }
        return answer;
    }
}
