
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort m=new MergeSort();
		int arr[]={7,6,5,4,3,2,1};
		m.MSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

	}
	public void MSort(int[] a,int l,int r){
		if(l<r){
			int mid=(l+r)/2;
			MSort(a,l,mid);
			MSort(a,mid+1,r);
			merge(a,l,mid,r);
		}
	}
	public void merge(int[] arr,int l,int mid,int r){
		int i=l;
	    int j=mid+1;
	    int k=l;
	    int b[]=new int[arr.length];
	    while(i<=mid && j<=r){
	    	if(arr[i]<=arr[j]){
	    		b[k]=arr[i];
	    		i++;
	    	}else{
	    		b[k]=arr[j];
	    		j++;
	    	}
	    	k++;
	    }
	    
	    while(j<=r){
	    	b[k]=arr[j];
	    	j++;
	    	k++;
	    }
	   
	    while(i<=mid){
	    	b[k]=arr[i];
	    	i++;
	    	k++;
	    }
	    
	    for(int i1=l;i1<=r;i1++){
	    	arr[i1]=b[i1];
	    }
	}
	

}
