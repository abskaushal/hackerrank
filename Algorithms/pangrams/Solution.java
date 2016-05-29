import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		if(str == null){
			System.out.println("non pangram");
			return;
		}
		str =str.trim().replaceAll("\\s+", "").toLowerCase();

		char checkArray[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char strArray[] = str.toCharArray();
		boolean isPresent = false;

		for(int i=0; i<checkArray.length; i++){

			isPresent = false;
			for(int j=0;j<strArray.length; j++){
				if(strArray[j] == checkArray[i]){
					isPresent = true;
				}
			}
			if(!isPresent){
				break;
			}
		}

		if(isPresent){
			System.out.println("pangram");
		}else{
			System.out.println("not pangram");
		}
	}

}


