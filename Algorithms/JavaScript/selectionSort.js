// selection sort

function selectionSort(arr) {
    var len = arr.length;
    var min;
    for (var i = 0; i < len; i++) {
        min = i;
        for (var j = i + 1; j < len; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        if (min !== i) {
            var tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
    return arr;
}

// test
var arr = [5, 4, 3, 2, 1];
console.log(selectionSort(arr));
