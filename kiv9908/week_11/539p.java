public class Solution {

    private static StringBuilder solution(int[] arr1, int[] arr2) {
        int [] merged = new int[arr1.length + arr2.length];
        int k=0,i=0,j=0;
        StringBuilder sb = new StringBuilder();

        while(i<arr1.length && j<arr2.length){
            merged[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }

        while(i<arr1.length){
            merged[k++] = arr1[i++];
        }
        while(j<arr2.length){
            merged[k++] = arr2[j++];
        }
        sb.append("[");
        for (int num = 0; num < merged.length; num++) {
            sb.append(merged[num]);
            if (num < merged.length - 1) { // 마지막 요소가 아니라면 쉼표 추가
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,3,5}, new int[] {2, 4, 6}));
        System.out.println(solution(new int[] {1,2,3}, new int[] {4, 5, 6}));


    }
}

