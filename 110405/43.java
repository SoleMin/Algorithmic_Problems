import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T= sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int n= sc.nextInt();
			int []time= new int[n];
			int []work= new int[n];
			int []result= new int[n];
			
			for(int i=0; i<n; i++) {
				time[i]=sc.nextInt();
				work[i]=sc.nextInt();
			}
			
			for(int i=0; i<n; i++) {
				result[i]=i;
			}
			
			int temp=0;
			for(int i=1; i<n; i++) {
				for(int j=0; j<n-i; j++) {
					if(time[result[j]]*work[result[j+1]] > time[result[j+1]]*work[result[j]]) {
						temp= result[j];
						result[j]= result[j+1];
						result[j+1]=temp;
					}
				}
			}
			if(t>0)
				System.out.println("\n");
			
			for(int j=0; j<n; j++) {
				System.out.print(result[j]+1+" ");
			}
		}
	}
}