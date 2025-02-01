package BFS;
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
        int[] visited = new int[n + 1];
        visited[start] = 0;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();

            if (cur.v == end) return visited[cur.v];

            for (Edge edge : graph[cur.v]) {
                if (visited[edge.v] == 0) {
                    visited[edge.v] = edge.weight + visited[cur.v];
                    queue.offer(edge);
                }
            }
        }

        return -1;
    }


}
