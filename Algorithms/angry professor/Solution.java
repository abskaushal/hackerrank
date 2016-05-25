import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int checkStudent=0;
            for(int i=0; i<a.length&&checkStudent<k;i++){
            	if(a[i]<=0){
            		checkStudent++;
            	}
            }
            if(checkStudent==k){
            	System.out.println("NO");
            }else{
            	System.out.println("YES");
            }
        }
        
    }
}
