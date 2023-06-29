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
		List<Double> coords = new ArrayList<Double>();
		while (n-- > 0) {
			double x = scan.nextDouble();
			double a = scan.nextDouble() / 2;
			coords.add(x - a);
			coords.add(x + a);
		}
		Collections.sort(coords);
		int count = 2;
		ChoiceFormat f = new ChoiceFormat("-1#0|0#1|0<2");
		for (int i = 1; i < coords.size()-2; i+=2) {
			count += new Integer(f.format(coords.get(i+1)-coords.get(i)-t));
		}
		System.out.println(count);
	}
}
