import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int caseN, day, n, count;
		int[] h;
		caseN = input.nextInt();
		for(int i = 0; i < caseN; i++){
			count = 0;
			day = input.nextInt();
			n = input.nextInt();
			h = new int[n];
			for(int j = 0; j < n; j++)
				h[j] = input.nextInt();
			for(int j = 0; j <= day; j++)
				for(int k = 0; k < n; k++){
					if((j%7 == 0) || (j%7-6 == 0))
						continue;
					else if(j%h[k] == 0){
						count++;
						break;
					}
				}
			System.out.println(count);
		}
		input.close();
	}
}