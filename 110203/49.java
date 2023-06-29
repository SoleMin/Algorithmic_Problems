import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T= sc.nextInt(); //테스트케이스
		for(int i=0; i<T; i++) {
			int n=sc.nextInt(); //날수
			int arr[]= new int[n+1];
			int p= sc.nextInt(); //정당 수
			int k=0; int h=0; int count=0;
			
			for(int j=0; j<p; j++) {
				h= sc.nextInt(); //동맹휴업지수
				for(k=1; k*h<=n; k++) {
					arr[k*h]++;
				}
			}
			for(int l=6; l<=n; l+=7) {
				arr[l]=0;
			}
			for(int l=7; l<=n; l+=7) {
				arr[l]=0;
			}
			for(int j=1; j<=n; j++) {
				if(arr[j]>0) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}