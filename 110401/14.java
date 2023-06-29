import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t=input.nextInt();
		for(int i=0; i<t; i++){
			int r=input.nextInt();
			int[] a=new int[r];
			for(int j=0; j<r; j++){
				a[j]=input.nextInt();
			}
			int left=0;
			int right=r-1;
			int pivot,x, y;
			
			do {
				pivot=a[left];
				x=left;
				y=right;
				while(x<=y){
					while(x<=right && a[x]<=pivot)
						x++;
					while(y > left && a[y]>=pivot)
						y--;
					if(x<y) {
						int temp=a[x];
						a[x]=a[y];
						a[y]=temp;
					}
				}
				
				a[left]=a[y];
				a[y]=pivot;
				if(y<r/2)
					left=y+1;
				else
					right=y-1;
			} while(y != r/2);
			
			int result=0;
			for(int k=0; k<r; k++){
				result+=(Math.abs(pivot-a[k]));
			}
			System.out.println(result);
		}
		
		input.close();
	}
}