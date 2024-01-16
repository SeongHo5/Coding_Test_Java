class Solution {
    public int solution(int n) {
    int countForN = Integer.bitCount(n);
    int nextValue = n;

    while (true) {
        nextValue++;
        if (Integer.bitCount(nextValue) == countForN) {
            return nextValue;
        }
    }
}
}