public class heap_sort 
{
        public void sort(int arr[])
        {
            int n = arr.length;
      
            
            for (int i = n / 2 - 1; i >= 0; i--)        // Build Heap
                heapify(arr, n, i);
      
           
            for (int i=n-1; i>=0; i--)
            {
                
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
      
                
                heapify(arr, i, 0);
            }
        }
      
       
        void heapify(int arr[], int n, int i)
        {
            int largest = i; 
            int l = 2*i + 1;  
            int r = 2*i + 2;  
      
         
            if (l < n && arr[l] > arr[largest])
                largest = l;
      
           
            if (r < n && arr[r] > arr[largest])
                largest = r;
      
            
            if (largest != i)
            {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;
 
                heapify(arr, n, largest); // Recursively heapify the affected sub-tree
            }
        }
      
        
        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i]+" ");
            System.out.println();
        }
      
        
        public static void main(String args[])
        {
            int arr[] = {55,44,77,1,2,0,99};
            System.out.println("Un-Sorted array is");
            printArray(arr);
            int n = arr.length;
      
            heap_sort ob = new heap_sort();
            ob.sort(arr);
      
            System.out.println("Sorted array is");
            printArray(arr);
        }
        
}
