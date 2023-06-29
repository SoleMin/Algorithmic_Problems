

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemB185 {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb=new StringBuffer();
		int n=Integer.parseInt(br.readLine());
		
		if(n<0){
			int temp=-n;
			int temp2=temp/10;
			int x=temp%10;
			int y=temp2%10;
			if(x>y){
				temp=temp/10;
			}
			else{
				temp=temp/10 -y +x;
			}
			n=-temp;
			
			
		}
		System.out.println(n);
		
		}
		
	
}
