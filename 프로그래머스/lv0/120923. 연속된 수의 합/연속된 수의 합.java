class Solution {
    public int[] solution(int num, int total) {
        int a = total / num - (num - 1) / 2;
		int b = total / num + (num - 1) / 2;

		int[] result = new int[num];
		for (int i = 0; i < num; i++) {
			result[i] = a + i;
		}

		return result;
    }
}