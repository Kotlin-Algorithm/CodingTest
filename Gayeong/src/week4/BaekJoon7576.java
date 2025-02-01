import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
    static int n, m;
    static int[][] graph;
    static Queue<Node> queue = new LinkedList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        graph = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();

                if (graph[i][j] == 1) queue.offer(new Node(i, j));
            }
            sc.nextLine();
        }

        bfs();

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    result = Math.max(result, graph[i][j]);
                }
            }
        }

        System.out.println(result - 1);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void bfs() {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || graph[nx][ny] != 0) continue;

                queue.offer(new Node(nx, ny));
                graph[nx][ny] = graph[cur.x][cur.y] + 1;
            }
        }

    }
}
