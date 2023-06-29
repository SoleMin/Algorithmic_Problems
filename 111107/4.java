import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        while(t-->0) {
            int k = input.nextInt();
            int n = input.nextInt();
            int[] chopsticks = new int[n+1];

            for (int j = 0; j < n; j++) {
                chopsticks[n-j] = input.nextInt();
						}

            int[][] table = new int[n+1][k+9];
            for(int i = 1; i < table[0].length; i++) {
                for(int j = 0; j < table.length; j++) {
                    table[j][i] = Integer.MAX_VALUE;
								}
						}

            for(int i = 1; i < table[0].length; i++) {
                for(int j = 3*i; j < table.length; j++) {
                    int A = chopsticks[j-1] - chopsticks[j];
                    table[j][i] = Math.min(table[j-1][i], table[j-2][i-1] + A*A);
                }
            }

            System.out.println(table[n][k+8]);
        }
    }
}