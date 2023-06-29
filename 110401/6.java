
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		int i,j,t,n,left,right,pivot,temp,sum_dist;
		int arr[] = new int[500];
		t = input.nextInt();
		
		while(t-->0) {
			n = input.nextInt();
			for(i=0; i<n; i++) 
				arr[i]=input.nextInt();
			left =0;
			right = n-1;
			do {
				pivot = arr[left];
				i=left;
				j= right;
				while(i<=j) {
					while(i<=right && arr[i]<=pivot)
						i++;
					while(j>left && arr[j] >=pivot)
						j--;
					if(i<j) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						
					}
				}
				arr[left] = arr[j];
				arr[j] = pivot;
				if(j <n/2)
					left = j+1;
				else
					right =j-1;
			}while(j!=n/2);
			
			sum_dist =0;
			for(i=0; i<j; i++)
				sum_dist += (pivot -arr[i]);
			
			for(i =j+1; i<n; i++)
				sum_dist +=(arr[i]-pivot);
			System.out.println(sum_dist);
		}
	}

}
