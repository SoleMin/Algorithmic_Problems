import java.util.*;
import java.io.*;

public class givenstring {
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		String in = reader.next();
		
		int max = 0;
		
		for(int i = 0; i < in.length(); i++){
			for(int j = i+1; j < in.length(); j++){
				//take this substring
				String consider = in.substring(i, j);
				for(int k = i+1; k < in.length(); k++){
					if(k + consider.length() > in.length())
						break;
					else if(in.substring(k, k+consider.length()).equals(consider))
						max = Math.max(max, consider.length());	
				}
			}
		}
		
		System.out.println(max);
	}	
}