// selection sort
// Created by: Craved Pumpkin

#include <iostream>
using namespace std;

void selectionSort(int arr[], int size);
void printArray(int arr[], int size);

int main()
{
    int arr[] = {5, 4, 3, 2, 1};
    int size = sizeof(arr) / sizeof(arr[0]);
    selectionSort(arr, size);
    printArray(arr, size);
    return 0;
}

void selectionSort(int arr[], int size)
{
    int minIndex;
    for (int i = 0; i < size - 1; i++)
    {
        minIndex = i;
        for (int j = i + 1; j < size; j++)
        {
            if (arr[j] < arr[minIndex])
            {
                minIndex = j;
            }
        }
        swap(arr[i], arr[minIndex]);
    }
}

void printArray(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}

// Output

// 1 2 3 4 5

// Time Complexity

// The time complexity of selection sort is O(n2) as there are two nested loops.

// Space Complexity

// The space complexity of selection sort is O(1) as an extra variable temp is used.


