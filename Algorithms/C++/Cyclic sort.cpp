//cyclic sort is used when we have to sort an array of size n ,containing (0 to n-1) or (1 to n) elements in array.
//the concept involves matching the element with corresponding indexes of the proper order,
//it is inplace sorting algorithm 
//O(n)
//duplicates is not allowed for this variant.

#include<bits/stdc++.h>
using namespace std;
//each element in array have a correct postion in array, so we calculated the correct position in correct variable.
void Cyclic_sort(int arr[],int n){
    int i = 0 ; 
    while(i<n){
        int correct = arr[i]-1; //correct index position for the element in array.
        if(arr[i] != arr[correct]){

            //if the value at correct index doesn't hold the right element then we swap it with ith index.
            int temp = arr[i];
            arr[i]=arr[correct];
            arr[correct] = temp;
        }
        else{
            i++;
        }       
    }
}
int main(){
    int array [] = {1,4,2,6,5,3};
    Cyclic_sort(array,6);
    for(auto i : array){
        cout<<i<<" ";
    }
    return 0;
}
