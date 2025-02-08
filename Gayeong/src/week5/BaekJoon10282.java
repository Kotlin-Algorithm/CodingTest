import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon10282 {
    static int t;
    static int n, d, c;
    static int[] distance;
    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    static class Node {
        int v, e;

        Node(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            d = sc.nextInt();
            c = sc.nextInt();

            distance = new int[n+1];
            Arrays.fill(distance, INF);
            graph = new ArrayList[n+1];
            for (int j = 0; j < n+1; j++) graph[j] = new ArrayList<>();

            for (int j = 0; j < d; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();

                graph[b].add(new Node(a, s));
            }
            dijkstra();

            int maxValue = 0;
            int count = 0;
            for (int idx = 1; idx < n+1; idx++) {
                if (distance[idx] == INF) continue;
                count++;
                maxValue = Math.max(maxValue, distance[idx]);
            }
            System.out.printf("%d %d\n", count, maxValue);
        }
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.e - o2.e);
        pq.add(new Node(c, 0));
        distance[c] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (distance[cur.v] < cur.e) continue;

            for (Node node : graph[cur.v]) {
                int cost = distance[cur.v] + node.e;

                if (cost < distance[node.v]) {
                    distance[node.v] = cost;
                    pq.add(new Node(node.v, cost));
                }


            }
        }
    }
}
