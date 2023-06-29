import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int i,j;
		int left, right, p=0;
		int sum;
		String s= input.nextLine();
		int caseNum=Integer.parseInt(s);
		while(caseNum!=0) {
			int n;
			int[] a= new int[500];
			n=input.nextInt();
			for(i=0;i<n;i++) 
				a[i]=input.nextInt();
			left=0;
			right=n-1;
			
			//i=left;
			//j=right;
			do {
				p = a[left];
				i = left;
				j = right;
				while (i<= j) {
					while (i<=right && a[i]<=p)
						i++;
					while (j>left && a[j]>=p)
						j--;
					if (i<j) {
						int temp = a[i];
						a[i]= a[j];
						a[j]= temp;
					}
				}
				a[left]= a[j];
				a[j]= p;
				if (j< n/2)
					left = j + 1;
				else
					right = j - 1;
			}while(j!=n/2);
			
			sum=0;
			for(i=0;i<j;i++)
				sum+=p-a[i];
			for(i=j+1;i<n;i++)
				sum+=a[i]-p;
			System.out.println(sum);
			caseNum--;
		}
	}
}