import java.io.*;
import java.util.*;
import java.math.*;

public class D {
	static byte[] buf = new byte[1<<26];
    static int bp = -1;	
	
	public static void main(String[] args) throws IOException {

		/**/
		DataInputStream in = new DataInputStream(System.in);
		/*/
		DataInputStream in = new DataInputStream(new FileInputStream("src/d.in"));
		/**/
		
		in.read(buf, 0, 1<<26);
		
		int n = nni();
		int m = nni();
		int k = nni();
		
		if (k%2==1) {
			for (int i = 0; i < n; ++i) {
				StringBuilder ans = new StringBuilder();
				String sp = "";
				for (int j = 0; j < m; ++j) {
					ans.append(sp+"-1");
					sp = " ";
				}
				System.out.println(ans);
			}
			return;
		}
		
		int[][] lr = new int[n][m-1];
		int[][] ud = new int[n-1][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m-1; ++j) {
				lr[i][j] = nni();
			}
		}
		for (int i = 0; i < n-1; ++i) {
			for (int j = 0; j < m; ++j) {
				ud[i][j] = nni();
			}
		}
		
		int[][][] ans = new int[k/2+1][n][m];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				for (int q = 1; q <= k/2; ++q) {
					ans[q][i][j] = 123456789;
				}
			}
		}
		
		for (int uq = 0; uq < k/2; ++uq) {
			for (int ui = 0; ui < n; ++ui) {
				for (int uj = 0; uj < m; ++uj) {
					int w = ans[uq][ui][uj];
					if (ui>0 && w+ud[ui-1][uj]<ans[uq+1][ui-1][uj]) {
						ans[uq+1][ui-1][uj] = w+ud[ui-1][uj];
					}
					if (ui<n-1 && w+ud[ui][uj]<ans[uq+1][ui+1][uj]) {
						ans[uq+1][ui+1][uj] = w+ud[ui][uj];
					}
					if (uj>0 && w+lr[ui][uj-1]<ans[uq+1][ui][uj-1]) {
						ans[uq+1][ui][uj-1] = w+lr[ui][uj-1];
					}
					if (uj<m-1 && w+lr[ui][uj]<ans[uq+1][ui][uj+1]) {
						ans[uq+1][ui][uj+1] = w+lr[ui][uj];
					}
				}
			}
		}
		
		for (int i = 0; i < n; ++i) {
			StringBuilder as = new StringBuilder();
			String sp = "";
			for (int j = 0; j < m; ++j) {
				as.append(sp+ans[k/2][i][j]*2);
				sp = " ";
			}
			System.out.println(as);
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