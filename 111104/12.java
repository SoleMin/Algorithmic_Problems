import java.util.*;

class Main {

	public static int MAXN = 5607, INFINITY = 1000000, n,result;
	public static int[] weight,strength;
	public static int[][] dynamic;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int i,j;

		weight = new int[MAXN];
		strength = new int[MAXN];
		dynamic = new int[2][MAXN];

		int z = 0;
		while(input.hasNext()) {

			weight[z] = input.nextInt();
			strength[z] = input.nextInt();
			z++;
		}

		n = z;
		qsort(0,n);

		for (i = 0; i < n+1; i++)
			dynamic[0][i] = INFINITY;
		if (dynamic[0][0] > weight[0] && weight[0] <= strength[0])
			dynamic[0][0] = weight[0];

		dynamic[1][0] = dynamic[0][0];

		for (i = 1; i < n+1; i++) {
			for (j = 1; j < n+1; j++) {
				dynamic[i%2][j] = dynamic[(i-1)%2][j];
				if (dynamic[(i-1)%2][j-1] + weight[i] <= strength[i] &&
						dynamic[(i-1)%2][j-1] + weight[i] < dynamic[i%2][j])
					dynamic[i%2][j] = dynamic[(i-1)%2][j-1] + weight[i];
			}
		}

		for (i = n; i >= 0; i--)
			if (dynamic[(n)%2][i] < INFINITY) {
				result = i + 1;
				break;
			}
		 System.out.println(result-1);
	}

	public static void qsort(int left, int right)
	{
		int k = strength[(left + right) / 2];
		int l = left, r = right;
		int temp;
		while (l < r) {
			for (;strength[l] < k; l++);
			for (;strength[r] > k; r--);
			if (l <= r) {
				temp = strength[l];
				strength[l] = strength[r];
				strength[r] = temp;
				temp = weight[l];
				weight[l] = weight[r];
				weight[r] = temp;
				l++;
				r--;
			}
		}
		if (left < r) qsort(left, r);
		if (l < right) qsort(l, right);
	}
}