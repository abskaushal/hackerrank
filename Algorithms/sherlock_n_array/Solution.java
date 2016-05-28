import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int count = in.nextInt();
			int[] arr = new int[count];
			for (int j = 0; j < count; j++) {
				arr[j] = in.nextInt();
			}

			if (count == 1) {
				System.out.println("YES");

			} else {
				mergeSort(arr);
			}

		}

	}

	public static void mergeSort(int[] nums) {

		long sum = 0;
		for (int i : nums) {
			sum += i;
		}

		sum -= nums[0];
		sum -= nums[1];
		String res = "NO";
		long leftSum = nums[0];
		int i = 0;
		int len = nums.length - 1;
		while (i < len) {
			if (leftSum == sum) {
				res = "YES";
				break;
			} else {
				if (sum == 0) {
					break;
				}
				leftSum += nums[i + 1];
				sum -= nums[i + 2];
			}
			i++;
		}
		System.out.println(res);

	}

}