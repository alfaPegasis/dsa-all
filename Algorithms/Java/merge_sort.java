import java.util.*;
public class merge_sort 
{
    public void Merge(int a[],int s,int mid,int f)
    {
        int l1=mid-s+1;
        int l2=f-mid;
        int left[]=new int[l1];
        int right[]=new int[l2];
        int i=0;
        int l=0;int j=0;
        for(i=0;i<l1;i++)
        left[i]=a[s+i];//fill left array

        for(i=0;i<l2;i++)
        right[i]=a[mid+1+i];//fill the right array
        
        i=s;
        while(l<l1 && j<l2)
        {
            if(left[l]<right[j])
            {
                a[i]=left[l];
                l++;
            }
            else
            {
                a[i]=right[j];
                j++;
            }
            i++;
        }
        while (l < l1)
        {
            a[i] = left[l];
            i++;
            l++;
        }
        while (j < l2)
        {
            a[i] = right[j];
            j++;
            i++;
        }
    }
    public void MergeSort(int a[],int s,int f)
    {
        if(s<f)
        {
            int mid=(s+f)/2;
            MergeSort(a, s, mid);
            MergeSort(a, mid+1, f);
            Merge(a,s,mid,f);
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
        merge_sort ob=new merge_sort();
        ob.MergeSort(a,0,n-1);
        System.out.println("Sorted Array is:");
        for(int i=0;i<n;i++)
        System.out.print(a[i]+" ");
    }    
}
