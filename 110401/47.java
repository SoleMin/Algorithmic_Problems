import java.util.Scanner;
import java.util.Arrays;
class Main {
	public static void main(String[] args)  {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextInt()) {
			int T= sc.nextInt();
			for(int i=0; i<T; i++) {
				int num= sc.nextInt();
				int []arr= new int[num];
				
				for(int j=0; j<num; j++) {
					arr[j]=sc.nextInt();
				}
				Arrays.sort(arr);
				int houseIndex= (num-1)/2;
				int sum=0;
				
				for(int j=0; j<num; j++) {
					int sub= arr[j]-arr[houseIndex];
					if(sub<0)
						sub= -sub;
					sum += sub;
				}
				System.out.println(sum);
			}
		}
	}
}