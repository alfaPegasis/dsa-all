#include <bits/stdc++.h>

using namespace std;

int linearSearch(vector<int> arr, int key)
{
    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] == key)
        {
            return i;
        }
    }
    return -1;
}

int main()
{
    vector<int> arr;

    char ch;
    int n;
    cout << "Enter the size of the array: ";
    cin >> n;
    cout << "Enter the elements of the array: ";
    while (n--)
    {
        int x;
        cin >> x;
        arr.emplace_back(x);
    }

    int key;
    cout << "Enter the key to be searched : ";
    cin >> key;

    int index = linearSearch(arr, key);

    if (index == -1)
        cout << "Key not found";
    else
        cout << "Key found at index : " << index;

    return (0);
}