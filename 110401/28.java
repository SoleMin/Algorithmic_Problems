import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] numArr;
		int testcase;
		int i, j, n, myNum, dSum;
		
		testcase = input.nextInt();
		for(i=0; i < testcase; i++) {
			n = input.nextInt();
			numArr = new int[n];
			myNum = n / 2;
			dSum = 0;
			
			for(j=0; j < n; j++)
				numArr[j] = input.nextInt();
			
			Arrays.sort(numArr);
			
			for(j=0; j < n; j++)
				dSum += abs(numArr[j], numArr[myNum]);
				
				
			System.out.println(dSum);
		}
		input.close();
	}
	
	public static int abs(int n1, int n2) {
		return (n1 > n2) ? n1 - n2 : n2 - n1;	
	}
}