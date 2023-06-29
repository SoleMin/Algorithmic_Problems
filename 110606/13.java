import java.io.*;
class Main {
	static int [][] hanoi = new int [10001][12];
	static int [][] hanoi4 = new int [10001][12];
	static int [] zero = new int [12];
	static int [] one = new int [12];
	static int n, hn, h4n;
	public static void assign (int [] a, int b)
	{
		int i;
		for (i = 0; i < 12; i++)
		{
			a[i] = b%10000;
			b/=10000;
		}
	}
	public static void add(int [] c, int [] a, int [] b)
	{
		int i , carry = 0;
		for (i = 0; i < 12; i++)
		{
			c[i] = a[i] + b[i] + carry;
			carry = c[i] /10000;
			c[i] %= 10000;
		}
	}
	public static int compare (int [] a, int [] b)
	{
		int i;
		for (i = 11; i >= 0; i--)
		{
			if (a[i] < b[i])
				return -1;
			if (a[i] > b[i])
				return 1;
		}
		return 0;
	}
	public static void print(int [] a)
	{
		int sw = 0;
		int i;
		for (i = 11; i >= 0; i--)
		{
			if (!(sw == 0 && a[i] == 0)){
				if (sw == 0){
					System.out.print(a[i]);
					sw = 1;
				}
				else 
					System.out.printf("%04d", a[i]);
			}
		}
		if (sw ==0)
			System.out.print("0");
	}
	public static void calcHanoi(int n)
	{
		for (; hn<=n; hn++)
		{
			add(hanoi[hn], hanoi[hn-1], hanoi[hn-1]);
			add(hanoi[hn], hanoi[hn], one);
		}
	}
	public static void solve (int n)
	{
		int k;
		int [] tmp = new int [12];
		for (; h4n <= n; h4n++){
			add(hanoi4[h4n], hanoi4[h4n-1], hanoi4[h4n-1]);
			add(hanoi4[h4n], hanoi4[h4n], hanoi[1]);
			for (k = h4n-2; k>0; k--)
			{
				calcHanoi(h4n-k);
				add(tmp, hanoi4[k], hanoi4[k]);
				add(tmp, tmp, hanoi[h4n-k]);
				if (compare(hanoi4[h4n], tmp) == 1)
					add(hanoi4[h4n], tmp, zero);
				else break;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		assign(zero, 0);
		assign(one, 1);
		assign(hanoi[1], 1);
		assign(hanoi4[0], 0);
		assign(hanoi4[1], 1);
		hn = h4n =2;
		String buf;
		while ((buf = input.readLine()) != null)
		{
			if (buf.isEmpty())
				break;
			n = Integer.parseInt(buf);
			solve(n);
			print(hanoi4[n]);
			System.out.println();
		}
					
	}
}