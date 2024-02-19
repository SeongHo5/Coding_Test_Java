import java.util.TreeSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> result = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            int numberA = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                result.add(numberA + numbers[j]);
            }
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}