import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String line = br.readLine();
			int n = Integer.parseInt(br.readLine());
			int[] time = new int[n];
			int[] cent = new int[n];
			int[] result = new int[n];
			for (int i = 0; i < n; i++) {
				line = br.readLine();
				time[i] = Integer.parseInt(line.split(" ")[0]);
				cent[i] = Integer.parseInt(line.split(" ")[1]);
				result[i] = i;
			}
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n - 1; j++)
					if (time[result[j]] * cent[result[j + 1]] > time[result[j + 1]] * cent[result[j]]) {
						int temp = result[j];
						result[j] = result[j + 1];
						result[j + 1] = temp;
					}
			for (int i = 0; i < n; i++) {
				sb.append(result[i] + 1);
				if (i < n - 1)
					sb.append(" ");
			}
			if (t > 0)
				sb.append("\n");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}