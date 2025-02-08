import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon1916 {
    static int n, m;
    static int start, end;
    static int[] distance;
    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    static class Node {
        int vertex, edge;

        Node (int vertex, int edge) {
            this.vertex = vertex;
            this.edge = edge;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        distance = new int[n+1];
        Arrays.fill(distance, INF);
        graph = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            graph[start].add(new Node(end, cost));
        }
        start = sc.nextInt();
        end = sc.nextInt();

        dijkstra();
        System.out.println(distance[end]);

    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.edge - o2.edge);

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (distance[node.vertex] < node.edge) continue;

            for (Node next : graph[node.vertex]) {
                int cost = node.edge + next.edge;

                if (cost < distance[next.vertex]) {
                    distance[next.vertex] = cost;
                    pq.add(new Node(next.vertex, cost));
                }
            }
        }
    }
}
