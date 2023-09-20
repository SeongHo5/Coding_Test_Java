import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String numberStr = Integer.toString(n);
        for (int i = 0; i < numberStr.length(); i++) {
            char digitChar = numberStr.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            answer += digit;
        }
        return answer;
    }
}