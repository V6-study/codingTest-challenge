import java.util.*;

public class Main
{
	public static void main(String[] args) {
		int[] org = {4, 2, 3, 1, 5};
		System.out.println(Arrays.toString(solution(org)));
	}
	
	static int[] solution(int[] arr) {
	    Arrays.sort(arr);
	    return arr;
	}
}
