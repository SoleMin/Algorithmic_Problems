import java.io.*;
class Main {
	static int[] next;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] t = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();
		// if(p.length > t.length){
		// 	System.out.println(0);
		// 	System.exit(0);
		// }
		
		next = new int[p.length];
		next(p);
		int[] result = new int[1000000];
		int resultSize = 0;
		int equals = 0;
		for(int i=0; i<t.length; i++){
			while(equals>0 && t[i] != p[equals]){
				equals = next[equals-1];
			}
			if(t[i]==p[equals]){
				if(equals==p.length-1){
					result[resultSize++] = i-p.length+2;
					equals = next[equals];
					
				}
				else equals++;
			}
		}
		System.out.println(resultSize);
		for(int i=0; i<resultSize; i++){
			System.out.print(result[i]+" ");
		}
		
		
	}
	public static void next(char[] p){
		int index=0;
		for(int i=1; i<p.length; i++){
			while(index>0 && p[i]!=p[index]){
				index = next[index-1];
			}
			if(p[i]==p[index]){
				index++;
				next[i] = index;
			}
			
			
			
		}
	}
}