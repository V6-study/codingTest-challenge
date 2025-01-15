import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 테스트 케이스 1
        int[][] items1 = {{10, 19}, {7, 10}, {6, 10}};
        int weight_limit1 = 15;
        System.out.println("테스트 케이스 1:");
        System.out.println("Expected: 27.33");
        System.out.println("Result: " + solution.solution(items1, weight_limit1));
        
        // 테스트 케이스 2
        int[][] items2 = {{10, 60}, {20, 100}, {30, 120}};
        int weight_limit2 = 50;
        System.out.println("\n테스트 케이스 2:");
        System.out.println("Expected: 240");
        System.out.println("Result: " + solution.solution(items2, weight_limit2));
    }

    public static class Item implements Comparable<Item>{
        int weight;
        int value;
        double valuePerWeight;

        public Item(int weight, int value, double valuePerWeight) {
            this.weight = weight;
            this.value = value;
            this.valuePerWeight = valuePerWeight;
        }

        @Override
        public int compareTo(Item other) {
            return Double.compare(other.valuePerWeight, this.valuePerWeight);
        }
    }

    public double solution(int[][] items, int weight_limit) {
        Item[] itemList = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            itemList[i] = new Item(items[i][0], items[i][1], (double) items[i][1] / items[i][0]);
        }

        // valuePerWeight를 기준으로 내림차순 정렬
        Arrays.sort(itemList);

        double totalValue = 0;
        int remainingWeight = weight_limit;

        for (Item item : itemList) {
            if (item.weight <= remainingWeight) {
                totalValue += item.value;
                remainingWeight -= item.weight;
            } else {
                totalValue += item.valuePerWeight * remainingWeight;
                break;
            }
        }

        return totalValue;
    }
}
