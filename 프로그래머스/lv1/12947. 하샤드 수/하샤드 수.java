class Solution {
public boolean solution(int x) {
		int sum = 0;
		int origin = x;

		//자릿수의 합 계산하기
		while (x > 0) {
			sum += x % 10;
			x /= 10;
		}

		return (origin % sum == 0);
	}}