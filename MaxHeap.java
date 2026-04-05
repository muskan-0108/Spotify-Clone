import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Insert a value into the max-heap
    public void insert(int value) {
        heap.add(value); // Add to the end
        heapifyUp(heap.size() - 1); // Restore heap property
    }

    // Heapify up to maintain max-heap property
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(index) > heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    // Swap helper method
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Print the heap
    public void printHeap() {
        System.out.println(heap);
    }

    // Main method to test insert
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(84);
        maxHeap.insert(19);

        maxHeap.printHeap(); // Output should be a max-heap: [84, 17, 19, 5, 10, 3]
    }
}
