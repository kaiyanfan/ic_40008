public class PrimTemplate {

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
        return null;
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
