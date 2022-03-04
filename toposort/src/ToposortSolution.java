import java.util.*;

public class ToposortSolution {
    public static List<List<Integer>> init_graph() {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 6; ++i)
            graph.add(new ArrayList<Integer>());
        
        graph.get(3).add(2);
        graph.get(2).add(5);
        graph.get(2).add(1);
        graph.get(1).add(0);
        graph.get(3).add(4);
        // graph.get(0).add(1);
        return graph;
    }
    
    public static void topohelper(int v, boolean visited[], boolean exited[], List<List<Integer>> graph, List<Integer> result) {
        visited[v] = true;
        for (int adj : graph.get(v)) {
            if (visited[adj] && !exited[adj]) {
                System.out.println("Cycle detected!");
            }
            if (!visited[adj]) {
                topohelper(adj, visited, exited, graph, result);
            }
        }
        exited[v] = true;
        result.add(v);
    }

    public static List<Integer> toposort(List<List<Integer>> graph) {
        List<Integer> result = new ArrayList<>();
        boolean visited[] = new boolean[6];
        boolean exited[] = new boolean[6];
        for (int i = 0; i < 6; i++) {
            if (!visited[i]) {
                topohelper(i, visited, exited, graph, result);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        List<List<Integer>> graph = init_graph();
        System.out.println(toposort(graph));
    }
}
