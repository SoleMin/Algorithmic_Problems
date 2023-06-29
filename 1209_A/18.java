import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class a1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		HashMap<Integer,ArrayList<Integer>> h = new HashMap<>();
		boolean visited[] = new boolean[n];
		for(int i=0;i<n;i++)
		{
			a[i] = s.nextInt();
			
			
		}
		Arrays.sort(a);
		for(int i=0;i<n;i++) {
			if(h.containsKey(a[i])) {
							
							ArrayList<Integer> temp = h.get(a[i]);
							temp.add(i);
							h.put(a[i],temp);
						}
						else {
							ArrayList<Integer> k =new ArrayList<>();
							k.add(i);
							h.put(a[i], k);
						}
		}
		int ctr=0;
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				//System.out.println(a[i]);
				ctr++;
				for(int j=a[i];j<=100;j+=a[i]) {
					if(h.containsKey(j)) {
						ArrayList<Integer> m = h.get(j);
						for(int k=0;k<m.size();k++) {
							visited[m.get(k)]=true;
						}
						h.remove(j);
					}
				}
			}
		}
		System.out.println(ctr);
	}
}
