import java.io.*;
import java.util.*;

public class Solution {

   public static void insertionSortPart2(int[] arr)
	{       
		int len = arr.length,j;
		for(int i=1; i<len ; i++){
			int temp = arr[i];
			for( j = i;j>0 && temp<arr[j-1]; j--){

				arr[j] = arr[j-1];
			}
			arr[j] = temp;

			if(i<len)
				printArray(arr);
		}
	}  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
