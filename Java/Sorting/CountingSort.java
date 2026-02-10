public class CountingSort {

    public static void countingSort(int[] arr) {
        int n = arr.length;

        // Find maximum element
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        // Create count array
        int[] count = new int[max + 1];

        // Store frequency
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Reconstruct sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        countingSort(arr);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}