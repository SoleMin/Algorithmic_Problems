import java.io.*;
import java.util.Scanner;
class Main {
	
	static int[] a,b;
	static int[][] fib = new int[3][101];
	static int[] length=new int[3];
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String s1,s2;
		int i;
		
		while (true) {
			s1=input.next();
			s2=input.next();
			if(s1.equals("0") && s2.equals("0"))
				break;
			int lena=s1.length();
			int lenb=s2.length();
			a=new int[lena];
			b=new int[lenb];
			for(i=0; i<lena; i++)
				a[i]=s1.charAt(lena-i-1)-'0';
			for(i=0; i<lenb; i++)
				b[i]=s2.charAt(lenb-i-1)-'0';
			
			length[0]=length[1]=1;
			fib[0][0]=fib[1][0]=1;
			
			for(i=1; compare(i%3, a, lena)<0; i++)
				plus((i+1)%3, i%3, (i-1)%3);
			
			int result=i;
			for(; compare(i%3, b, lenb)<=0; i++)
				plus((i+1)%3, i%3, (i-1)%3);
			
			result=i-result;
			System.out.println(result);
		}
		input.close();
	}
		
	public static int compare(int fi, int[] numb, int len){
		if(length[fi]<len)
			return -1;
		if(length[fi]>len)
			return 1;
		
		for(int i=len-1; i>=0; i--) {
			if(fib[fi][i] < numb[i]) return -1;
			if(fib[fi][i] > numb[i]) return 1;
		}
		return 0;
	}
	
	public static void plus(int target, int a, int b){
		int len=0, carry=0;
		for(; len<length[a] && len <length[b]; len++){
			fib[target][len] = fib[a][len]+fib[b][len]+carry;
			if(fib[target][len]>=10)
				carry=1;
			else
				carry=0;
			fib[target][len]%=10;
		}
		
		if(len<length[a]) {
			for(; len<length[a]; len++){
				fib[target][len]=fib[a][len]+carry;
				if(fib[target][len] >= 10)
					carry=1;
				else
					carry=0;
				fib[target][len]%=10;
			}
		}
		else{
			for(; len<length[b]; len++){
				fib[target][len]=fib[b][len]+carry;
				if(fib[target][len]>=10)
					carry=1;
				else
					carry=0;
				fib[target][len]%=10;
			}
		}
		
		if(carry==1)
			fib[target][len++]=1;
		
		length[target]=len;
	}
}