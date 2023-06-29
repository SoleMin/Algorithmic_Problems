import java.io.*;
import java.util.Scanner;
class Main {
	
	static int n,m,cnt=0;
	static int[] next;
	static String s="";
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String a=input.nextLine();
		char[] t= new char[a.length()+1];
		for(int i=1; i<=a.length(); i++){
			t[i]=a.charAt(i-1);
		}
		
		String b=input.nextLine();
		char[] p=new char[b.length()+1];
		for(int j=1; j<=b.length(); j++){
			p[j]=b.charAt(j-1);
		}
		
		n=a.length();
		m=b.length();
		next=new int[p.length];
		KMP(t,p);
		System.out.println(cnt);
		System.out.println(s);
		
		input.close();
	}
	
	public static void KMP(char[] t, char[] p){
		int i=1;
		compute_Next(p);
		int q=0;
		while(i<=n){
			while(q>0 && p[q+1]!=t[i]) {
				q=next[q];
			}
			if(p[q+1]==t[i])
				q+=1;
			if(q==m){
				s+=(i-m+1)+" ";
				q=next[q];
				cnt++;
			}
			i++;
		}
	}
	
	public static void compute_Next(char[] p) {
		next[1]=0;
		int k=0;
		int q=2;
		while(q<=m){
			while(k>0 && p[k+1]!=p[q]) {
				k=next[k];
			}
			if(p[k+1]==p[q])
				k+=1;
			next[q]=k;
			q++;
		}
	}
}