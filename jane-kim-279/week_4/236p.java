import java.io.*;
import java.util.*;

public class Main
{        
    public static boolean main(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(target - i)) {
                return true;
            }
            set.add(i);
        }
        return false;
	}
}
