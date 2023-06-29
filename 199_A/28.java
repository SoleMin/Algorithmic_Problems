import java.io.*;
import java.util.*;

public class program{
	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n==0){
			System.out.println("0 0 0");
			return;
		}
		else if(n==1){
			System.out.println("0 0 1");
			return;
		}
		else if(n==2){
			System.out.println("0 1 1");
			return;
		}
		else{
			int ppp=0;
			int pp=1;
			int c=2;
			while(true){
				if(ppp+pp+c==n){
					System.out.println(ppp+" "+pp+" "+c);
					return;
				}
				else{
					c=c+pp+ppp;
					int temp=pp;
					pp=pp+ppp;
					ppp=temp;
				}
			}
		}
	}
}