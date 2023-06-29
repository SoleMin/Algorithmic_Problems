import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-- > 0) {
			int r = input.nextInt();
			int[] s = new int[r];
			for (int i = 0; i < r; i++)
				s[i] = input.nextInt();
			quickSort(s);
			int mid = (r - 1) / 2;
			int sum = 0;
			for (int i = 0; i < mid; i++) {
				sum += s[mid] - s[i];
			}
			for (int i = mid + 1; i < r; i++)
				sum += s[i] - s[mid];
			System.out.println(sum);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static int partition(int[] a, int left, int right) {
		int pivot = a[(left + right) / 2];
		while (left <= right) {
			while (a[left] < pivot)
				left++;
			while (a[right] > pivot)
				right--;
			if (left <= right) {
				swap(a, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void sort(int[] a, int left, int right) {
		if (left >= right)
			return;
		int mid = partition(a, left, right);
		sort(a, left, mid - 1);
		sort(a, mid, right);
	}

	public static void quickSort(int[] a) {
		sort(a, 0, a.length - 1);
	}
}