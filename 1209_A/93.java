import java.util.Scanner;

public class first {
	static int max = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] tab = new int[n];
		for(int i=0;i<n;i++) {
			tab[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i!=j)
				if(tab[i]>=tab[j] && tab[i]%tab[j]==0) {
					tab[i] = max;
				}
			}
		}
		int res = 0;
		for(int i=0;i<n;i++) {
			if(tab[i]!=max) res++;
		}
		System.out.println(res);
		//System.out.println(4%-1);
	}

}
