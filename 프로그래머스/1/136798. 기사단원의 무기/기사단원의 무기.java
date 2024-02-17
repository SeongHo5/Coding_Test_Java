class Solution {
    public int solution(int number, int limit, int power) {
        int totalWeight = 0;
        for (int i = 1; i <= number; i++) {
            int divisors = countDivisors(i);

            if (divisors > limit) {
                totalWeight += power;
            } else {
                totalWeight += divisors;
            }
        }

        return totalWeight;
    }
    
    private int countDivisors(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
        if (number % i == 0) {
            count++;
            if (i != number / i) {
                count++;
            }
        }
    }
        return count;
    }
}