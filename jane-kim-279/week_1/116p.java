import java.util.*;

public class Main
{
    static int[][] pattern = {
        {1, 2, 3, 4, 5}, 
        {2, 1, 2, 3, 2, 4, 2, 5}, 
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
	public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(solution(answers)));
	}
	
	static int[] solution(int[] answers) {
	    int[] scores = new int[3];
	    
	    for(int i=0; i<answers.length; i++) {
	        for(int j=0; j<pattern.length; j++) {
	            if(answers[i] == pattern[j][i % pattern.length]) {
	                scores[j]++;
	            }
	        }
	    }
	    
	    int maxScore = Arrays.stream(scores).max().getAsInt();
      	    ArrayList<Integer> result = new ArrayList<>();
            for(int i=0; i<3; i++) {
                if(scores[i] == maxScore) {
                    result.add(i+1);
                }
            }
    
            return result.stream().mapToInt(i->i).toArray();
	}
}
