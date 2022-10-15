
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[]={8,4,5,7,22,13};
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		sort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void sort(int[] arr,int lb,int ub){
		if(lb<ub){
			int loc=partition(arr,lb,ub);
	        System.out.println("loc: "+loc);
			sort(arr,lb,loc-1);
			sort(arr,loc+1,ub);
		}
	}
	public static int partition(int[] arr,int lb,int ub){
		
		int pivot=arr[lb];
		int start=lb;
		int end=ub;
		System.out.println("start: "+arr[start]+" ,Pivot: "+pivot+" ,end: "+arr[end]);
		System.out.println("start: "+start+" ,Pivot: "+pivot+" ,end: "+end);
		while(start<end){
			while( arr[start]<=pivot){
				start++;
			}
			while( arr[end]>pivot){
				end--;
			}
			if(start<end){
				swap(arr,start,end);
			}
		}
		swap(arr,lb,end);
		for(int i=lb;i<=ub;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("start: "+arr[start]+" ,Pivot: "+pivot+" ,end: "+arr[end]);
		System.out.println();
		return end;
		
	}
	public static void swap(int[] arr, int start, int end) {
		int t=arr[start];
		arr[start]=arr[end];
		arr[end]=t;
		
	}

}
