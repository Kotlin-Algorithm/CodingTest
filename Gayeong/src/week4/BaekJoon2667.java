import java.util.*;

public class BaekJoon2667 {
    static int n;
    static int[][] graph;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    ans.add(bfs(i, j));
                }
            }
        }

        Collections.sort(ans);

        System.out.println(ans.size());
        for (int res : ans) {
            System.out.println(res);
        }
    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        graph[x][y] = 0;
        int count = 1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || graph[nx][ny] == 0) continue;

                queue.offer(new Node(nx, ny));
                graph[nx][ny] = 0;
                count++;
            }
        }
        return count;
    }
}
