import java.util.*;

public class BaekJoon7562 {
    static int t;
    static int n;
    static int x, y;
    static int toX, toY;
    static int[][] map;

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Node> moves = new ArrayList<>(
            Arrays.asList(
                    new Node(1, 2), new Node(1, -2),
                    new Node(-1, 2), new Node(-1, -2),
                    new Node(2, 1), new Node(2, -1),
                    new Node(-2, 1), new Node(-2, -1)
            )
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i < t; i++){
            n = sc.nextInt();
            map = new int[n][n];
            visited = new boolean[n][n];
            x = sc.nextInt();
            y = sc.nextInt();
            toX = sc.nextInt();
            toY = sc.nextInt();

            System.out.println(bfs(toX, toY));
        }

    }

    static int bfs(int endX, int endY) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x, y));
        while (!queue.isEmpty()){
            Node node = queue.poll();

            if (node.x == endX && node.y == endY) break;

            for (Node move : moves) {
                int nx = node.x + move.x;
                int ny = node.y + move.y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != 0) continue;

                map[nx][ny] = map[node.x][node.y] + 1;
                queue.offer(new Node(nx, ny));
            }
        }
        return map[endX][endY];
    }
}
