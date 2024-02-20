import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        // start, end
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int index = commands[i][2] - 1;
            result[i] = Arrays.stream(array, start, end)
                    .sorted()
                    .toArray()[index];
        }
        return result;
    }
}