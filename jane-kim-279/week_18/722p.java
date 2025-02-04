class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kNum = Integer.toString(n, k);
        String[] arr = kNum.split("0");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) {
                continue;
            }
            long number = Long.parseLong(arr[i]);
            if (isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isPrime(long number) {
        if (number < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
