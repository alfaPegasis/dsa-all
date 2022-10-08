//  fib search

function fibSearch(arr, key) {
    var fibMMm2 = 0; // (m-2)'th Fibonacci No.
    var fibMMm1 = 1; // (m-1)'th Fibonacci No.
    var fibM = fibMMm2 + fibMMm1; // m'th Fibonacci

    // fibM is going to store the smallest Fibonacci
    // Number greater than or equal to n
    while (fibM < arr.length) {
        fibMMm2 = fibMMm1;
        fibMMm1 = fibM;
        fibM = fibMMm2 + fibMMm1;
    }

    // Marks the eliminated range from front
    var offset = -1;

    /* while there are elements to be inspected. Note that
       we compare arr[fibMm2] with key. When fibM becomes 1,
       fibMm2 becomes 0 */
    while (fibM > 1) {
        // Check if fibMm2 is a valid location
        var i = Math.min(offset + fibMMm2, arr.length - 1);

        /* If key is greater than the value at index fibMm2,
           cut the subarray array from offset to i */
        if (arr[i] < key) {
            fibM = fibMMm1;
            fibMMm1 = fibMMm2;
            fibMMm2 = fibM - fibMMm1;
            offset = i;
        }

        /* If key is greater than the value at index fibMm2,
           cut the subarray after i+1  */
        else if (arr[i] > key) {
            fibM = fibMMm2;
            fibMMm1 = fibMMm1 - fibMMm2;
            fibMMm2 = fibM - fibMMm1;
        }

        /* element found. return index */
        else return i;
    }

    /* comparing the last element with key */
    if (fibMMm1 && arr[offset + 1] == key) return offset + 1;

    /*element not found. return -1 */
    return -1;
}

// Driver Code
var arr = [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100];
var n = 10;
var key = 85;
console.log("Found at index:", fibSearch(arr, key));
