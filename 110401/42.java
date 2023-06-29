import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int a[] = new int[500];
		int case_num = scan.nextInt();
		int left, right, pivot;
		int sum_dist;
		int temp;
		int z,x ;
		while(case_num-- > 0){
			int n = scan.nextInt();
			for(int i = 0 ; i < n ; i++){
				a[i] = scan.nextInt();
			}
			left = 0;
			right = n -1;
			do {
				pivot = a[left];
				z = left;
				x = right;
				while( z <= x ){
					while(z <= right && a[z] <= pivot)
						z++;
					while(x > left && a[x] >= pivot)
						x--;
					if(z < x){
						temp = a[z];
						a[z] = a[x];
						a[x] = temp;
					}
				}
				a[left] = a[x];
				a[x] = pivot;
				if(x < n /2)
					left = x + 1;
				else
					right = x - 1;
			} while (x != n/2);
			sum_dist = 0;
			for(int j = 0; j < x; j++)
				sum_dist += (pivot - a[j]);
			for(int k = x +1 ; k < n ; k++)
				sum_dist += (a[k] - pivot);
			System.out.println(sum_dist);
		}
	}
}