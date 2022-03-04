import java.util.Arrays;

public class MsortTemplate {
    private static void msort(int[] arr, int l, int r) {}

    public static void main(String[] args) {
        int[] arr = {1, 7, 4, 6, 3, 5, 2, 9, 8};
        msort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
