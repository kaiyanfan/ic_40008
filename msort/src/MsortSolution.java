import java.util.Arrays;

public class MsortSolution {
    private static void merge(int[] arr, int l, int m, int r) {
        int l1 = m - l + 1;
        int l2 = r - m;
        int[] larr = new int[l1];
        int[] rarr = new int[l2];
        System.arraycopy(arr, l, larr, 0, l1);
        System.arraycopy(arr, l + l1, rarr, 0, l2);
        
        int i = 0, j = 0, k = l;

        while (i < l1 || j < l2) {
            if (i < l1 && (j >= l2 || larr[i] <= rarr[j])) {
                arr[k] = larr[i];
                i++;
            } else {
                arr[k] = rarr[j];
                j++;
            }
            k++;
        }
    }

    private static void msort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            msort(arr, l, m);
            msort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 4, 6, 3, 5, 2, 9, 8};
        msort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
