#include <iostream>
#include <vector>
using namespace std;

void countingSort(vector<int>& arr) {
    int n = arr.size();

    // Find maximum element
    int maxVal = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > maxVal)
            maxVal = arr[i];
    }

    // Create count array
    vector<int> count(maxVal + 1, 0);

    // Store frequency of each element
    for (int i = 0; i < n; i++) {
        count[arr[i]]++;
    }

    // Reconstruct sorted array
    int index = 0;
    for (int i = 0; i <= maxVal; i++) {
        while (count[i] > 0) {
            arr[index] = i;
            index++;
            count[i]--;
        }
    }
}

int main() {
    vector<int> arr = {4, 2, 2, 8, 3, 3, 1};

    countingSort(arr);

    cout << "Sorted array: ";
    for (int x : arr) {
        cout << x << " ";
    }

    return 0;
}