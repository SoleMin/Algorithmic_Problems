import java.io.IOException;
import java.io.InputStream;

public class Cycles
{
	public static FastInputStream fis;
	
	public static void main(String[] args) throws IOException
	{
		fis = new FastInputStream(System.in);
		
		System.out.println(solve(fis.nextInt(), fis.nextInt()));
		
		fis.close();
	}
	
	public static long solve(int n, int m) throws IOException
	{
		boolean[][] graph = new boolean[n][];
		long[][] state = new long[1 << n][n];
		
		for (int i = 0; i < n; i++)
			graph[i] = new boolean[n - i];
		
		for (int i = 0; i < m; i++)
		{
			int a = fis.nextInt() - 1;
			int b = fis.nextInt() - 1;
			setConnected(graph, a, b);
			state[(1 << a) | (1 << b)][a > b ? a : b] = 1;
		}
		
		long res = 0;
		
		for (int i = 2; i < n; i++)
		{
			int baseCombination = (2 << i) - 1;
			
			while (baseCombination < (1 << n))
			{
				int min = getFirstOne(baseCombination);
				int bits = baseCombination;
				while (bits != 0)
				{
					int firstBit = bits & (-bits);
					int firstBitPos = getFirstOne(firstBit);
					
					bits &= bits - 1;
					
					if (firstBitPos == min)
						continue;
					
					int leftOverBits = baseCombination - firstBit;
					int nextBits = leftOverBits;
					
					while (nextBits != 0)
					{
						int nextBit = nextBits & (-nextBits);
						int nextBitPos = getFirstOne(nextBit);
						
						nextBits &= nextBits - 1;
						
						if (nextBitPos == min)
							continue;
						
						if (!isConnected(graph, firstBitPos, nextBitPos))
							continue;
						
						/*System.out.println("Comb: " + Integer.toBinaryString(baseCombination));
						System.out.println("Bit: " + Integer.toBinaryString(firstBit));
						System.out.println("(pos): " + firstBitPos);
						System.out.println("Left over: " + Integer.toBinaryString(leftOverBits));
						System.out.println("Next bit: " + Integer.toBinaryString(nextBit));
						System.out.println("(pos): " + nextBitPos);
						System.out.println();*/
						
						state[baseCombination][firstBitPos] += state[leftOverBits][nextBitPos];
					}
					
					if (isConnected(graph, firstBitPos, min))
						res += state[baseCombination][firstBitPos];
				}
				
				baseCombination = nextCombination(baseCombination);
			}
		}
		
		/*for (int i = 0; i < state.length; i++)
		{
			if ((i & (i - 1)) == 0)
				continue;
			System.out.print(String.format("%4s:", Integer.toBinaryString(i)).replace(' ', '0') + " ");
			for (int j = 0; j < state[i].length; j++)
				System.out.print(state[i][j] + " ");
			System.out.println();
		}*/
		
		return res >> 1;
	}
	
	public static boolean isConnected(boolean[][] graph, int a, int b)
	{
		if (b < a || graph[a].length <= (b - a))
			return graph[b][a - b];
		return graph[a][b - a];
	}
	
	public static void setConnected(boolean[][] graph, int a, int b)
	{
		if (b < a || graph[a].length <= (b - a))
			graph[b][a - b] = true;
		else
			graph[a][b - a] = true;
	}
	
	public static int nextCombination(int x)
	{
		int smallest = x & -x;
		int ripple = x + smallest;
		int ones = ((x ^ ripple) >> 2) / smallest;
		return ripple | ones;
	}
	
	public static boolean on(int bitmask, int pos)
	{
		return ((bitmask >> pos) & 1) == 1;
	}
	
	public static int setOn(int bitmask, int pos)
	{
		return bitmask | (1 << pos);
	}
	
	public static int setOff(int bitmask, int pos)
	{
		return bitmask & ~(1 << pos);
	}
	
	public static int getOns(int bitmask)
	{
		int amt = 0;
		while (bitmask != 0)
		{
			bitmask &= bitmask - 1;
			amt++;
		}
		
		return amt;
	}
	
	public static int getFirstOne(int bitmask)
	{
		if (bitmask == 0)
			return -1;
		
		int first = 0;
		while ((bitmask & 1) != 1)
		{
			first++;
			bitmask = bitmask >> 1;
		}
		
		return first;
	}
	
	public static class FastInputStream extends InputStream
	{
		private InputStream in;
		
		private byte[] buffer = new byte[512];
		private int loaded = 0;
		private int pointer = 0;
		
		public FastInputStream(InputStream in)
		{
			this.in = in;
		}

		@Override
		public int read() throws IOException
		{
			if (hasNext())
				return buffer[pointer++];
			else
				return -1;
		}

		public void skipWhitespace() throws IOException
		{
			while (hasNext())
			{
				char c = (char) buffer[pointer];

				if (c == ' ' || c == '\t' || c == '\n' || c == '\r') pointer++;
				else return;
			}
		}

		public Integer nextInt() throws IOException
		{
			skipWhitespace();

			if (!hasNext()) return null;

			byte multiplier = 1;
			int number = 0;

			if (buffer[pointer] == '-')
			{
				multiplier = -1;
				pointer++;
			}

			while (hasNext())
			{
				char c = (char) buffer[pointer];

				if (c >= '0' && c <= '9')
				{
					number = (number << 3) + (number << 1) + c - '0';
					pointer++;
				} else break;
			}

			return number * multiplier;
		}
		
		public void close() throws IOException
		{
			in.close();
		}
		
		public boolean hasNext() throws IOException
		{
			while (pointer == loaded)
			{
				loaded = in.read(buffer);
				pointer = 0;
				
				if (loaded == -1) return false;
			}
			return loaded != -1;
		}
	}
}
