import java.util.Arrays;

public class RadixSort {

    // Method to perform counting sort based on a specific digit
    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // count array for digits (0-9)

        // Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Change count[i] so that it contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to array[]
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // The main method that sorts 'array' using Radix Sort
    public static void radixSort(int[] array) {
        // Find the maximum number to know the number of digits
        int max = Arrays.stream(array).max().orElse(0);

        // Apply counting sort for each digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    // Main method to test the radix sort
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Unsorted array: " + Arrays.toString(array));
        
        radixSort(array);
        
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
