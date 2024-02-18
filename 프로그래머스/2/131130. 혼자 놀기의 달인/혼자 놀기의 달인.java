import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSizes = new ArrayList<>();
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int size = 0;
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    current = cards[current] - 1;
                    size++;
                }
                groupSizes.add(size);
            }
        }
        
        if (groupSizes.size() == 1) {
            return 0;
        }
        
        int max1 = 0, max2 = 0;
        for (int size : groupSizes) {
            if (size > max1) {
                max2 = max1;
                max1 = size;
            } else if (size > max2) {
                max2 = size;
            }
        }
        
        return max1 * max2;
    }
}