import java.io.*;
import java.util.*;
import java.math.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		
		while(true){
			int n=input.nextInt();
			if(n==0)
				break;
			
			System.out.println(calcurate(n));
		}
	}
	
	public static int calcurate(int n){
		///List<BigInteger> list=new ArrayList<>();
		//map<Long,Long> a=new map<>();
		int[] a=new int[5000001];
		int sum=1;
		a[1]=1;
		int result=0;
		int i=0;
		while(true){
			for( i=2;i<=n;i++){
				
				a[i]=1+a[i-a[a[i-1]]];
				//array[i]=1+array[i-array[array[i-1]]]; //골롱 공식
				
				sum+= a[i];
				//System.out.println("a[i]:"+a[i]);
				if(sum>=n){				
					return i;
				}
			}
		}
		
		
		
	}
}