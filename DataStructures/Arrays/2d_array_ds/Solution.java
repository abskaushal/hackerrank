import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		int maxSum = Integer.MIN_VALUE;
		for (int arr_i = 0; arr_i < 6; arr_i++) {
			for (int arr_j = 0; arr_j < 6; arr_j++) {
				arr[arr_i][arr_j] = in.nextInt();
			}
		}
		int row = 0;
		int sum = 0;
		int col = 0;
		int temp[][] = new int[3][3];
		while (row <= 3) {
			col=0;
			while (col <= 3) {
				int r=0,c=0;
				for(int i=row; i<row+3;i++,r++){
					c=0;
					for(int j=col; j<col+3; j++,c++){
						temp[r][c]=arr[i][j];
					}
				}
				sum = getSum(temp);

				if(sum>maxSum){
					maxSum = sum;
				}
				col++;
			}
			row++;
		}

		System.out.println("" + maxSum);
	}

	private static int getSum(int[][] temp) {
		int sum =0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(i==1){
					if(j==1)
						sum+=temp[i][j];
				}else{
					sum+=temp[i][j];
				}
			}
		}
		return sum;
	}
}