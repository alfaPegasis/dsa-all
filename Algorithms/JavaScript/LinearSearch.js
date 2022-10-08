//If the search element found at last. O(n) -> O(1)
//If the search element not found. O(n) -> O(n/2)
function LinearSearch(array, element) {
  let length = array.length;
  let left = 0;
  let right = length - 1;

  let position = -1;

  while (left <= right) {
    if (array[left] == element) {
      position = left;
      console.log(`${element} is present at index ${position}. attempt ${left + 1}`);
      break;
    }

    if (array[right] == element) {
      position = right;
      console.log(`${element} is present at index ${position}. - attempt ${length - right}`);
      break;
    }
    left++;
    right--;
  }

  if (position == -1) {
    console.log(`${element} not found. attempt ${left}`);
  }
}

betterLinearSearch(numbers, 8); 
// Try with a last element and check the attempts in log
betterLinearSearch(numbers, 12); 
betterLinearSearch(numbers, 28);
