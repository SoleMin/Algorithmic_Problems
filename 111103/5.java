import java.util.*;

class Main {
	static int[] index = new int[1001];	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		for(int i=1; i<=1000; i++)
			index[i] = i;
		
		String[][] elephants = new String[1001][2];
		int count = 0;
		while(input.hasNextLine())
			elephants[++count] = input.nextLine().split(" ");
		elephants = sort(elephants, count);
		
		/*
		for(int i=1; i<=count; i++) {
			System.out.println(index[i]);
		}
		*/
		
		int[] arr = new int[count+1];
		arr[1] = 1;
		for(int i=2; i<=count; i++) {
			arr[i] = Math.max(1, arr[i]);
			for(int j=1; j<=i; j++)
				if(Integer.parseInt(elephants[i][1]) < Integer.parseInt(elephants[j][1]) &&
						Integer.parseInt(elephants[i][0]) > Integer.parseInt(elephants[j][0])) {
					arr[i] = Math.max(arr[j]+1, arr[i]);
				}
		}
		
		int max = 0;
		for(int i : arr)
			max = Math.max(i, max);
		System.out.println(max);
		
		int[] sequence = new int[max];
		boolean first = true;
		int store = 0, last = max;
		for(int i=count; i>=1 && last>0; i--) {
			if((arr[i] == last+1) && store >= Integer.parseInt(elephants[i][1])) {
				if(index[i] < sequence[last]) {
					store = Integer.parseInt(elephants[i][1]);
					sequence[last] = index[i];
				}
				continue;
			}
			
			if(arr[i] == last && (store < Integer.parseInt(elephants[i][1]) || first)) {
				store = Integer.parseInt(elephants[i][1]);
				sequence[--last] = index[i];
				first = false;
			}
		}
		
		for(int i=0; i<max; i++)
			System.out.println(sequence[i]);
	}
	
	static String[][] sort(String[][] arr, int n) {
		int min = 0, temp2 = 0;
		String[] temp;
		for(int i=1; i<n; i++) {
			min = i;
			for(int j=i+1; j<=n; j++) 
				if(Integer.parseInt(arr[j][0]) < Integer.parseInt(arr[min][0]))
					min = j;
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			temp2 = index[min];
			index[min] = index[i];
			index[i] = temp2;
		}
		
		return arr;
	}
}