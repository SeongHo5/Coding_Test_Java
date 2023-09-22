import java.util.Arrays;

public class Solution {
	public boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
	    int n = g.length;
	    long total = 0L;
	    long totalG = 0L;
	    long totalS = 0L;

	    for (int i = 0; i < n; i++) {
	        long cnt = time / (2L * t[i]);
	        if (time % (2L * t[i]) >= t[i]) cnt++;

	        // 해당 시간에 옮길 수 있는 무게
	        long tmp = Math.min(cnt * w[i], g[i] + s[i]);
	        // 각 도시의 총합 최대 무게 누적
	        total += tmp;
	        totalG += Math.min(tmp, g[i]);
	        totalS += Math.min(tmp, s[i]);
	    }

	    return total >= a + b && totalG >= a && totalS >= b;
	}

	public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
	    long hi = 400000000000000L;
	    long lo = 0;

	    // 이진 탐색
	    while (lo + 1 < hi) {
	        long mid = (lo + hi) / 2;

	        if (isPossible(mid, a, b, g, s, w, t)) hi = mid;
	        else lo = mid;
	    }
	    return hi;
	}
}