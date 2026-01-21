class LinearSearch {
    static int linearSearch(int[] a, int n, int key) {
        for(int i = 0; i < n; i++) {
            if(a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int key = 30;

        int result = linearSearch(a, a.length, key);

        if(result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");
    }
}