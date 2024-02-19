class Solution {
    public boolean solution(String s) {
        int length = s.length();
        if ((length == 4 || length == 6)) {
            for (int i = 0; i < s.length(); i++) {
                if(!Character.isDigit(s.charAt(i))) return false;
            }
            return true;
        }
        return false;
    }
}