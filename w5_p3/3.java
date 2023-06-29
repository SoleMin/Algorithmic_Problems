import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		
		String[] T = input.nextLine().split("");
		String[] P = input.nextLine().split("");
		int n = T.length;
		int m = P.length;
		
		int[] fail = new int[1000000];
		for(int i=1, j=0; i<m; i++) {
			while(j > 0 && !P[i].equals(P[j])) j--;
			if(P[i].equals(P[j])) fail[i] = ++j;
		}
		
		/*
		for(int i=0; i<7; i++) {
			System.out.println(fail[i]);
		}*/
		
		for(int i=0, j=0; i<n; i++) {
			while(j > 0 && !T[i].equals(P[j])) j = fail[j-1];
			if(T[i].equals(P[j])) {
				if(j == m-1) {
					list.add(i-m+2);
					j = fail[j];
				}
				else j++;
			}
		}
		
		System.out.println(list.size());
		for(int i : list)
			System.out.print(i + " ");
	}
}