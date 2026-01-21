class InterpolationSearch {
    static int interpolationSearch(int[] a, int n, int key) {
        int low = 0;
        int high = n - 1;

        while(low <= high && key >= a[low] && key <= a[high]) {
            int pos = low + ((key - a[low]) * (high - low)) /
                      (a[high] - a[low]);

            if(a[pos] == key)
                return pos;
            else if(a[pos] < key)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60};
        int key = 40;

        int result = interpolationSearch(a, a.length, key);

        if(result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");
    }
}