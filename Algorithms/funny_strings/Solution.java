import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		String strArr[] = new String[count];

		for(int i=0; i<count; i++){
			strArr[i] = in.next();
		}



		for(int j=0; j<count; j++ ){


			String str = strArr[j];
			if(str==null){
				System.out.println("Not Funny");
				return;
			}
			char strArray[] = str.toCharArray();
			int len = strArray.length;
			char revArray[] = new char[len];
			for(int i=0;i<len;i++){
				revArray[len-i-1] = strArray[i];
			}
			boolean isFunny = true;

			for(int i=0; i<len-1; i++){

				int first = Math.abs((int)strArray[i+1]-(int)strArray[i]);
				int second = Math.abs((int)revArray[i+1]-(int)revArray[i]);
				if(first !=second){
					isFunny = false;
					break;
				}

			}

			if(isFunny){
				System.out.println("Funny");
			}else{
				System.out.println("Not Funny");
			}
		}
	}
}


