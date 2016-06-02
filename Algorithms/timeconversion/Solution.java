import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        if(time.contains("AM")){
            time = time.replace("AM","");
            String arr[] = time.split(":");
            int hour = Integer.valueOf(arr[0]);
            arr[0] = (hour%12==0)?"00":arr[0];
            time = arr[0]+":"+arr[1]+":"+arr[2];
        }else{
            time = time.replace("PM","");
            String arr[] = time.split(":");
            int hour = Integer.valueOf(arr[0])%12+12;
            arr[0] = String.valueOf(hour);
            time = arr[0]+":"+arr[1]+":"+arr[2];
        }
        
        System.out.println(time);
    }
}
