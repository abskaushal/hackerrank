import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int heights[] = new int[t];
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            heights[a0] = calculateHeight(n);
        }
        
        for(int i=0;i<t; i++){
        	System.out.println(heights[i]);
        }
    }
    
    private static int calculateHeight(int cycles){
    	int height = 1;
    	boolean toggle = true;
    	
    	for(int i=0; i<cycles;i++){
    		if(toggle){
    			height = 2*height;
    		}else{
    			height++;
    		}
    		toggle = !toggle;
    	}
    	return  height;
    }
}

