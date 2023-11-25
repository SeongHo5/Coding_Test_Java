class Solution {
    public int solution(int m, int n, int[][] puddles) {
    int[][] grid = new int[n+1][m+1];
    
    // 물에 잠긴 지역 표시
    for (int[] puddle : puddles) {
        grid[puddle[1]][puddle[0]] = -1;
    }
    
    grid[1][1] = 1; // 시작 위치
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (grid[i][j] == -1) { // 물에 잠긴 지역은 패스
                grid[i][j] = 0;
            } else {
                if (i != 1) grid[i][j] += grid[i-1][j] % 1000000007;
                if (j != 1) grid[i][j] += grid[i][j-1] % 1000000007;
            }
        }
    }
    
    return grid[n][m] % 1000000007;
}
}