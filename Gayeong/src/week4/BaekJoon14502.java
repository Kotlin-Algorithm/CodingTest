import java.util.*;

public class BaekJoon14502 {
    static int n, m;
    static int[][] graph;
    static Queue<Node> virus = new LinkedList<>();
    static int[][] copy;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int safeArea = 0;

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();

                if (graph[i][j] == 2) virus.offer(new Node(i, j));
            }
        }

        walls(0);

        System.out.println(safeArea);

    }
    // 1. 벽 3개 세우기
    static void walls(int depth) {
        if (depth == 3) {
            bfs();
            safeArea = Math.max(safeArea, countSafeArea());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    walls(depth + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    // 2. 바이러스 확산
    static void bfs() {
        copy = new int[n][m];
        for (int i = 0; i < n; i++) copy[i] = graph[i].clone();

        Queue<Node> queue = new LinkedList<>();
        for (Node node : virus) queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || copy[nx][ny] != 0) continue;
                queue.offer(new Node(nx, ny));
                copy[nx][ny] = 2;
            }
        }
    }

    // 3. 안전영역 크기 세기
    static int countSafeArea() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) result++;
            }
        }

        return result;
    }
}
