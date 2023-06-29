import java.util.Scanner;

class Main {
	public static int abs(int a, int b){
		if(a > b)
			return a-b;
		else
			return b-a;
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextInt()){
			int n = input.nextInt();
			if(n == 1){
				System.out.println("Jolly");
				n = input.nextInt();
			}
			else if(n==0)
				System.out.println("Not jolly");
			else{
				int[] array = new int[n];
				int j = 0;
				int a = input.nextInt(), b = input.nextInt();
				for(int i = 0; i < n-1; i++){
					if(abs(a,b) <= 0 || abs(a,b) >= n || array[abs(a,b)] > 0){
						j = 1;
						for(int k = i; k < n-2; k++)
							a = input.nextInt();
						break;
					}
					else{
						array[abs(a,b)] = 1;
						a = b;
						if(i != n-2)
							b = input.nextInt();
					}
				}
				for(int i = 1; i < n-1; i++)
					if(array[i] == 0)
						j += 1;
				if(j > 0)
					System.out.println("Not jolly");
				else
					System.out.println("Jolly");
			}
		}
	}
}