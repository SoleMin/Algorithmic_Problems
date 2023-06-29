import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	public Main() {
		super();
	}
	
	public static void main(String... args) {
		Main main = new Main();
		main.start();
	}
	
	
	public void start() {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		int t = in.nextInt();
		House list[] = new House[n];
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int a = in.nextInt();
			list[i] = new House(x, a);
		}
		Arrays.sort(list);
		int c = 2;
		for (int i = 1; i < n; i++) {
			float d = list[i].left - list[i - 1].right;
			if (d == t) c++;
			else if (d > t) c += 2;
		}
		System.out.println(c);
	}
}


class House implements Comparable<House> {
	public int x;
	public float left, right;
	public House(int x, int a) {
		this.x = x;
		float h = a / 2f;
		this.left = x - h;
		this.right = x + h;
	}
	
	public int compareTo(House h) {
		return this.x == h.x ? 0 : this.x < h.x ? -1 : 1;
	}
	
}