package week4;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tomato {
    private int n;
    private int m;
    private boolean[][] visited;
    private final List<Integer> dx = List.of(-1, 1, 0, 0);
    private final List<Integer> dy = List.of(0, 0, -1, 1);
    private int[][] tomatoes;

    public void tomato() {
        n = 6;
        m = 4;
        tomatoes = new int[][] {
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,1}
        };

        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[m][n];

        Point point = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(tomatoes[i][j] == 1) {
                    queue.offer(new Point(j, i));
                    visited[i][j] = true;
                }
            }
        }

        int result = bfs(queue);
        System.out.println(result);
    }

    private int bfs(Queue<Point> queue) {
        int maxDay = -1;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx.get(i);
                int ny = y + dy.get(i);

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[ny][nx] && tomatoes[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    tomatoes[ny][nx] = tomatoes[y][x] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
            maxDay = Math.max(maxDay, tomatoes[y][x]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tomatoes[i][j] == 0) {
                    return -1;
                }
            }
        }

        return maxDay == 1 ? 0 : maxDay - 1;
    }
}
