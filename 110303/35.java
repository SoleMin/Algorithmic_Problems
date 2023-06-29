import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<String> a1 = new LinkedList<>();
		List<String> a2 = new LinkedList<>();
		List<String> ins = new LinkedList<>();
		List<String> result = new LinkedList<>();
		String word;
		while(sc.hasNextLine()) {
			word = sc.nextLine();
			for(int idx = 0; idx < word.length(); idx++) {
				a1.add(word.substring(idx,idx+1));
			}
			word = sc.nextLine();
			for(int idx = 0; idx < word.length(); idx++) {
				a2.add(word.substring(idx,idx+1));
			}
			
			ins = a1.stream().filter(s -> a2.contains(s)).distinct().sorted().collect(Collectors.toList());
			a1.sort(String::compareTo);
			a2.sort(String::compareTo);
			
			for(String w : ins) {
				int m = a1.lastIndexOf(w) - a1.indexOf(w) + 1;
				int n = a2.lastIndexOf(w) - a2.indexOf(w) + 1;
				if(m > n) {
					m ^= n;
					n ^= m;
					m ^= n;
				}
				for(int i = 0; i < m; i++) {
					result.add(w);
				}
			}
			
			for(String w : result) {
				System.out.printf("%s",w);
			}

			
			System.out.println();
			a1.clear();
			a2.clear();
			ins.clear();
			result.clear();
		}
	}
}