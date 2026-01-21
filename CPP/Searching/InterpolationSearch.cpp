#include <iostream>
using namespace std;

int interpolationSearch(int a[], int n, int key) {
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

int main() {
    int a[6] = {10, 20, 30, 40, 50, 60};
    int key = 40;

    int result = interpolationSearch(a, 6, key);

    if(result != -1)
        cout << "Element found at index " << result;
    else
        cout << "Element not found";

    return 0;
}