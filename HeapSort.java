// Remove this line if you're not using a package
// package assets;

public class HeapSort {
    // Function to heapify a subtree rooted at index i
    static void heapify(int arr[], int size, int i) {
        int largest = i;         // Initialize largest as root
        int left = 2 * i + 1;    // left = 2*i + 1
        int right = 2 * i + 2;   // right = 2*i + 2

        // If left child is larger than root
        if (left < size && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < size && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, size, largest);
        }
    }

    // Function to perform heap sort
    static void heapSort(int arr[]) {
        int n = arr.length;

        // Step 1: Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Step 2-5: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap current root with end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Utility function to print the array
    static void printArray(int arr[]) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int arr[] = {4, 10, 3, 5, 1};

        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
