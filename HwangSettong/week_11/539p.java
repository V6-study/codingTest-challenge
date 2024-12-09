class Solution{
    int[] solution(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int i=0, i1=0, i2=0; // result, arr1, arr2의 인덱스
        while(arr1.length>i1 && arr2.length>i2){ // arr1이나 arr2 끝까지 탐색할 때 까지 loop
            if(arr1[i1]<arr2[i2]){ // arr1의 값이 더 크면 result에 arr1값을 넣어주기
                result[i++] = arr1[i1++];
            }else{ // 아니면 result에 arr2값을 넣어주기
                result[i++] = arr2[i2++];
            }
        }
        // arr1, arr2 남은 인덱스 값 넣어주기
        while(arr1.length>i1){
            result[i++] = arr1[i1++];
        }
        while(arr2.length>i2){
            result[i++] = arr2[i2++];
        }
        return result;
    }
}
