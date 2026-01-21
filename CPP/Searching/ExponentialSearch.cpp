#include <iostream>
using namespace std;

int exponentialSearch(int a[], int n, int key) {
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

int main() {
    int a[7] = {2, 4, 6, 8, 10, 12, 14};
    int key = 10;

    int result = exponentialSearch(a, 7, key);

    if(result != -1)
        cout << "Element found at index " << result;
    else
        cout << "Element not found";

    return 0;
}