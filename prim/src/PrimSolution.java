public class PrimSolution {

    private static int N = 5;
    private static int[][] graph;

    private static void printTree(int parent[])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < N; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    // Return the parent array
    public static int[] prim(int root) {
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
        boolean[] fringe = new boolean[N];
        boolean[] tree = new boolean[N];
        int[] weight = new int[N];

        parent[root] = -1;
        tree[root] = true;
        for (int i = 0; i < N; i++) {
            if (graph[root][i] != 0) {
                fringe[i] = true;
                parent[i] = root;
                weight[i] = graph[root][i];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            int f = -1;
            int w = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (fringe[j] && weight[j] < w) {
                    f = j;
                    w = weight[j];
                }
            }

            fringe[f] = false;
            tree[f] = true;
            for (int j = 0; j < N; j++) {
                if (graph[f][j] != 0 && !tree[j]) {
                    if (fringe[j]) {
                        if (graph[f][j] < weight[j]) {
                            weight[j] = graph[f][j];
                            parent[j] = f;
                        }
                    } else {
                        fringe[j] = true;
                        weight[j] = graph[f][j];
                        parent[j] = f;
                    }
                }
            }
        }

        return parent;
    }


    public static void main(String[] args)
    {
        graph = new int[][] { { 0, 3, 0, 5, 1 },
                              { 3, 0, 4, 2, 0 },
                              { 0, 4, 0, 3, 7 },
                              { 5, 2, 3, 0, 4 },
                              { 1, 0, 7, 4, 0 } };
        int[] parent = prim(0);
        printTree(parent);
    }
}
