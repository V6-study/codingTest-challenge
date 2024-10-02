import java.util.*;

public class Main
{
	public static void main(String[] args) {
		int[] numbers = {2, 1, 3, 4, 1};
		System.out.println(Arrays.toString(solution(numbers)));
	}
	
	static int[] solution(int[] arr) {
	    HashSet<Integer> set = new HashSet<>();
	    for(int i=0; i<arr.length; i++) {
	        for(int j=i+1; j<arr.length; j++) {
	            set.add(arr[i] + arr[j]);
	        }
	    }

	    return set.stream().sorted().mapToInt(i->i).toArray();
	}
}
