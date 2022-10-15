import java.util.*;
public class binary_search_recursive 
{
    int BinarySearch(int a[],int low,int high,int key)
    {
        if(low>high)
        return -1;
        int mid =(low+high)/2;
        if(a[mid]==key)
        return mid;
        if(a[mid]<key)
            return BinarySearch(a, mid+1, high, key);
        else
            return BinarySearch(a, low, mid-1, key);
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
        binary_search_recursive ob=new binary_search_recursive();
        System.out.println("Input key to search");
        int key=sc.nextInt();
        int pos=ob.BinarySearch(a,0,n-1,key);
        if(pos==-1)
        System.out.println("Element is not present in the array");
        else
        System.out.println("Element is present in the array at position : "+(pos+1));
    }
}
