import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] a = new int[500];
		int numCase = input.nextInt();
		int houseNum, left, right, pivot, i, j, temp, sum;
		while(numCase-- > 0){
			houseNum = input.nextInt();
			for(i = 0; i < houseNum; i++)
				a[i] = input.nextInt();
			
			left = 0;
			right = houseNum - 1;
			do{
				pivot = a[left];
				i = left;
				j = right;
				while(i <= j){
					while(i <= right && a[i] <= pivot)
						i++;
					while(j > left && a[j] >= pivot)
						j--;
					if(i < j){
						temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
				a[left] = a[j];
				a[j] = pivot;
				if(j < houseNum / 2)
					left = j + 1;
				else
					right = j - 1;
			}
			while(j != houseNum / 2);
			sum = 0;
			for(i = 0; i < j; i++)
				sum += (pivot - a[i]);
			for(i = j + 1; i < houseNum; i++)
				sum += (a[i] - pivot);
			System.out.println(sum);
		}
		input.close();
	}
}