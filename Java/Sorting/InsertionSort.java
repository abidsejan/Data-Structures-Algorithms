class InsertionSort {
    static void insertionSort(int[] a, int n) {
        for(int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            while(j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {12, 11, 13, 5, 6};
        int n = a.length;

        insertionSort(a, n);

        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}