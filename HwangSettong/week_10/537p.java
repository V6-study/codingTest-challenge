class Solution{
    String solution(String str){
        int[] arr = new int[26]; // a~z까지 빈도를 저장하는 배열
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++; // 문자별로 빈도 수 증가 시켜 줌
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) { // a~z까지 순회하면서 빈도 수만큼 문자 더해 줌
            for(int j = 0; j < arr[i]; j++) sb.append((char)(i + 'a')); 
        }
        return sb.toString();
    }
}
