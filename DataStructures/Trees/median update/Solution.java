import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	public static class Node {
		Node left, right;
		int value;
		int height;
		int freq = 1;

		Node(int val) {
			value = val;
		}
	}

	static int height(Node N) {
		if (N == null) {
			return 0;
		}
		return N.height;
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	static Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		return y;
	}

	static int getBalance(Node N) {
		if (N == null) {
			return 0;
		}
		return height(N.left) - height(N.right);
	}

	static Node insert(Node node, int value) {

		if (node == null) {
			return (new Node(value));
		}

		if (value < node.value) {
			node.left = insert(node.left, value);
		} else if (value > node.value) {
			node.right = insert(node.right, value);
		} else {
			node.freq++;
			return node;
		}

		node.height = max(height(node.left), height(node.right)) + 1;

		int balance = getBalance(node);

		if (balance > 1 && value < node.left.value) {
			return rightRotate(node);
		}

		if (balance < -1 && value > node.right.value) {
			return leftRotate(node);
		}

		if (balance > 1 && value > node.left.value) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && value < node.right.value) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	static Node minValueNode(Node node) {
		Node current = node;

		while (current.left != null) {
			current = current.left;
		}

		return current;
	}

	static Node deleteNode(Node root, int value) {

		if (root == null) {
			return root;
		}

		if (value < root.value) {
			root.left = deleteNode(root.left, value);
		}

		else if (value > root.value) {
			root.right = deleteNode(root.right, value);
		}

		else {

			if (root.left == null && root.right == null) {
				if (--root.freq == 0)
					root = null;
			} else if (root.left == null) {
				if (--root.freq == 0) {
					root.value = root.right.value;
					root.freq = root.right.freq;
					root.right = null;
				}
			} else if (root.right == null) {
				if (--root.freq == 0) {
					root.value = root.left.value;
					root.freq = root.left.freq;
					root.left = null;
				}
			} else {

				if (--root.freq == 0) {
					Node temp = minValueNode(root.right);

					root.value = temp.value;
					root.freq = temp.freq;

					root.right = deleteNode(root.right, temp.value);
				}
			}
		}

		if (root == null) {
			return root;
		}

		root.height = max(height(root.left), height(root.right)) + 1;

		int balance = getBalance(root);

		if (balance > 1 && getBalance(root.left) >= 0) {
			return rightRotate(root);
		}

		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		if (balance < -1 && getBalance(root.right) <= 0) {
			return leftRotate(root);
		}

		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	public static void printMedian(Node root, ArrayList<Integer> list) {

		if (root == null) {
			return;
		}
		printMedian(root.left, list);
		for (int i = 0; i < root.freq; i++)
			list.add(root.value);
		printMedian(root.right, list);

		
	}

	/* Head ends here */
	static void median(String a[], int x[]) {

		Node root = null;
		int len = a.length;
		ArrayList list = new ArrayList<Integer>(len);
		for (int i = 0; i < len; i++) {
			if (a[i].equals("a")) {
				root = insert(root, x[i]);
			} else {
				root = deleteNode(root, x[i]);
			}
			printMedian(root, list);
			
			int size = list.size();
			if (size == 0) {
				System.out.println("Wrong!");
			} else {
				if (size % 2 == 0) {
					int d = (int) list.get(size / 2);
					int b = (int) list.get((size / 2) - 1);
					double median = (double) (d + b) / 2;
					System.out.println("" + median);
				} else {
					int c = (int) list.get(size / 2);
					System.out.println("" + c);
				}
			}
			list.clear();
		}

	}

	/* Tail starts here */

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();

		String s[] = new String[N];
		int x[] = new int[N];

		for (int i = 0; i < N; i++) {
			s[i] = in.next();
			x[i] = in.nextInt();
		}

		median(s, x);

		
	}
}
