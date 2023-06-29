import java.io.*;
import java.util.*;
public class A{
	public static BufferedReader k;
	public static BufferedWriter z;
	

	
	public static void main(String [] args)throws IOException{
		k = new BufferedReader(new InputStreamReader(System.in));
		z = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
	        String[] dat = k.readLine().split(" ");

	        long l = Long.parseLong(dat[0]);
	        long r = Long.parseLong(dat[1]);
			
			if(r-l<=1){
				z.write(-1+"\n");
			}
			else if(r-l == 2){
				
				
				if((l&1)!=0){
					z.write(-1+"\n");
				}
				else{
					z.write(l+" "+(l+1)+" "+r+"\n");
				}
				
			}
			else{
				if(l%2==0){
					z.write(l+" "+(l+1)+" "+(l+2)+"\n");
				}
				else{
					z.write((l+1)+" "+(l+2)+" "+(l+3)+"\n");
				}
			}
			
			
			
			
		
		z.flush();

	}

}