import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();
		scanner.nextLine();
		
		for(int t=0;t<test;t++){
			scanner.nextLine();
			int n = scanner.nextInt();
			scanner.nextLine();
			float fineDay[] = new float[n];
			int index[] = new int[n];
			for(int i=0;i<n;i++){
				float day = scanner.nextInt();
				float fine = scanner.nextInt();
				index[i]=i;
				fineDay[i]=day/fine;
			}
			for(int i=1;i<n;i++){
				for(int j=0;j<n-1;j++){
					if( fineDay[index[j]] >fineDay[index[j+1]]){
						int temp = index[j];
						index[j] = index[j+1];
						index[j+1] = temp;
						
					}
				}
			}
			for(int i=0;i<n;i++){
				System.out.printf("%d ",index[i]+1);
			}
			System.out.println();
			System.out.println();
			
		}
		
	}
}