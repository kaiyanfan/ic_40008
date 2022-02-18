import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class TspSkeleton {
    private static int[][] graph = {{0, 8, 5, 1, 3},
                                    {8, 0, 7, 10, 4},
                                    {5, 7, 0, 6, 9},
                                    {1, 10, 6, 0, 2},
                                    {3, 4, 9, 2, 0}};
    private static int N = 5;

    private static int bhk(int start) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(bhk(0));
    }
}




