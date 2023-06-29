import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main implements Runnable {

	final String filename = "";

	public int nextPerm(int[] a, int k) {
		if (a[0] == k)
			return -1;
		int last = 0;
		for (int i = a.length - 1; i >= 0; i--)
			if (a[i] != 0) {
				last = i;
				break;
			}
		int mem=a[last];
		a[last-1]++;
		a[last]=0;
		a[a.length-1]=mem-1;
		return 0;
	}
	
	public double poss(int A,int[][] sen,int[] rasp){
		int n=sen.length;
		double[] possluck=new double[n];
		for(int i=0;i<n;i++)
			possluck[i]=Math.min(100, sen[i][1]+rasp[i]*10)/100.0;
		double poss=0;
		for(int i=0;i<(1<<n);i++){
			int kol=0;
			for(int j=0;j<n;j++)
				if((i%(1<<(j+1)))/(1<<(j))==1)
					kol++;
			double thisposs=1;
			for(int j=0;j<n;j++)
				if((i%(1<<(j+1)))/(1<<(j))==1)
					thisposs*=possluck[j];
				else
					thisposs*=(1-possluck[j]);
			if(kol>n/2)
				poss+=thisposs;
			else{
				double lvl=0;
				for(int j=0;j<n;j++)
					if((i%(1<<(j+1)))/(1<<(j))==0)
						lvl+=sen[j][0];
				poss+=thisposs*(A/(A+lvl));
			}
		}
		return poss;
	}

	public void solve() throws Exception {
		int n = iread(), k = iread(), A = iread();
		int[][] sen = new int[n][2];
		for (int i = 0; i < n; i++) {
			sen[i][0] = iread();
			sen[i][1] = iread();
		}
		double maxposs=0;
		int[] rasp=new int[n];
		rasp[n-1]=k;
		maxposs=Math.max(maxposs, poss(A,sen,rasp));
		while(nextPerm(rasp,k)==0)
			maxposs=Math.max(maxposs, poss(A,sen,rasp));
		out.write(maxposs+"\n");
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new BufferedWriter(new OutputStreamWriter(System.out));
			// in = new BufferedReader(new FileReader(filename+".in"));
			// out = new BufferedWriter(new FileWriter(filename+".out"));
			solve();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int iread() throws Exception {
		return Integer.parseInt(readword());
	}

	public double dread() throws Exception {
		return Double.parseDouble(readword());
	}

	public long lread() throws Exception {
		return Long.parseLong(readword());
	}

	BufferedReader in;

	BufferedWriter out;

	public String readword() throws IOException {
		StringBuilder b = new StringBuilder();
		int c;
		c = in.read();
		while (c >= 0 && c <= ' ')
			c = in.read();
		if (c < 0)
			return "";
		while (c > ' ') {
			b.append((char) c);
			c = in.read();
		}
		return b.toString();
	}

	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.US);
		} catch (Exception e) {

		}
		// new Thread(new Main()).start();
		new Thread(null, new Main(), "1", 1 << 25).start();
	}
}