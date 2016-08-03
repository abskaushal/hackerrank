import java.util.Scanner;

public class Solution {

	private int arr[];
	private int top = -1;

	public Solution(int size) {
		arr = new int[size];
	}

	public void push(int value) {
		arr[++top] = value;
	}

	public void pop() {
		if (top >= 0) {
			top--;
		}
	}

	public void findLarge() {
		int large = -1;
		if (top >= 0) {
			large = arr[0];
			for (int i = 0; i <= top; i++) {
				if (large < arr[i]) {
					large = arr[i];
				}
			}
		}
		if (large != -1) {
			System.out.println("" + large);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Solution stack = new Solution(N);
		for (int i = 0; i < N; i++) {
			int query = in.nextInt();
			switch (query) {
			case 1:
				int value = in.nextInt();
				stack.push(value);
				break;

			case 2:
				stack.pop();
				break;

			case 3:
				stack.findLarge();
				break;

			default:
				break;
			}
		}

	}

}
