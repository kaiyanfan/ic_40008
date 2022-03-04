import java.util.Arrays;

public class Heapsort {
    // zeroth element is a placeholder
    private static int[] arr = {0,1,9,3,6,4,7,2,5,8};

    private static class Heap {
        private int[] heap;
        private int len;

        public Heap(int[] arr) {
            this.heap = arr;
            this.len = arr.length-1;
        }

        public void buildMinHeap(int root) {
            int left = root * 2;
            int right = root * 2 + 1;
            if (left <= len) {
                buildMinHeap(left);
                buildMinHeap(right);
                fixMinHeap(root);
            }
        }

        public int getMin() {
            return heap[1];
        }

        public void fixMinHeap(int root) {
            int left = root * 2;
            int right = root * 2 + 1;
            int minSubHeap = left;
            if (left <= len) {
                if (right <= len && heap[right] < heap[left]) {
                    minSubHeap = right;
                }
                // swap
                if (heap[root] > heap[minSubHeap]) {
                    int t = heap[minSubHeap];
                    heap[minSubHeap] = heap[root];
                    heap[root] = t;    
                }
            }
        }

        public void deleteMin() {
            len--;
            heap[1] = heap[len];
            fixMinHeap(1);
        }
    }

    // you are allowed to modify arr
    private static int[] heapsort(int[] arr) {
        Heap h = new Heap(arr);
        int[] result = new int[arr.length-1];
        for (int i = 0; i < arr.length-1; i++) {
            result[i] = h.getMin();
            h.deleteMin();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] result = heapsort(arr);
        System.out.println(Arrays.toString(result));
    }
}
