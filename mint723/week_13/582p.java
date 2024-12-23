class Solution {
    public int[] solution(String s) {
        int removeZero = 0;
        int cycle = 0;
        while(!s.equals("1")){
            String tmp = "";
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='1'){
                    tmp+='1';
                }else {
                    removeZero++;
                }
            }
            int c = tmp.length();
            s = Integer.toString(c,2);
            cycle++;
        }
        int[] answer = {cycle,removeZero};
        return answer;
    }
}
