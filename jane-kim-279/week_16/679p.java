import java.util.*;
import java.io.*;

class Solution {
  private static int[] solution(int amount) {
    int[] denominations = {100, 50, 10, 1};

    ArrayList<Integer> change = new ArrayList<>();
    for (int coint : denominations) {
      while (amount >= coin) {
        change.add(coin);
        amount -= coin;
      }
    }
    return change.stream().mapToInt(Integer::intValue).toArray();
  }
}
