import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class E1 {
	static byte[] buf = new byte[1<<26];
    static int bp = -1;	
	
	public static void main(String[] args) throws IOException {

		/**/
		DataInputStream in = new DataInputStream(System.in);
		/*/
		DataInputStream in = new DataInputStream(new FileInputStream("src/e.in"));
		/**/
		
		in.read(buf, 0, 1<<26);
		int t = nni();
		for (int z = 0; z < t; z++) {
			int n = nni();
			int m = nni();
			int[][] mat = new int[n][m];
			int[] rmax = new int[n];
			int tot = 0;
			HashSet<Integer> care = new HashSet<>();
			for (int i = 0; i < n; i++) {
				PriorityQueue<Integer> cols = new PriorityQueue<>();
				for (int j = 0; j < m; j++) {
					mat[i][j] = nni();
					cols.add(-(mat[i][j]*2000+j));
					rmax[i] = Math.max(rmax[i], mat[i][j]);
				}
				tot += rmax[i];
				for (int j = 0; j < Math.min(m, n); j++)
					care.add((-cols.poll())%2000);
			}
			List<Integer> cal = care.stream().sorted().collect(Collectors.toList());
			int ret = tot;
			if (Math.min(m, n)==1) {
				System.out.println(ret);
			} else if (Math.min(m, n)==2) {
				for (int a = 0; a < cal.size(); a++) {
					int la = cal.get(a);
					for (int d = 0; d < cal.size(); d++) {
						if (d==a)
							continue;
						int ld = cal.get(d);
						for (int i = 0; i < n; i++) {
							int tret = 0;
							for (int x = 0; x < n; x++) {
								tret += Math.max(mat[x][ld], mat[(i+x)%n][la]);
							}
							ret = Math.max(ret, tret);
						}
					}
				}
				System.out.println(ret);
			} else if (Math.min(m, n)==3) {
				for (int a = 0; a < cal.size(); a++) {
					int la = cal.get(a);
					for (int b = a+1; b < cal.size(); b++) {
						int lb = cal.get(b);
						for (int d = 0; d < cal.size(); d++) {
							if (d==a)
								continue;
							if (d==b)
								continue;
							int ld = cal.get(d);
							for (int i = 0; i < n; i++) {
								for (int j = 0; j < n; j++) {
									int tret = 0;
									for (int x = 0; x < n; x++) {
										tret += Math.max(mat[x][ld], Math.max(mat[(i+x)%n][la], mat[(j+x)%n][lb]));
									}
									ret = Math.max(ret, tret);
								}
							}
						}
					}
				}
				System.out.println(ret);
			} else if (Math.min(m, n)==4) {
				for (int a = 0; a < cal.size(); a++) {
					int la = cal.get(a);
					for (int b = a+1; b < cal.size(); b++) {
						int lb = cal.get(b);
						for (int c = b+1; c < cal.size(); c++) {
							int lc = cal.get(c);
							for (int d = 0; d < cal.size(); d++) {
								if (d==a)
									continue;
								if (d==b)
									continue;
								if (d==c)
									continue;
								int ld = cal.get(d);
								for (int i = 0; i < n; i++) {
									for (int j = 0; j < n; j++) {
										for (int k = 0; k < n; k++) {
											int tret = 0;
											for (int x = 0; x < n; x++) {
												tret += Math.max(mat[x][ld], Math.max(mat[(i+x)%n][la], Math.max(mat[(j+x)%n][lb], mat[(k+x)%n][lc])));
											}
											ret = Math.max(ret, tret);
										}
									}
								}
							}
						}
					}
				}
				System.out.println(ret);
			}
		}
	}
	
	public static int nni() {
        int ret = 0;
        byte b = buf[++bp];
        while (true) {
            ret = ret*10+b-'0';
            b = buf[++bp];
            if (b<'0'||b>'9') {
            	while (buf[bp+1]=='\r'||buf[bp+1]=='\n'||buf[bp+1]==' ') {++bp;}
            	break;
            }
        }
        return ret;
    }
}