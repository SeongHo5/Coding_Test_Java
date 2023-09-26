import java.util.*;

public class Solution {

	static class Mineral {
		private int diamond;
		private int iron;
		private int stone;

		public Mineral(int diamond, int iron, int stone) {
			this.diamond = diamond;
			this.iron = iron;
			this.stone = stone;
		}
	}

	static int[][] scoreBoard;
	static List<Mineral> list;

	public int solution(int[] picks, String[] minerals) {
		int answer = 0;

		scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}}; // 각각 다이아 & 철 & 돌 곡괭이로 다이아, 철, 돌을 캘 때 피로도

		int totalPicks = Arrays.stream(picks).sum();

		list = new ArrayList<>();
		// minerals를 5개씩 묶는다.
		for(int i = 0; i < minerals.length; i += 5) {
			if(totalPicks == 0) break;

			int dia = 0, iron = 0, stone = 0;
			for(int j = i; j < i + 5; j++) {
				
				// 더 이상 캘 광물이 없으면 break
				if(j == minerals.length) break;

				String mineral = minerals[j];
				
				// 5개 묶음에 광물이 각각 몇 개씩 있는지 count
				int val = mineral.equals("iron") ? 1 : mineral.equals("stone") ? 2 : 0;

				dia += scoreBoard[0][val];
				iron += scoreBoard[1][val];
				stone += scoreBoard[2][val];
			}

			list.add(new Mineral(dia, iron, stone));
			totalPicks--;
		}

		Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));
		
		for(Mineral m : list) {
			int dia = m.diamond;
			int iron = m.iron;
			int stone = m.stone;

			if(picks[0] > 0) {
				answer += dia;
				picks[0]--;
				continue;
			}
			if(picks[1] > 0) {
				answer += iron;
				picks[1]--;
				continue;
			}
			if(picks[2] > 0) {
				answer += stone;
				picks[2]--;
				continue;
			}
		}

		return answer;
	}
}