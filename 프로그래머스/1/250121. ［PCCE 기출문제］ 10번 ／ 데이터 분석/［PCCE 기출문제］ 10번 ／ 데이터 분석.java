import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
        int index = getIndex(ext);
        int sortByIndex = getIndex(sortBy);

        return Arrays.stream(data)
                .filter(d -> d[index] < valExt)
                .sorted(Comparator.comparingInt(d -> d[sortByIndex]))
                .toArray(int[][]::new);
    }
    
        private int getIndex(String fieldName) {
        return switch (fieldName.toLowerCase()) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> throw new IllegalArgumentException();
        };
    }
}