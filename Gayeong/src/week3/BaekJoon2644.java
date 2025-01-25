import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2644 {
    static int n;
    static int start, end;
    static int m;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        System.out.println(bfs());
    }

    static int bfs(){
        visited = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int point = queue.poll();

            if (point == end) return visited[point];

            for (int i : graph[point]) {
                if (visited[i] == 0) {
                    visited[i] = visited[point] + 1;
                    queue.add(i);
                }
            }
        }
        return -1;
    }
}
