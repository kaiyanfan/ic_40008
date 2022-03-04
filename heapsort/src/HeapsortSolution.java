import java.util.Arrays;

public class HeapsortSolution {
    // zeroth element is a placeholder
    private static int[] arr = {0,1,9,3,6,4,7,2,5,8};

    private static class Heap {
        private int[] heap;
        private int len;

        public Heap(int[] arr) {
            this.heap = arr;
            this.len = arr.length;
        }

        public void buildMinHeap(int root) {
            int left = root * 2;
            int right = root * 2 + 1;
            // not a leaf
            if (left < len) {
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
            int smallerSubHeap = left;
            // Not a leaf
            if (left < len) {
                // if right heap root is smaller or equal to left heap root
                if (right < len && heap[left] > heap[right]) {
                    smallerSubHeap = right;
                }
                if (heap[smallerSubHeap] < heap[root]) {
                    // swap
                    int t = heap[smallerSubHeap];
                    heap[smallerSubHeap] = heap[root];
                    heap[root] = t;
                    // recursively fix
                    fixMinHeap(smallerSubHeap);
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
        int[] result = new int[arr.length-1];
        Heap h = new Heap(arr);
        h.buildMinHeap(1);

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
