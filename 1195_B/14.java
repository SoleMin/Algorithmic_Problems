// CodeForces Round #914 B train done

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SportMafia {
	
	int n,k;
	int nCand;

	private void readData(BufferedReader bin) throws IOException {
		String s = bin.readLine();
		String []ss = s.split(" ");
		n = Integer.parseInt(ss[0]);
		k = Integer.parseInt(ss[1]);
	}

	void printRes() {
		System.out.println(nCand);
	}	
	
	private void calculate() {
		// count napitki
		double p;
		p = -1.5 + Math.sqrt(2.25 + 2.0*(n+k));
		nCand = (int)Math.round(n-p);
	}
	
	public static void main(String[] args) throws IOException {
		// BufferedReader bin = new BufferedReader(new FileReader("cactus.in"));
		BufferedReader bin = new BufferedReader(
				new InputStreamReader(System.in));
		SportMafia l = new SportMafia();
		l.readData(bin);
		l.calculate();
		l.printRes();
	}
}
