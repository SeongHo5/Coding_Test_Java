import java.util.PriorityQueue;
class Solution {
    
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> workQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int work : works) {
            workQueue.add(work);
        }

        for (int i = 0; i < n; i++) {
            if (workQueue.isEmpty()) break;
            int maxWork = workQueue.poll();
            if (maxWork > 0) {
                workQueue.add(maxWork - 1);
            }
        }

        long totalFatigue = 0;
        while (!workQueue.isEmpty()) {
            int work = workQueue.poll();
            totalFatigue += (long) work * work;
        }

        return totalFatigue;
    }
}