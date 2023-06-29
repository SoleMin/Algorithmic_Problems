import java.io.*;
import java.util.Scanner;
class Main {
	static int maxn=10000, numlen=12, onedigit=10000;
	static int n, hn, h4n;
	static longlong[] hanoi=new longlong[maxn+1];
	static longlong[] hanoi4=new longlong[maxn+1];
	static longlong zero=new longlong(), one=new longlong();
	
	public static class longlong {
		public int[] h=new int[numlen];
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (System.in);
		for(int i=0; i<hanoi.length; i++){
			hanoi[i]=new longlong();
			hanoi4[i]=new longlong();
		}
		
		assign(zero, 0);
		assign(one, 1);
		assign(hanoi[1], 1);
		assign(hanoi4[0], 0);
		assign(hanoi4[1], 1);
		hn=h4n=2;
		
		while(input.hasNext()){
			int n=input.nextInt();
			solve(n);
			print(hanoi4[n]);
			System.out.println();
		}
		
		input.close();
	}
	
	static void assign(longlong a, int b){
		for(int i=0; i<numlen; i++){
			a.h[i]=b%onedigit;
			b/=onedigit;
		}
	}
	
	static void add(longlong c, longlong a, longlong b){
		int carry=0;
		for(int i=0; i< numlen; i++){
			c.h[i]=a.h[i]+b.h[i] + carry;
			carry=c.h[i]/onedigit;
			c.h[i]%=onedigit;
		}
	}
	
	static int compare(longlong a, longlong b){
		for(int i=numlen-1; i>=0; i--){
			if(a.h[i] < b.h[i])
				return -1;
			if(a.h[i] > b.h[i])
				return 1;
		}
		return 0;
	}
	
	static void print(longlong a){
		int sw=0;
		for(int i=numlen-1; i>=0; i--){
			if(!(sw==0 && a.h[i]==0)){
				if(sw==0){
					System.out.print(a.h[i]);
					sw=1;
				}
				else {
					System.out.printf("%04d",a.h[i]);
				}
			}
		}
		if(sw==0)
			System.out.println("0");
	}
	
	static void calchanoi(int n){
		for(; hn<=n; hn++){
			add(hanoi[hn],hanoi[hn-1], hanoi[hn-1]);
			add(hanoi[hn], hanoi[hn], one);
		}
	}
	
	static void solve(int n){
		int k;
		longlong temp=new longlong();
		for(; h4n <=n; h4n++){
			add(hanoi4[h4n], hanoi4[h4n-1], hanoi4[h4n-1]);
			add(hanoi4[h4n], hanoi4[h4n], hanoi[1]);
			for(k=h4n-2; k>0; k--){
				calchanoi(h4n-k);
				add(temp, hanoi4[k], hanoi4[k]);
				add(temp, temp, hanoi[h4n-k]);
				if(compare(hanoi4[h4n], temp)==1)
					add(hanoi4[h4n], temp, zero);
				else
					break;
			}
		}
	}
}