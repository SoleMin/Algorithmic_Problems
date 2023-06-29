import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String buf;
		int a, count = 3, carry = 0;
		int [] [] number = new int [1001][1000];
		int [] digit = new int [1001];
		int digitBuf = 0;
		digit[0] = 0;
		digit[1] = 0;
		digit[2] = 0;
		number[0][0] = 2;
		number[1][0] = 5;
		number[2][0] = 13;
		while ((buf = input.readLine()) != null)
		{
			if (buf.isEmpty())
				break;
			a = Integer.parseInt(buf);
			if (count < a)
			{
				for (; count <= a; count++)
				{
					carry = 0;
					for (int i = 0; i < digit[count-1] +2; i++)
					{
						number[count][i] = number[count-1][i] + number[count-2][i] +carry;
						carry = number[count][i] / 1000;
						number[count][i] %= 1000;
					}
					carry = 0;
					for (int i = 0; i < digit[count-1] + 2; i++)
					{
						number[count][i] += number[count-3][i] + carry;
						carry = number[count][i] /1000;
						number[count][i] %= 1000;
					}
					carry = 0;
					for (int i = 0; i < digit[count -1] +2; i++)
					{
						number[count][i] += number[count-1][i] + carry;
						carry =number[count][i] / 1000;
						number[count][i] %= 1000;
					}
					digitBuf = digit[count-1];
					while(number[count][digitBuf] != 0)
						digitBuf++;
					digit[count] = (digitBuf -1);
				}
			}
			for (int i = digit[a-1]; i >= 0; i--)
				if (i==digit[a-1])
					System.out.print(number[a-1][i]);
				else
					System.out.printf("%03d", number[a-1][i]);
			System.out.println();
		}
	}
}