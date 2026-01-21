#include <iostream>
using namespace std;

int linearSearch(int a[], int n, int key) {
    for(int i = 0; i < n; i++) {
        if(a[i] == key) {
            return i;
        }
    }
    return -1;
}

int main() {
    int a[5] = {10, 20, 30, 40, 50};
    int key = 30;

    int result = linearSearch(a, 5, key);

    if(result != -1)
        cout << "Element found at index " << result;
    else
        cout << "Element not found";

    return 0;
}