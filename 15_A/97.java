import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t = scan.nextInt();
		List<List<Double>> coords = new ArrayList<List<Double>>();
		while (n-- > 0) {
			double x = scan.nextDouble();
			double a = scan.nextDouble() / 2;
			coords.add(Arrays.asList(x - a, x + a));
		}
		Collections.sort(coords, new Comparator<List<Double>>() {
			@Override
			public int compare(List<Double> o1, List<Double> o2) {
				return o1.get(0).compareTo(o2.get(0));
			}
		});
		int count = 2;
		ChoiceFormat f = new ChoiceFormat("-1#0|0#1|0<2");
		for (int i = 0; i < coords.size()-1; i++) {
			double l = coords.get(i+1).get(0)-coords.get(i).get(1)-t;
			count += new Integer(f.format(l));
		}
		System.out.println(count);
	}
}
