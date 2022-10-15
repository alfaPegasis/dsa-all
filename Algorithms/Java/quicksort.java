import java.util.*;
public class quicksort 
{

    public int partition(int a[],int s,int f)
    {
        int pivot=a[f];
        int i=s-1;
        for(int j=s;j<f;j++)
        {
            if(a[j]<=pivot)
            {
                i=i+1;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }         
        }
        int temp=a[i+1];
            a[i+1]=a[f];
            a[f]=temp;
            
        return i+1;
    }
        
    
    public void QuickSort(int a[],int s,int f)
    {
        if(s<f)
        {
            int p=partition(a,s,f);
            QuickSort(a,s,p-1);
            QuickSort(a,p+1,f);
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input size of array");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Input "+n+" elements to fill the array");
        for(int i=0;i<n;i++)
        a[i]=sc.nextInt();
        quicksort ob=new quicksort();
        ob.QuickSort(a,0,n-1);
        System.out.println("Sorted Array is:");
        for(int i=0;i<n;i++)
        System.out.print(a[i]+" ");
    }  

}
