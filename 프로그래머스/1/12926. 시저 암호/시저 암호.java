class Solution {
    public String solution(String s, int n) {
        return s.chars()
                .mapToObj(i -> (char) i)
                .map(ch -> {
                    if (Character.isLowerCase(ch)) {
                        return (char) ((ch - 'a' + n) % 26 + 'a');
                    } else if (Character.isUpperCase(ch)) {
                        return (char) ((ch - 'A' + n) % 26 + 'A');
                    } else {
                        return ch;
                    }
                })
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}