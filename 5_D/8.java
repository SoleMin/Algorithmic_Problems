import java.io.*;
import java.util.*;
import java.math.*;

public class D5 {

	static int a, v, l, d;
	static double w;

	static double afterMark( int s, double w) {
		if (2 * s * a > v * v - w * w) { // ���� ��������� v. ����� ��
			return (v - w) * 1.0 / a + (s - (v * v - w * w) * 1.0 / (2 * a)) / v;
		} else { // ���������
			double megav = Math.sqrt((2 * a * s + w * w) * 1.0);
			return (megav - w) / a;
		}
	} 

	public static void main(String args[]) throws IOException {
		boolean online = System.getProperty("ONLINE_JUDGE") != null;
		Scanner in = online ? new Scanner(System.in) : new Scanner(new FileReader("input.txt"));
		PrintWriter out = online ? new PrintWriter(System.out) : new PrintWriter(new FileWriter("output.txt"));
		

		a = in.nextInt();
		v = in.nextInt();
		l = in.nextInt();
		d = in.nextInt();
		w = (double) in.nextInt();
		
		double t,t1,t2;

		if (v > w) { // ����� ��������� ������, ����� ����� ���
		
		
		// ������� ������ �� �����
		
			if (2 * d * a > 2 * v * v - w * w) { // ���� ��������� v. ����� ��
				t1 = (2 * v - w) * 1.0 / a + (d - (2 * v * v - w * w) * 1.0 / (2 * a)) / v; 
			} else if (2 * d * a > w * w) { // ���� �� ���������, �� ���� � ���� - ���������
				double topv = Math.sqrt(d * a + w * w * 1.0 / 2);
				t1 = (2 * topv - w) * 1.0 / a;
			} else { // ���� ����������� �� ������ ����� - �����, ���������
				t1 = Math.sqrt(2 * d * 1.0 / a);
				w = Math.sqrt(2 * a * d * 1.0); 
			}
		// ������� ������ ����� �����
			t2 = afterMark(l - d, w); 
		
		t = t1 + t2;
			
		} else {
			t = afterMark(l, 0.0);		
		}
		
		out.println(t);
		out.flush();
		return;
	}
}