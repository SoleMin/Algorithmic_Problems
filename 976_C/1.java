import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Triplet[] a = new Triplet[n];
		for (int i = 0; i < n; ++i) {
			a[i] = new Triplet(in.nextInt(), in.nextInt(), i + 1);
		}
		Arrays.sort(a);

		int currL = Integer.MIN_VALUE;
		int currR = Integer.MIN_VALUE;
		int currIdx = -1;
		for (int i = 0; i < n; ++i) {
			if (a[i].r > currR) {
				currL = a[i].l;
				currR = a[i].r;
				currIdx = a[i].idx;
			} else {
				System.out.println(a[i].idx + " " + currIdx);
				return;
			}
		}
		System.out.println(-1 + " " + -1);
	}

	static class Triplet implements Comparable<Triplet> {
		int l, r, idx;

		Triplet(int l, int r, int idx) {
			this.l = l;
			this.r = r;
			this.idx = idx;
		}

		public int compareTo(Triplet t) {
			if (t.l != this.l) return this.l - t.l;

			return t.r - this.r;
		}
	}
}