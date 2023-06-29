import java.util.*;
class Main {
	static int[] next = new int[1000000];
	static LinkedList<Integer> indexs = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String Tt = input.nextLine();
		char[] T = new char[Tt.length()+1];
		T[0] = ' ';
		for(int i=1; i<Tt.length()+1; i++){
			T[i] = Tt.charAt(i-1);
		}
		
		String Pt = input.nextLine();
		char[] P = new char[Pt.length()+1];
		P[0] = ' ';
		for(int i=1; i<Pt.length()+1; i++){
			P[i] = Pt.charAt(i-1);
		}
		
		KMP_StringMatcher(T, P);
		
		System.out.println(indexs.size());
		Iterator<Integer> it = indexs.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
			if(it.hasNext())
				System.out.print(" ");
		}
		
		input.close();
	}
	
	public static void KMP_StringMatcher(char[] T, char[] P){
		int n = T.length-1;
		int m = P.length-1;
		int i = 1;
		
		compute_Next(P);
		int q = 0;
		
		while(i<=n){
			while(q>0 && P[q+1] != T[i]){
				q = next[q];
			}
			if(P[q+1] == T[i])
				q=q+1;
			if(q==m){
				indexs.add(i-m+1);
				q = next[q];
			}
			i++;
		}
	}
	
	public static void compute_Next(char[] P){
		int m = P.length-1;
		
		next[1] = 0;
		int k = 0;
		int q = 2;
		
		while(q<=m){
			while(k>0 && P[k+1] != P[q]){
				k = next[k];
			}
			if(P[k+1]==P[q])
				k=k+1;
			next[q] = k;
			q++;
		}
	}
}