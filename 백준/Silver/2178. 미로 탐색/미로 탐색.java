import java.util.*;

class Position {
    int x, y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0}; // 상, 하 이동
    static int[] dy = {0, 0, -1, 1}; // 좌, 우 이동
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        visited[x][y] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position current = queue.poll();
                if (current.x == n-1 && current.y == m-1) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new Position(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            count++;
        }
        return -1; // 도달할 수 없는 경우
    }
}
