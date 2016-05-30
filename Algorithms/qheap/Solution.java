import java.util.Scanner;

class Solution {

	public class MinHeap {
		public int size;
		public long[] minHeap;
		public int position;

		public MinHeap(int size) {
			this.size = size;
			minHeap = new long[size + 1];
			for (int i = 0; i <= size; i++) {
				minHeap[i] = -1000000001;
			}
			position = 0;
		}

		public void push(long x) {
			if (position == 0) {
				minHeap[position + 1] = x;
				position = 2;
			} else {
				minHeap[position++] = x;
				bubbleUp();
			}
		}

		private void bubbleUp() {
			int pos = position - 1;
			while (pos > 0 && minHeap[pos / 2] > minHeap[pos]) {
				long y = minHeap[pos];
				minHeap[pos] = minHeap[pos / 2];
				minHeap[pos / 2] = y;
				pos = pos / 2;
			}
		}

		public long poll() {
			return minHeap[1];
		}

		public int poll(long value) {
			int i;
			for (i = 1; i < position; i++) {
				if (minHeap[i] == value) {
					break;
				}
			}

			minHeap[i] = minHeap[position - 1];
			position--;
			heapify(i);
			return i;
		}

		private void heapify(int k) {
			int smallest = k;
			if (2 * k < position && minHeap[smallest] > minHeap[2 * k]) {
				smallest = 2 * k;
			}
			if (2 * k + 1 < position && minHeap[smallest] > minHeap[2 * k + 1]) {
				smallest = 2 * k + 1;
			}
			if (smallest != k) {
				swap(k, smallest);
				heapify(smallest);
			}

		}

		private void swap(int a, int b) {
			long temp = minHeap[a];
			minHeap[a] = minHeap[b];
			minHeap[b] = temp;
		}

	}

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		int Q = in.nextInt();
		Solution sol = new Solution();
		MinHeap heap = sol.new MinHeap(Q);

		for (int i = 0; i < Q; i++) {
			int operation = in.nextInt();
			if (operation == 1) {
				heap.push(in.nextLong());
			} else if (operation == 2) {
				heap.poll(in.nextLong());
			} else {
				System.out.println(heap.poll() + " ");
			}
		}

	}
}
