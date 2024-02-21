import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> houseCount = new ArrayList<>();
        // 입력 처리
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        // DFS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    houseCount.add(dfs(i, j));
                }
            }
        }
        Collections.sort(houseCount);
        System.out.println(houseCount.size());
        for (Integer index : houseCount) {
            System.out.println(index);
        }
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }
    
}
