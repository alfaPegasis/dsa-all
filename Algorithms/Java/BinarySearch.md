public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,8,9,12,34,67,89};
        int target = 12;
        System.out.println(binarySearch(arr,target));
    }
    static int binarySearch(int[] arr,int target){
        if (arr.length==0) {
            return -1;//Answer is 0 in the case of an empty array
        }
        int start = 0;//startIndex for searching an element
        int end = arr.length-1;//endIndex for searching an element
        while (start<=end){
            int mid = start + (end-start)/2;//Taking the middlemost index of the array
            if (target<arr[mid]) {
                //If the element present at the middlemost element is greater than the target, then search in the first half of the array.
                end = mid-1;
            }
            else if (target>arr[mid]) {
                //If the element present at the middlemost element is smaller than the target, then search in the second half of the array.
                start = mid+1;
            }
            else{
                //We have found the required element hence, returning its index that is currently stored in the variable named as mid.
                return mid;
            }
        }
        return -1;//If the target element is not in the array, then returning -1 as answer.
    }
}
