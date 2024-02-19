class Solution {
    public int solution(int a, int b, int n) {
        int bonusCola = 0;
        while (a <= n) {
            int exchanged = (n / a);
            bonusCola += exchanged * b;
            n = (n % a) + (exchanged * b);
        }
        return bonusCola;
    }
}