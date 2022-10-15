import java.util.*;
public class binary_search_iterative 
{
    public int binary_search(int a[],int key)
    {
        int low=0;
        int high=a.length-1;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(a[mid]==key)
            return mid;
            else if(key>a[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }    

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input size of array");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Input "+n+" elements to fill the array in ascending order");
        for(int i=0;i<n;i++)
        a[i]=sc.nextInt();
        binary_search_iterative ob=new binary_search_iterative();
        System.out.println("Input key to search");
        int key=sc.nextInt();
        int pos=ob.binary_search(a,key);
        if(pos==-1)
        System.out.println("Element is not present in the array");
        else
        System.out.println("Element is present in the array at position : "+(pos+1));
        
    }  
}
