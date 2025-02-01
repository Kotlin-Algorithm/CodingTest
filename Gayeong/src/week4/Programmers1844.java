import java.util.*;

class Programmers1844 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int row = maps.length;
        int column = maps[0].length;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= row || ny >= column || maps[nx][ny] == 0 || maps[nx][ny] != 1) continue;

                queue.offer(new Node(nx, ny));
                maps[nx][ny] = maps[cur.x][cur.y] + 1;
            }
        }
        return maps[row - 1][column - 1] == 1 ? -1 : maps[row - 1][column - 1];
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
