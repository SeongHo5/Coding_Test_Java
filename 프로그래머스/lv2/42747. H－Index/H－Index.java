import java.util.Arrays;

public class Solution {
	public int solution(int[] citations) {
		// 배열을 오름차순으로 정렬
		Arrays.sort(citations);

		int n = citations.length;
		int hIndex = 0;

		// H-Index 구하기
		for (int i = 0; i < n; i++) {
			int h = Math.min(citations[i], n - i);
			hIndex = Math.max(hIndex, h);
		}

		return hIndex;
	}
}