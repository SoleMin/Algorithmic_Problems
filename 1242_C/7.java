import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeSet;

public final class CF_599_D1_C
{


	static boolean verb=true;
	static void log(Object X){if (verb) System.err.println(X);}
	static void log(Object[] X){if (verb) {for (Object U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X){if (verb) {for (int U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X,int L){if (verb) {for (int i=0;i<L;i++) System.err.print(X[i]+" ");System.err.println("");}}
	static void log(long[] X){if (verb) {for (long U:X) System.err.print(U+" ");System.err.println("");}}

	static void logWln(Object X){if (verb) System.err.print(X);}
	static void info(Object o){	System.out.println(o);}
	static void output(Object o){outputWln(""+o+"\n");	}
	static void outputWln(Object o){try {out.write(""+ o);} catch (Exception e) {}}

	static long mod=1000000007;

	// Global vars
	static BufferedWriter out;
	static InputReader reader;


	static class Composite implements Comparable<Composite>{
		int idx;
		int v;

		public int compareTo(Composite X) {
			if (v!=X.v)
				return v-X.v;
			return idx-X.idx;


		}

		public Composite(int idx, int v) {
			this.idx = idx;
			this.v = v;
		}



	}

	static void test() {
		log("testing");

		log("done");

	}

	static void explore(ArrayList<Integer>[] components,ArrayList<Integer> bob,int[][] move,ArrayList<int[]>[] howto,int[][] list) {

		for (int x:bob) {
			if (components[x].size()==1) {
				int tm[]=howto[x].get(0);


				int L=howto[x].size();
				howto[x].add(tm);
				for (int i=0;i<L;i++) {
					int[] cur=howto[x].get(i);
					int[] nx=howto[x].get(i+1);
					int a=cur[0];
					int a2=nx[0];
					int b2=nx[1];
					move[a2][0]=list[a2][b2];
					move[a2][1]=a;
				}

			} else {
				explore(components,components[x],move,howto,list);
			}
		}
	}


	static void process() throws Exception {


		//arrayTest();

		out = new BufferedWriter(new OutputStreamWriter(System.out));
		reader = new InputReader(System.in);


		int k=reader.readInt();
		int[][] list=new int[k][];
		long[] sum=new long[k];
		int[] L=new int[k];
		HashMap<Integer,int[]> target=new HashMap<Integer,int[]>();
		long tot=0;
		for (int i=0;i<k;i++) {
			L[i]=reader.readInt();
			list[i]=new int[L[i]];
			for (int j=0;j<L[i];j++) {
				list[i][j]=reader.readInt();
				sum[i]+=list[i][j];
				target.put(list[i][j],new int[] {i,j});
			}
			tot+=sum[i];
		}

		int MX=1<<k;
		int AX=1000000001;
		ArrayList<int[]>[] howto=new ArrayList[MX];

		log("ok with the data");

		if (tot%k!=0) {
			output("No");
		} else {

			tot/=k;





			for (int i=0;i<k;i++) {

				if (sum[i]==tot) {
					//log("nothing to do for i:"+i);
					// nothing to do
					int mask=1<<i;
					ArrayList<int[]> cand=new ArrayList<int[]>();
					cand.add(new int[] {i,0});
					howto[mask]=cand;
				} else 


					for (int j=0;j<L[i];j++) {
						int u=i;
						int v=j;
						boolean ok=true;
						int src_u=u;
						int src_v=v;
						int mask=0;
						boolean goon=true;
						ArrayList<int[]> cand=new ArrayList<int[]>();
						//log("start loop");
						while (goon) {
							cand.add(new int[] {u,v});
							//log("u:"+u+" v:"+v);
							ok=false;
							goon=false;
							long need=tot-((long)sum[u]-(long)list[u][v]);
							if (Math.abs(need)<=AX) {
								//log("need:"+need);
								int nd=(int)need;
								int[] tm=target.get(nd);
								//log("tm:"+tm);
								if (tm!=null) {
									//log("can find successor");
									int nxu=tm[0];
									int nxv=tm[1];
									if ((mask&(1<<nxu))==0) {
										mask|=1<<nxu;
										if (nxu==src_u) {
											// looping back to source
											if (nxv==src_v)
												ok=true;
										} else {
											u=nxu;
											v=nxv;
											ok=true;
											goon=true;
										}
									} 
								}
							}
						}
						if (ok) {
							if (howto[mask]==null) {

								howto[mask]=cand;

							}
						}
					}
			}

			log("step 1 done");

			// now mask

			ArrayList<Integer> msk=new ArrayList<Integer>();
			ArrayList[] components=new ArrayList[MX];

			for (int m=0;m<MX;m++) {
				if (howto[m]!=null) {
					//String s=Integer.toBinaryString(m);
					//while (s.length()<k)
					//	s="0"+s;
					//log("found mask:"+s);
					components[m]=new ArrayList<Integer>();
					components[m].add(m);
				}
			}



			int[] visited=new int[MX];


			for (int a=0;a<MX;a++) {
				if (howto[a]!=null) {
					ArrayList<Integer> add=new ArrayList<Integer>();
					
					for (int b:msk) {
						if ((b&a)==0) {

							int c=b|a;
							log("creating c:"+c+" ");
							if (components[c]==null) {
								components[c]=new ArrayList<Integer>();
								components[c].add(a);
								components[c].add(b);
								add.add(c);
							}
						}
					}
					msk.add(a);
					for (int c:add) {
						
							msk.add(c);
						
					}
				}
			}
			//log("msk:"+msk);
			//log(components[MX-1]);
			if (components[MX-1]!=null) {
				output("Yes");
				int[][] move=new int[k][2];
				explore(components,components[MX-1],move,howto,list);
				for (int i=0;i<k;i++) {
					output(move[i][0]+" "+(move[i][1]+1));
				}

			} else {
				output("No");
			}

		}


		try {
			out.close();
		} catch (Exception e) {
		}

	}





	public static void main(String[] args) throws Exception {
		process();

	}

	static final class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read(buf);
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public final int readInt() throws IOException {
			int c = read();
			boolean neg = false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d = (char) c;
			// log("d:"+d);
			if (d == '-') {
				neg = true;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			// log("res:"+res);
			if (neg)
				return -res;
			return res;

		}

		public final long readLong() throws IOException {
			int c = read();
			boolean neg = false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d = (char) c;
			// log("d:"+d);
			if (d == '-') {
				neg = true;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			// log("res:"+res);
			if (neg)
				return -res;
			return res;

		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}

}