import java.util.*;

public class DijkstraSolution {
    static class Node {
        public int vertex, weight;
        Node(int v, int w) {
            vertex = v;
            weight = w;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int N = 6;

    public static int dijkstra(int src, int dst) {
        int[] distance = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++)
            distance[i] = 10000;
        distance[src] = 0;
 
        PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
        pq.add(new Node(src, 0));
 
        while (pq.size() > 0) {
            Node current = pq.poll();
            visited[current.vertex] = true;

            for (Node n : graph.get(current.vertex)) {
                if (!visited[n.vertex] && distance[current.vertex] + n.weight < distance[n.vertex]) {
                    distance[n.vertex] = n.weight + distance[current.vertex];
                    pq.add(new Node(n.vertex, distance[n.vertex]));
                }
            }
        }
        return distance[dst];
    }

    public static void main(String[] args) throws Exception {
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(4).add(new Node(0, 3));
        graph.get(4).add(new Node(3, 5));
        graph.get(4).add(new Node(1, 2));
        graph.get(1).add(new Node(4, 2));
        graph.get(1).add(new Node(5, 8));
        graph.get(1).add(new Node(2, 6));
        graph.get(0).add(new Node(4, 3));
        graph.get(0).add(new Node(3, 1));
        graph.get(3).add(new Node(0, 1));
        graph.get(3).add(new Node(4, 5));
        graph.get(3).add(new Node(5, 3));
        graph.get(2).add(new Node(1, 6));
        graph.get(2).add(new Node(5, 4));
        graph.get(5).add(new Node(3, 3));
        graph.get(5).add(new Node(1, 8));
        graph.get(5).add(new Node(2, 4));

        System.out.println(dijkstra(4, 5));
    }
}
