import java.util.*;

public class Search {
    private static int N = 6;
    // Matrix representation
    private static int[][] mat = {{0, 1, 1, 0, 1, 0},
                                  {1, 0, 0, 1, 0, 0},
                                  {1, 0, 0, 1, 1, 0},
                                  {0, 1, 1, 0, 0, 1},
                                  {1, 0, 1, 0, 0, 0},
                                  {0, 0, 0, 1, 0, 0}};
    // Adjacent list representation
    private static List<List<Integer>> adj;

    private static void init_adj() {
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(4);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(3).add(2);
        adj.get(3).add(5);
        adj.get(4).add(0);
        adj.get(4).add(2);
        adj.get(5).add(3);
    }

    // returns: list of nodes visited in order
    public static List<Integer> dfs(int start) {
        return null;
    }

    // returns: list of nodes visited in order
    public static List<Integer> bfs(int start) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        init_adj();
        // print the result of dfs/bfs
        System.out.println();
    }
}
