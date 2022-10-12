//Cyclic Sort
public class CyclicSort {
   public static void main(String[] args) {
      int []  nums = {3,5,2,1,4};
      int i = 0;
      while( i< nums.length-1){
//         correct index of the element is value of element - 1.
         int correct = nums[i]-1;
//         if value present at i is not equal to its current index value it means it is at incorrect position.
         if(nums[i] != nums[correct]){
            swap(nums,i,correct);
         }else{
            i++;
         }
      }
      for(int num : nums){
         System.out.println(num);
      }
   }
   public static void swap(int[] nums , int i , int j){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }
}
