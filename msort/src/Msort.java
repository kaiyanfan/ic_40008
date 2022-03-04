import java.util.Arrays;

public class Msort {
    private static void merge(int[] arr, int l, int m, int r) {
        // arr[l] ~ arr[m] with arr[m+1] ~ arr[r]
        int i = l;
        int j = m+1;
        int k = 0;
        int[] tmp = new int[r-l+1];
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[k] = arr[i];
                i++;
            } else {
                tmp[k] = arr[j];
                j++;
            }
            k++;
        }
        for (int a = i; a <= m; a++) {
            tmp[k] = arr[a];
            k++;
        }
        for (int a = j; a <= r; a++) {
            tmp[k] = arr[a];
            k++;
        }
        for (int a = 0; a < k; a++) {
            arr[l+a] = tmp[a];
        }
    }

    private static void msort(int[] arr, int l, int r) {
        // arr[l] ~ arr[r]

        // l = 0, r = n-1
        int m = (l + r) / 2;
        if (r - l == 0) {
            return;
        }
        msort(arr, l, m);
        msort(arr, m+1, r);
        merge(arr, l, m, r);
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 4, 6, 3, 5, 2, 9, 8};
        msort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
