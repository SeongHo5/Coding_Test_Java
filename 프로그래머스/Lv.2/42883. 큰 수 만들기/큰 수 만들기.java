import java.util.Arrays;


class Solution {
    public String solution(String number, int k) {
        int[] numberAsInt = Arrays.stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int length = number.length() - k;

        StringBuilder sb = new StringBuilder(length);
        int startIndex = 0;
        for (int i = 0; i < length; i++) {
            int max = 0;
            for (int j = startIndex; j <= k + i; j++) {
                if (max < numberAsInt[j]) {
                    max = numberAsInt[j];
                    startIndex = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}