import java.util.*;
public class insertion_sort 
{
    public void bs(int arr[],int n)
    {
        int i,j,temp=0;
        for(i=1;i<n;i++)
        {
            temp=arr[i];
            j=i-1;
            while(j>=0 && arr[j]>temp)
            {   
                arr[j+1]=arr[j];
                j--;
            }
            j++;
            arr[j]=temp;   
        }
    }
    public static void main(String args[])
    {
        Scanner sc =new Scanner (System.in);
        System.out.println("Input size of array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Input n elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        insertion_sort ob=new insertion_sort();
        ob.bs(arr, n);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }  
}
