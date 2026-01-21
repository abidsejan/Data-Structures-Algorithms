class SelectionSort {
    static void selectionSort(int[] a, int n) {
        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n; j++) {
                if(a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11};
        int n = a.length;

        selectionSort(a, n);

        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}