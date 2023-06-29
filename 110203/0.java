import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-- > 0){
			int n = input.nextInt();
			int result = 0;
			boolean[] hartals = new boolean[n+1];
			int partys = input.nextInt();
			for (int i = 0; i < partys; i++){
				int hartalsNum = input.nextInt();
				for (int j = 1; j * hartalsNum <= n; j++){
					if ((j * hartalsNum) % 7 == 6 || (j * hartalsNum) % 7 == 0)
						continue;
					hartals[j * hartalsNum] = true;
				}
			}
			for (int i = 1; i <= n; i++)
				if(hartals[i])
					result++;
			System.out.println(result);
		}
	}
}