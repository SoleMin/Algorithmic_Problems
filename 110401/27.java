import java.io.*;
import java.util.*;
class Main {
	public static int totalDistance(int[] arr, int mid, int n){
		int total = 0;
		for(int j = 0; j < mid; j++)
			total+=(arr[mid]-arr[j]);
		for(int j = mid + 1; j < n; j++)
			total+=(arr[j]-arr[mid]);
		return total;
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[500];
		int mid1,mid2,dis;
		
		int test = input.nextInt();
		while(test-->0){
			for(int i = 0; i < 500; i++)
				arr[i] = 30001;
			int n = input.nextInt();
			for(int i = 0; i < n; i++){
				arr[i]=input.nextInt();
			}
			Arrays.sort(arr);
			if(n%2==1){
				mid1=n/2;
				dis = totalDistance(arr,mid1,n);
				System.out.println(dis);
			}
			else{
				mid1=n/2;
				mid2=n/2-1;
				dis = Math.min(totalDistance(arr,mid1,n),totalDistance(arr,mid2,n));
				System.out.println(dis);
			}
		}
	}
}