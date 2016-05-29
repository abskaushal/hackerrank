import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
	private static void printMedian(int[] arr) {
		double median;
		int lenMaxHeap, lenMinHeap, value;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) {
			value = arr[i];
			lenMaxHeap = maxHeap.size();
			lenMinHeap = minHeap.size();
			if (lenMaxHeap == 0 && lenMinHeap == 0) {
				maxHeap.add(value);
				median = value;
			} else {
				if (lenMaxHeap == lenMinHeap) {
					if (value <= maxHeap.peek()) {
						maxHeap.add(value);
						median = maxHeap.peek();
					} else {
						minHeap.add(value);
						median = minHeap.peek();
					}
				} else {
					if (lenMinHeap > lenMaxHeap) {
						if (value > minHeap.peek()) {
							maxHeap.add(minHeap.poll());
							minHeap.add(value);
						} else {
							maxHeap.add(value);
						}
					} else if (lenMinHeap < lenMaxHeap) {
						if (value < maxHeap.peek()) {
							minHeap.add(maxHeap.poll());
							maxHeap.add(value);
						} else {
							minHeap.add(value);
						}
					}
					median = (maxHeap.peek() + minHeap.peek()) * 0.5;
				}
			}

			System.out.println(median + " ");
		}
	}

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();
		int x[] = new int[N];
		for (int i = 0; i < N; i++) {
			x[i] = in.nextInt();
		}

		printMedian(x);

	}
}
