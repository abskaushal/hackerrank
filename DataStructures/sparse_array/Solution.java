import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String str[] = new String[N];
		for (int j = 0; j < N; j++) {
			str[j] = in.next();
		}

		int Q = in.nextInt();
		String qry[] = new String[Q];
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < Q; i++) {
			qry[i] = in.next();
			map.put(qry[i], 0);
		}

		for (int i = 0; i < N; i++) {
			String s = str[i];
			if (map.containsKey(s)) {
				map.replace(s, map.get(s) + 1);
			}
		}

		for (int i = 0; i < Q; i++) {
			System.out.println("" + map.get(qry[i]));
		}

	}

}