import java.io.*;
import java.util.*;
class Main {
	
	
	public static int[] compute_Next(String pattern){
		int m=pattern.length();
		int[] next=new int[m];
		
		int k=0;
		
		for(int i=1;i<m;i++){
			while(k>0 && pattern.charAt(i) != pattern.charAt(k)){
				k=next[k-1];
			}
			if(pattern.charAt(i)==pattern.charAt(k)){
				k+=1;
				next[i]=k;}
		
		}
		return next;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		String T=input.nextLine();
		String P=input.nextLine(); //패턴
		int count=0;
		int n=T.length();
		int m=P.length();
		ArrayList<Integer> result=new ArrayList<Integer>();
		
		int[] next=compute_Next(P);
		
		int q=0;  //현재 대응되는 글자 수
		for(int i=0;i<n;i++){
			while(q>0 && T.charAt(i) != P.charAt(q)){
				q=next[q-1];
			}
			//글자가 대응될 경우
			if(T.charAt(i) == P.charAt(q)){
				if(q==m-1){
					count++;
					result.add(i-q+1);
					q=next[q];
				}else{
					q+=1;
				}
	
			}
	
		}
		System.out.println(count);
		for(int index:result){
			System.out.print(index+" ");
		}
		
		
	}
}