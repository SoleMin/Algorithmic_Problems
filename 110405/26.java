import java.io.*;
import java.util.*;
class Main {
	public static void bouble (int a[], int b[], int p[], int len){
		
		for(int i=1; i<len; i++){
			for(int j=0; j<len-i; j++){
				if(a[p[j]]*b[p[j+1]]>a[p[j+1]]*b[p[j]]){
					int temp = p[j];
					p[j]=p[j+1];
					p[j+1]=temp;
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
	 	Scanner input=new Scanner(System.in);
		int num = input.nextInt();
		
		for(int i=0; i<num; i++){
			int length= input.nextInt();
			
			int[]a = new int[length];
			int[]b = new int[length];
			int[]p = new int[length];
			
			for(int j=0; j<length; j++){
				a[j] = input.nextInt();
				b[j] = input.nextInt();
				p[j] = j;
			}
			
			bouble(a,b,p,length);
			
			for(int j=0; j<length; j++){
				System.out.print((p[j]+1)+" ");
			}	
			System.out.println("\n");
		}
		
	}
}