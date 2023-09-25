
public class Solution {
		    public String solution(String X, String Y) {
		        StringBuilder result = new StringBuilder();
		        int[] countX = new int[10];
		        int[] countY = new int[10];
	
		        for (char digit : X.toCharArray()) {
		            countX[digit - '0']++;
		        }
		        for (char digit : Y.toCharArray()) {
		            countY[digit - '0']++;
		        }

		        for (int i = 9; i >= 0; i--) {
		            int minCount = Math.min(countX[i], countY[i]);
		            for (int j = 0; j < minCount; j++) {
		            	if (result.length() == 0 && i == 0) {
							result.append(i);
							break;
						}
		                result.append(i);
		            }
		        }

		        if (result.length() == 0) {
		            return "-1";
		        }
	
		        return result.toString();
		    }

	
	}


