import java.io.*;
import java.util.*;
class Main {
	static final int MAXDIGIT = 100;
	static char[] a = new char[MAXDIGIT +1];
	static char[] b = new char[MAXDIGIT +1];
	static char[][] fib = new char[3][MAXDIGIT + 1];
	static int lengthA, lengthB, result;
	static int [] length = new int [3];
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static int input() throws IOException{
		int i;
		char[] tmpa;
		char[] tmpb;
		String tmp = input.readLine();
		StringTokenizer token = new StringTokenizer(tmp, " ");
		tmpa = token.nextToken().toCharArray();
		tmpb = token.nextToken().toCharArray();
		
		if (tmpa[0] == '0' && tmpb[0] == '0')
			return 0;
		lengthA = tmpa.length;
		lengthB = tmpb.length;
		for (i = 0; i < lengthA; i++)
			a[i] = (char)(tmpa[lengthA - i - 1] - '0');
		for (i = 0; i < lengthB; i++)
			b[i] = (char)(tmpb[lengthB - i - 1] - '0');
		return 1;
	
	}
	public static int compare (int fi, char[] numb, int len){
		int i;
		if (length[fi] < len) return -1;
		if (length[fi] > len) return 1;
		for (i = len -1; i >= 0; i--)
		{
			if (fib[fi][i] < numb[i]) return -1;
			if (fib[fi][i] > numb[i]) return 1;
		}
		return 0;
	}
	
	public static void plus (int target, int a, int b)
	{
		int len = 0, carry = 0;
		for (; len < length[a] && len < length[b]; len++)
		{
			fib[target][len] = (char)(fib[a][len] + fib[b][len] + carry);
			if (fib[target][len] >= 10)
				carry = 1;
			else
				carry = 0;
			fib[target][len] %= 10;
		}
		if (len < length[a])
		{
			for(; len < length[a]; len++)
			{
				fib[target][len] = (char)(fib[a][len] + carry);
				if (fib[target][len] >= 10)
					carry = 1;
				else
					carry = 0;
				fib[target][len] %= 10;
			}
		}else
		{
			for (; len < length[b]; len++)
			{
				fib[target][len] = (char) (fib[b][len] + carry);
				if (fib[target][len] >= 10)
					carry = 1;
				else
					carry = 0;
				fib[target][len] %= 10;
			}
		}
		if (carry == 1)
			fib[target][len++] = 1;
		length[target] = len;
	}
	public static void main(String[] args) throws Exception {
		int i;
		while (input() == 1){
			length[0] = length[1] = 1;
			fib[0][0] = fib[1][0] = 1;
			for (i = 1; compare(i%3, a, lengthA) < 0; i++)
				plus((i+1) % 3, i%3, (i-1) %3);
			result = i;
			for (; compare(i%3, b, lengthB) <= 0; i++)
				plus((i+1)%3, i%3, (i-1) %3);
			
			result = i - result;
			System.out.printf("%d\n", result);
		}
	}
}