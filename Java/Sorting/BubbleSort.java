class BubbleSort {
    static void bubbleSort(int[] a, int n) {
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 8};
        int n = a.length;

        bubbleSort(a, n);

        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}