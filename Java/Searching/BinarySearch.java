class BinarySearch {
    static int binarySearch(int[] a, int n, int key) {
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(a[mid] == key)
                return mid;
            else if(a[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int key = 40;

        int result = binarySearch(a, a.length, key);

        if(result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");
    }
}