class Solution {
    public int solution(int n) {
        int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			int sum = 0;

			for (int j = i; j <= n; j++) {
				sum += j;

				// 연속된 값을 더하면서, n값이 되면 count++ OR n값보다 넘치면 break
				if (sum == n) {
					answer++;
					break;
				} else if (sum > n) {
					break;
				}
			}
		}
		return answer;
    }
}