class Solution {
    public String solution(String phone_number) {
	    char[] chars = phone_number.toCharArray();
	    int len = chars.length;
	    
	    for (int i = 0; i < len - 4; i++) {
	        chars[i] = '*';
	    }
	    
	    return new String(chars);
	}
}