import java.util.Arrays;

public class Solution {

	 public int solution(int a, int b, int c, int d) {
	        int answer = 0;
	        int[] dice = { a, b, c, d };
	        Arrays.sort(dice);


	        if (dice[0] == dice[3]) {
	        	// 전부 같을 경우
	            answer = 1111 * dice[3];
	            
	        } else if (dice[0] == dice[2] || dice[1] == dice[3]) {
	        	// 3개 같을 경우
	            answer = (int)Math.pow(dice[1] * 10 + (dice[0] + dice[3] - dice[1]), 2);
	            
	        } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
	        	// 2개, 2개씩 같은 경우
	            answer = (dice[0] + dice[3]) * (dice[3] - dice[0]);
	            
	        } else if (dice[0] == dice[1]) {
	        	// 2개 같을 경우
	            answer = dice[2] * dice[3];
	            
	        } else if (dice[1] == dice[2]) {
	        	
	            answer = dice[0] * dice[3];
	            
	        } else if (dice[2] == dice[3]) {
	        	
	            answer = dice[0] * dice[1];
	            
	        } else {
	        	// 전부 다를 경우
	            answer = dice[0];
	            
	        }

	        return answer;
	    }
}