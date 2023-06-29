import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class C implements Runnable {

	private void Solution() throws IOException {
		int n = nextInt(), max = 0, maxi = 0;
		ArrayList<Integer> mas = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int num = nextInt();
			if (num > max) {
				max = num;
				maxi = i;
			}
			mas.add(num);
		}
		mas.remove(maxi);
		mas.add(max == 1 ? 2 : 1);
		Collections.shuffle(mas);
		Collections.sort(mas);
		for (int i = 0; i < n; i++)
			System.out.print(mas.get(i) + " ");
	}

	public static void main(String[] args) {
		new C().run();
	}

	BufferedReader in;
	StringTokenizer tokenizer;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			Solution();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(in.readLine());
		return tokenizer.nextToken();
	}
}