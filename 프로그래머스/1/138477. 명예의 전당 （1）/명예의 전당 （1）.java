import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> charts = new PriorityQueue<>();
        int[] worst = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            charts.offer(score[i]);
            if (charts.size() > k) {
                charts.poll();
            }
            worst[i] = charts.peek();
        }
        return worst;
    }
}