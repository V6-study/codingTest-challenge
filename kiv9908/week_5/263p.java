import java.util.*;

class Solution {
    public List<Integer> solution(String[] id_list, String[] report, int k) {
        
        // 중복 신고 제거
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        // 각 유저별 신고당한 횟수를 저장할 Map
        Map<String, Integer> reportedCount = new HashMap<>();
        
        // 각 유저가 신고한 사람들을 저장할 Map
        Map<String, HashSet<String>> reporterMap = new HashMap<>();
        
        // 초기화
        for (String id : id_list) {
            reportedCount.put(id, 0);
            reporterMap.put(id, new HashSet<>());
        }
        
        // 신고 정보 처리
        for (String r : reportSet) {
            String[] split = r.split(" ");
            String reporter = split[0];  // 신고한 사람
            String reported = split[1];  // 신고당한 사람
            
            reportedCount.put(reported, reportedCount.get(reported) + 1);
            reporterMap.get(reporter).add(reported);
        }
        
        // 결과 생성
        List<Integer> answer = new ArrayList<>();
        for (String id : id_list) {
            int count = 0;
            // 해당 유저가 신고한 사람들 중에서
            for (String reported : reporterMap.get(id)) {
                // k번 이상 신고당한 사람의 수를 계산
                if (reportedCount.get(reported) >= k) {
                    count++;
                }
            }
            answer.add(count);
        }
        
        return answer;
    }
}