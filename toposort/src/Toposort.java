import java.util.*;

public class Toposort {
    public static List<List<Integer>> init_graph() {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 6; ++i)
            graph.add(new ArrayList<Integer>());
        
        graph.get(3).add(2);
        graph.get(2).add(5);
        graph.get(2).add(1);
        graph.get(1).add(0);
        graph.get(3).add(4);
        return graph;
    }

    public static void topohelper(int v, List<Integer> entered, List<Integer> exited, List<List<Integer>> graph) {
        entered.add(v);
        for (int adj: graph.get(v)) {
            if (!entered.contains(adj)) {
                topohelper(adj, entered, exited, graph);
            }
            else {
                if (!exited.contains(adj)) {
                    System.out.println("Cycle detected!");
                }
            }
        }
        exited.add(v);
    }
    
    public static List<Integer> toposort(List<List<Integer>> graph) {
        List<Integer> entered = new ArrayList<>();
        List<Integer> exited = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (!exited.contains(i)) {
                topohelper(i, entered, exited, graph);
            }
        }
        Collections.reverse(exited);
        return exited;
    }

    public static void main(String[] args) throws Exception {
        List<List<Integer>> graph = init_graph();
        System.out.println(toposort(graph));
    }
}

// [5, 4, 3, 4, 2, 5, 1, 0]
// [3, 4, 2, 5, 1, 0]