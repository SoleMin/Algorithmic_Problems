import java.io.*;
import java.util.*;

public class A {
	String line;
	
	void run()throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));		
		line = bf.readLine();
		int i, j, len = line.length(), max=0;
		for(i=0; i<len; i++){
			for(j=i; j<len; j++){
				if(line.indexOf(line.substring(i,j+1), i+1)>0){
					if(j-i+1>max) max = j-i+1;
				}
			}
		}
		System.out.println(max);
	}
	
	public static void main(String[] args)throws IOException {
		new A().run();
	}
}
