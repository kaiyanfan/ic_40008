import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Tsp {
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
        int[][] cost = new int[1 << 5][N];
        for (int x = 0; x < 4; x++) {
            cost[0][x] = graph[start][x];
        }

        List<Integer> sets = IntStream.rangeClosed(1, (1 << N) - 1).boxed().collect(Collectors.toList());
        sets.sort((x, y) -> Integer.bitCount(x) - Integer.bitCount(y));

        // 1, 2, 4, 8, 16, 3, 5, ....
        for (int set : sets) {
            if (inSet(set, start)) {
                continue;
            }
            // x ∈ Nodes \ (sets ∪ {start})
            for (int x = 0; x < N; x++) {
                if (!inSet(set | (1 << start), x)) {
                    cost[set][x] = Integer.MAX_VALUE;
                    for (int y = 0; y < N; y++) {
                        if (inSet(set, y)) {
                            cost[set][x] = Math.min(cost[set - (1 << y)][y] + graph[y][x], cost[set][x]);
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




