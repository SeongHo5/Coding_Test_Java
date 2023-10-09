class Solution {
    int[][] dp;

    public int[] solution(int target) {
        dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = -1;
        }

        return throwDart(target);
    }

    int[] throwDart(int n) {
        if (dp[n][0] == Integer.MAX_VALUE) {
            if (n >= 50) { // 불 맞추기
                int[] temp = throwDart(n - 50);
                if ((temp[0] + 1 < dp[n][0]) || (temp[0] + 1 == dp[n][0] && temp[1] + 1 > dp[n][1])) {
                    dp[n][0] = 1 + temp[0];
                    dp[n][1] = 1 + temp[1];
                }
            }

            int start = Math.min(n, 20);
            for (int i = start; i >= 1; i--) {
                for (int j = 1; j <= 3; j++) { // 싱글, 더블, 트리플 
                    if (n >= i * j) {
                        int[] temp = throwDart(n - i * j);
                        int cnt = j == 1 ? 1 : 0;
                        if ((temp[0] + 1 < dp[n][0]) || (temp[0] + 1 == dp[n][0] && temp[1] + cnt > dp[n][1])) {
                            dp[n][0] = 1 + temp[0];
                            dp[n][1] = cnt + temp[1];
                        }
                    }
                }
            }
        }

        return dp[n];
    }
}
