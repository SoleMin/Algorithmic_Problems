
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		Task task = new Task();
		task.solve(in, out);
		out.close();

	}
	
	static class Rectangle {
		int x1, y1;
		int x2, y2;
	}
	
	static class Task {
		/**
		 * BEFORE SUBMITTING!!!
		 * MAKE SURE IT IS RIGHT!!!!!
		 * LONG!!
		 * Check if m,n aren't misused
		 * Make sure the output format is right (YES/NO vs Yes/No, newlines vs spaces)
		 * Run with n = 1 or n = 0
		 * Make sure two ints aren't multiplied to get a long

		 *
		 */
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			
			//ideas: procurar linha que os divide e procurar dentro desses sub-retangulos
			// procurar até ser 1
			
			//corner cases: se procurar até ser 1 e não verificar se tem 1 do outro lado posso chegar a 1,2...not good
			// tenho que procurar 1,1
			
			int l = 1;
			int r = n;
			
			int ans = 0;
			
			
			while(r >= l) {
				int mid = (r + l) / 2;
				if(ask(in,out,1,1,mid, n) == 0) {
					l = mid + 1;
				} else {
					ans = mid;
					r = mid - 1;
				}
			}
			//par 1,1
			//FDS ISTO
			if(ans < n && ask(in,out,ans + 1, 1,n,n) == 1) {
				Rectangle r1 = find(in,out,1,1,ans,n,n);
				Rectangle r2 = find(in,out,ans + 1,1,n,n,n);
				System.out.printf("! %d %d %d %d %d %d %d %d\n", r1.x1, r1.y1, r1.x2, r1.y2, r2.x1, r2.y1, r2.x2, r2.y2);
			} else {
				l = 1;
				r = n;
				
				ans = 0;
				
				
				while(r >= l) {
					int mid = (r + l) / 2;
					if(ask(in,out,1,1,n, mid) == 0) {
						l = mid + 1;
					} else {
						ans = mid;
						r = mid - 1;
					}
				}
				
				Rectangle r1 = find(in,out,1,1,n,ans,n);
				Rectangle r2 = find(in,out,1,ans + 1,n,n,n);
				System.out.printf("! %d %d %d %d %d %d %d %d\n", r1.x1, r1.y1, r1.x2, r1.y2, r2.x1, r2.y1, r2.x2, r2.y2);
				
			}
			
			
		}
		//HASDFDSJGHDFJKSGDFJSGJDFSGJDSFGJF
		//FKING WORK
		public Rectangle find(InputReader in, PrintWriter out,int x1, int y1, int x2, int y2, int n) {
			Rectangle rec = new Rectangle();
			
			int ansx1 = x1;
			int ansx2 = x2;
			int ansy1 = y1;
			int ansy2 = y2;

			int l = x1;
			int r = x2;
			

			// quero o minimo v >= x2 
			while(r >= l) {
				int mid = (r + l) / 2;
				
				if(ask(in,out,x1,y1,mid,y2) == 1) {
					ansx2 = mid;
					r = mid - 1;
				} else {
					l = mid + 1;
				}

			}
									
			//out.printf("x2 = %d", ansx2);
			
			

			r = x2;
			l = x1;
			
			// quero o maximo v <= x1
			
			while(r >= l) {
				int mid = (r + l) / 2;
				
				if(ask(in,out,mid,y1,x2,y2) == 1) {
					ansx1 = mid;
					l = mid + 1;
				} else {
					r = mid - 1;
				}

			}
									
			//out.printf("x1 = %d", ansx1);
			
			
			l = y1;
			r = y2;
			
			// quero o minimo v >= y2 
			while(r >= l) {
				int mid = (r + l) / 2;
				
				if(ask(in,out,x1,y1,x2,mid) == 1) {
					ansy2 = mid;
					r = mid - 1;
				} else {
					l = mid + 1;
				}

			}
									
			//out.printf("y2 = %d", ansy2);
			

			
			

			r = y2;
			l = y1;
			

			// quero o maximo v <= y1
			
			while(r >= l) {
				int mid = (r + l) / 2;
				
				if(ask(in,out,x1,mid,x2,y2) == 1) {
					ansy1 = mid;
					l = mid + 1;
				} else {
					r = mid - 1;
				}

			}
									
			//out.printf("y1 = %d", ansy1);
			


			
			rec.x1 = ansx1;
			rec.x2 = ansx2;
			rec.y1 = ansy1;
			rec.y2 = ansy2;

			
			
			return rec;
		}
		
		public int ask(InputReader in, PrintWriter out, int x1, int y1, int x2, int y2) {
			System.out.printf("? %d %d %d %d\n",x1,y1,x2,y2);
			System.out.flush();
			return in.nextInt();
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
               
            } catch (IOException e) {
            }
            return null;
        }


	}
}

