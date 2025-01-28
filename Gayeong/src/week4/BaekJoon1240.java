import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1240 {
    static int n;
    static int m;
    static ArrayList<Edge>[] graph;

    static class Edge {
        int v, weight;

        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] =  new ArrayList<>();


        for (int i = 0; i < n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            System.out.println(bfs(u, v));
        }
    }

    static int  bfs(int start, int end) {
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(start, 0));
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            if (cur.v == end) return cur.weight;

            for (Edge edge : graph[cur.v]) {
                if (!visited[edge.v]) {
                    visited[edge.v] = true;
                    queue.offer(new Edge(edge.v, cur.weight + edge.weight));
                }
            }
        }

        return -1;
    }


}
