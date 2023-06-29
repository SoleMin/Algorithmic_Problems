import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		int i,j,pivot;
		int testcase=input.nextInt();
		input.nextLine();
		for(int t=0;t<testcase;t++){
			int house=input.nextInt();
			int[] address=new int[house];
			for(int n=0;n<house;n++)
				address[n]=input.nextInt(); 
				
			int left=0;
			int right=house-1;
			
			do{
			  pivot=address[left];
				i=left;
				j=right;
				while(i<=j){
					while(i<=right && address[i]<=pivot)
						i++;
					while(j>left && address[j]>=pivot)
						j--;
					if(i<j){ //크기 정렬
						int temp=address[i];
						address[i]=address[j];
						address[j]=temp;
					}
				}
				address[left]=address[j];
				address[j]=pivot;
				if(j<house/2)
					left=j+1;
				else
					right=j-1;				
			}while(j != house/2);
			
			int sum_dist=0;
			for(i=0;i<j;i++)
				sum_dist +=(pivot-address[i]);
			for(i=j+1;i<house;i++)
				sum_dist+=(address[i]-pivot);
			System.out.println(sum_dist);
		}
			
	}
}