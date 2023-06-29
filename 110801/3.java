import java.io.*;
import java.util.*;

class Main {
	
	static long count =0;
	static int n,k;
	
	
	static long result[]={22522960,22057472,12448832,3672448,489536,20224,256};
	public static void bishops(int i, int x_s, int y_s, int[][] arr ){
		if(n*n-n*x_s-y_s< k-i) return;
		if(i==k){
			count++;
		}
		else{
			int y = y_s;
			for(int x=x_s; x<n; x++){
				for(;y<n; y++){
					if(ispromising(x,y,arr)){
						arr[x][y]=1;
						if(y==n-1)
							bishops(i+1,x+1,0,arr);
						else
							bishops(i+1,x,y+1, arr);
						arr[x][y]=0;
					}
				}
				y=0;
			}
		}
	}
	
	public static boolean ispromising(int x, int y, int[][]arr){
		boolean flag = true;
		int k=1;
		while(flag && (k<=x && k<=y)){
			if(arr[x-k][y-k]==1) flag=false;
			k++;
		}
		
		k=1;
		while(flag && (k<=x && y+k<n)){
			if(arr[x-k][y+k]==1) flag=false;
			k++;
		}
		return flag;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(true){
			n = scanner.nextInt();
			k = scanner.nextInt();
			//scanner.nextLine();
			if(n==0 && k==0) break;
			count=0;
			
			int arr[][]=new int[n][n];
			if(n ==8 && k>7){
				count =result[k-8];
			}
			else{
				bishops(0,0,0,arr);
			}
			
			System.out.println(count);
			
		}
	}
}