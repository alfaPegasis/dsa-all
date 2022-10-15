import java.util.*;
public class selection_sort {

    public void ss(int arr[],int n)
    {
        int i,j,c_min,g_min;
        for(i=0;i<n;i++)
        {
            c_min=i;
            for(j=i+1;j<n;j++)
            {  
                if(arr[j]<arr[c_min])
                {
                    c_min=j;
                }
            }
            int t=arr[i];
            arr[i]=arr[c_min];
            arr[c_min]=t;
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
        selection_sort ob=new selection_sort();
        ob.ss(arr, n);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }

}
}
