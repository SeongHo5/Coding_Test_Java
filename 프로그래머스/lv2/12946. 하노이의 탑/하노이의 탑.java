import java.util.ArrayList;

public class Solution {
	public ArrayList<int[]> solution(int n) {
		ArrayList<int[]> answer = new ArrayList<>();
		hanoi(n, 1, 3, 2, answer);
		return answer;
	}

	private void hanoi(int n, int start, int end, int via, ArrayList<int[]> answer) {
		if (n == 1) {
			answer.add(new int[]{start, end});
		} else {
			hanoi(n - 1, start, via, end, answer);
			answer.add(new int[]{start, end});
			hanoi(n - 1, via, end, start, answer);
		}
	}
}