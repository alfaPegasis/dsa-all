//Iterative Approach
function bubbleSort(arr) {
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr.length - i - 1; j++) {
            if (arr[j + 1] < arr[j]) {
                // ES6 way of swapping array elements
                [arr[j + 1], arr[j]] = [arr[j], arr[j + 1]];
            }
        }
    }
    return arr;
}


//Optimized Approach
// Slightly optimised solution for a nearly sorted array, by reducing the number of passes needed
function bubbleSort(arr) {
    let noSwaps;
    for (let i = arr.length; i > 0; i--) {
        noSwaps = true;
        for (let j = 0; j < i - 1; j++) {
            if (arr[j + 1] < arr[j]) {
                // Swap
                [arr[j + 1], arr[j]] = [arr[j], arr[j + 1]];
                // Make 'noSwaps' false
                noSwaps = false;
            }
        }
        // End the iterations if there were no swaps made in one full pass
        if (noSwaps) {
            break;
        }
    }
    return arr;
}