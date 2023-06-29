import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CFTest6 {

	static BufferedReader br;

	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));

		try {

			int[] a1 = readIntArr();
			int[] a2 = readIntArr();
			br.close();
			int f = a1[0];
			int d = a1[1];
			int s = a1[2];
			Arrays.sort(a2);

			if (d <= s)
				System.out.println(0);

			else {
				int cur = d - s + 1;

				
				int num=0;
				for(int i=0;i<f;i++){
					num++;
					cur-=a2[f-i-1];
					if(cur<=0)break;
					cur++;
				}
				if (cur > 0)
					System.out.println(-1);
				else{
					
				
					System.out.println(num);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static public String readLine() throws IOException {
		return br.readLine();

	}

	static public String readString() throws IOException {
		return br.readLine();

	}

	static public long readlong() throws IOException {
		return Long.parseLong(br.readLine());
	}

	static public int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static public int[] readIntArr() throws IOException {
		String[] str = br.readLine().split(" ");
		int arr[] = new int[str.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(str[i]);
		return arr;
	}

	static public double[] readDoubleArr() throws IOException {
		String[] str = br.readLine().split(" ");
		double arr[] = new double[str.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Double.parseDouble(str[i]);
		return arr;
	}

	static public long[] readLongArr() throws IOException {
		String[] str = br.readLine().split(" ");
		long arr[] = new long[str.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Long.parseLong(str[i]);
		return arr;
	}

	static public double readDouble() throws IOException {
		return Double.parseDouble(br.readLine());
	}
}
