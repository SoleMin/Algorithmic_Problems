import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[500];
		int num_cases, n;
		int left, right, i, j, pivot, temp, sum_dist;
		
		num_cases = sc.nextInt();
		while(num_cases-- > 0){
			n = sc.nextInt();
			for(i = 0; i < n; i++)
				a[i] = sc.nextInt();
			left = 0;
			right = n-1;
			do{
				pivot = a[left];
				i = left;
				j = right;
				while(i <= j){
					while (i <= right && a[i] <= pivot)
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
				if(j < n / 2)
					left = j + 1;
				else
					right = j -1;
			} while(j != n / 2);
			
			sum_dist = 0;
			for(i = 0; i < j; i++)
				sum_dist += (pivot - a[i]);
			for(i = j+1; i < n; i++)
				sum_dist += (a[i] - pivot);
			System.out.println(sum_dist);
		}
	}
}