import java.util.Arrays;

public class HeapsortTemplate {
    // zeroth element is a placeholder
    private static int[] arr = {0,1,9,3,6,4,7,2,5,8};

    private static class Heap {
        private int[] heap;
        private int len;

        public Heap(int[] arr) {
            this.heap = arr;
            this.len = arr.length;
        }

        public void buildMinHeap(int root) {}

        public int getMin() {
            return 0;
        }

        public void fixMinHeap(int root) {}

        public void deleteMin() {}
    }

    // you are allowed to modify arr
    private static int[] heapsort(int[] arr) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        int[] result = heapsort(arr);
        System.out.println(Arrays.toString(result));
    }
}
