import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon10917 {
    static int start = 1;
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
        System.out.println(bfs());
    }

    static int bfs() {
        visited = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int point = queue.poll();
            if (point == n) return visited[point];

            for (int i : graph[point]) {
                if (visited[i] != 0) continue;
                visited[i] = visited[point] + 1;
                queue.offer(i);
            }
        }
        return -1;
    }
}
