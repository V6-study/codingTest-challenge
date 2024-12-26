class Solution {
    public int[] solution(int brown, int yellow) {        
        int totalSize = brown + yellow;
        int sqrt = (int) Math.sqrt(totalSize);
        
        for(int vertical = 3; vertical <= sqrt; vertical++){
            if(totalSize % vertical == 0){
                int horizontal = (int) (totalSize / vertical);
                if (brown == 2 * horizontal + 2 * (vertical - 2)) {
                    return new int[]{horizontal,vertical};
                }
            }
        }
        
        
        return new int[]{};
    }
}