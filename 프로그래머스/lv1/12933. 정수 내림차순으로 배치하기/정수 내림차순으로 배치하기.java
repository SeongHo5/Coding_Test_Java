import java.util.Arrays;
class Solution {
    public long solution(long n) {
     String strN = String.valueOf(n);
	    char[] chars = strN.toCharArray();
	    Arrays.sort(chars);
	    StringBuilder result = new StringBuilder(new String(chars));
	    return Long.parseLong(result.reverse().toString());
    }
}