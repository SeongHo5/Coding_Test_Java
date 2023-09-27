class Solution {
        public int solution(int[][] lines) {
		int[] rail = new int[200];
		int answer = 0;
		
		for (int[] line : lines) {
			// 선분의 길이
			for (int j = (line[0] + 100); j < (line[1] + 100); j++) {
				rail[j]++;
			}
		}

		for (int value : rail) {
			if (value > 1) answer++;
		}
		return answer;
	}
}
