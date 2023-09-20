import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = progresses.length - 1; i >= 0; i--) {
            int remainingDays = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            stack.push(remainingDays);
        }

        while (!stack.isEmpty()) {
            int count = 1;
            int top = stack.pop();

            while (!stack.isEmpty() && top >= stack.peek()) {
                stack.pop();
                count++;
            }

            answerList.add(count);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
	}
}