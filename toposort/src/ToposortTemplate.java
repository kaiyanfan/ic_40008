import java.util.*;

public class ToposortTemplate {
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
    
    public static List<Integer> toposort(List<List<Integer>> graph) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        List<List<Integer>> graph = init_graph();
        System.out.println(toposort(graph));
    }
}
