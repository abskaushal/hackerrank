import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		int[] arr = new int[count];
		for(int i=0;i<count;i++){
			arr[i]=in.nextInt();
		}    
        if(count<=1){
			return;
		}
		quickSort(arr, 0 , arr.length-1);

	}    

	static void printArray(int[] ar ) {
		int end = ar.length;
		for(int i=0; i<end; i++){
			System.out.print(ar[i]+" ");
		}
		System.out.println("");
	}

	private static void quickSort(int[] data, int lo, int hi){
		if(lo < hi){
			int p = partition(data, lo, hi);
			quickSort(data, lo, p-1);
			quickSort(data, p+1, hi);
			
		}
	}

	private static int partition(int[] data, int lo, int hi){
		
		int pivot = data[hi];
		int i=lo;
		
		for(int j=lo; j<hi; j++){
			if(data[j] <= pivot){
				swap(data, i, j);
				i++;
			}
		}
		
		swap(data, i, hi);
		printArray(data);
		return i;
	}

	private static void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}