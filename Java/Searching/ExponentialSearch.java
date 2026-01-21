class ExponentialSearch {
    static int exponentialSearch(int[] a, int n, int key) {
        if(a[0] == key)
            return 0;

        int i = 1;
        while(i < n && a[i] <= key) {
            i = i * 2;
        }

        int low = i / 2;
        int high = n - 1;
        if(i < n)
            high = i;

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
        int[] a = {2, 4, 6, 8, 10, 12, 14};
        int key = 10;

        int result = exponentialSearch(a, a.length, key);

        if(result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");
    }
}