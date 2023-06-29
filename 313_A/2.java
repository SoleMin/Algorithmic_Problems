import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	long n = s.nextLong();
    	if(n >= 0)
    		System.out.println(n);
    	else {
    		String str = ("" + n).substring(1);
    		if(str.length() == 1)
    			System.out.println("-" + str);
    		else {
    			long one = Long.parseLong(str.substring(0, str.length()-1));
    			long two = Long.parseLong(str.substring(0, str.length()-2) + str.substring(str.length()-1));
    			if(one > two)
    				System.out.println((two!=0?"-":"") + two);
    			else
    				System.out.println((one!=0?"-":"") + one);
    		}
    	}
    }
}
