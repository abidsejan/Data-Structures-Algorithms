#include <iostream>
using namespace std;

int binarySearch(int a[], int n, int key) {
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

int main() {
    int a[5] = {10, 20, 30, 40, 50};
    int key = 40;

    int result = binarySearch(a, 5, key);

    if(result != -1)
        cout << "Element found at index " << result;
    else
        cout << "Element not found";

    return 0;
}