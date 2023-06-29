import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		String p = input.nextLine();

		ArrayList<Integer> list = kmp(s, p);
		int size = list.size();
		System.out.println(size);
		
		for(int i=0; i<size; i++) {
			System.out.print(list.get(i)+1+" ");
		}
	}

	public static ArrayList<Integer> kmp(String s, String p) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] pi = getPi(p);
		int n = s.length(), m = p.length(), j = 0;
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();
		for (int i = 0; i < n; i++) {
			while (j > 0 && str[i] != pattern[j]) {
				j = pi[j - 1];
			}
			if (str[i] == pattern[j]) {
				if (j == m - 1) {
					list.add(i - m + 1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		return list;
	}



	public static int[] getPi(String p) {
		int m = p.length();
		int j = 0;
		char[] pattern = new char[m];
		int[] pi = new int[m];

		pattern = p.toCharArray();

		for (int i = 1; i < m; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = pi[j - 1];

			}
			if (pattern[i] == pattern[j]) {

				pi[i] = ++j;
			}
		}



		return pi;

	}

}
