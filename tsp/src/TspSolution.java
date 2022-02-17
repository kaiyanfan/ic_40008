import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class TspSolution {
    private static int[][] graph = {{0, 8, 5, 1, 3},
                                    {8, 0, 7, 10, 4},
                                    {5, 7, 0, 6, 9},
                                    {1, 10, 6, 0, 2},
                                    {3, 4, 9, 2, 0}};
    private static int N = 5;

    private static boolean inSet(int set, int x) {
        return (set & (1 << x)) != 0;
    }

    private static int bhk(int start) {
        int[][] cost = new int[1 << N][N];
        // create integer representations of all sets and sort them in the order of set size
        List<Integer> sets = IntStream.rangeClosed(1, (1 << N) - 1).boxed().collect(Collectors.toList());
        sets.sort((x, y) -> Integer.bitCount(x) - Integer.bitCount(y));

        for (int x = 0; x < N; x++) {
            if (x != start) {
                cost[0][x] = graph[start][x];
            }
        }

        for (int set : sets) {
            // skip everything include start
            if (inSet(set, start)) {
                continue;
            }
            for (int x = 0; x < N; x++) {
                // x ∈ Nodes \ (sets ∪ {start})
                if (!inSet(set | (1 << start), x)) {
                    cost[set][x] = Integer.MAX_VALUE;
                    for (int y = 0; y < N; y++) {
                        if (inSet(set, y)) {
                            // c = cost[set \ {y}, y]
                            int c = cost[set & ~(1 << y)][y];
                            cost[set][x] = Math.min(c + graph[y][x], cost[set][x]);
                        }
                    }
                }
            }
        }

        int opt = Integer.MAX_VALUE;
        int nodes = (1 << N) - 1;
        for (int x = 0; x < N; x++) {
            if (x != start) {
                // c = cost[Nodes \ {start, x}, x]
                // opt = min(c + W[x,start], opt)
                int c = cost[nodes & ~((1 << start) | (1 << x))][x];
                opt = Math.min(c + graph[x][start], opt);
            }
        }

        return opt;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(bhk(0));
    }
}
