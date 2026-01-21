#include <iostream>
using namespace std;

int ternarySearch(int a[], int low, int high, int key) {
    while(low <= high) {
        int mid1 = low + (high - low) / 3;
        int mid2 = high - (high - low) / 3;

        if(a[mid1] == key)
            return mid1;
        if(a[mid2] == key)
            return mid2;

        if(key < a[mid1])
            high = mid1 - 1;
        else if(key > a[mid2])
            low = mid2 + 1;
        else {
            low = mid1 + 1;
            high = mid2 - 1;
        }
    }
    return -1;
}

int main() {
    int a[6] = {10, 20, 30, 40, 50, 60};
    int key = 50;

    int result = ternarySearch(a, 0, 5, key);

    if(result != -1)
        cout << "Element found at index " << result;
    else
        cout << "Element not found";

    return 0;
}