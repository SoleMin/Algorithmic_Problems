import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.IOException;
import java.util.StringTokenizer;
/*
 * @author Tnascimento 
 */

public class MaeDosDragoes {
	public static PrintWriter saida = new PrintWriter(System.out, false);
	public static class Escanear {
        BufferedReader reader;
        StringTokenizer tokenizer;
		public Escanear() {
            this(new InputStreamReader(System.in));
        }
		public Escanear(Reader in) {
            reader = new BufferedReader(in);
        }
        String proximo() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(proximo());
        }

    }



    public static void main(String[] args) {
		Escanear fastScanner = new Escanear();
        int proximoInt = fastScanner.nextInt();
        double proximoDouble = fastScanner.nextInt();
        long[] graph = new long[proximoInt];
        for(Integer i = 0; i < proximoInt; i++) {
            for(Integer j =0; j < proximoInt; j++) {
                Integer val = fastScanner.nextInt();
                if (val.equals(1) || i.equals(j)) {
				 graph[i] |= 1L << j;
				}
            }
        }

        int szLeft = proximoInt/2;
        int szRight = proximoInt - szLeft;

        int[] dp = new int[1 << szLeft];
        int maxMask = 1 << szLeft;

        for(int mask = 1; mask <maxMask; mask++) {
            int curMask = mask;

            for(int j = 0; j < szLeft; j++) {
                if (((1 << j) & mask) > 0) {
                    curMask &= graph[j + szRight] >> szRight;
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << j)]);
                }
            }
            if (mask == curMask) {
                dp[mask] = Math.max(dp[mask],Integer.bitCount(mask));
            }
        }
        int ans = 0;
        int rmaxMask = 1 << szRight;
        for(int mask = 0; mask < rmaxMask; mask++) {
            int curMask = mask;
            int oMask = maxMask -1;
            for(int j = 0; j < szRight; j++) {
                if (((1 << j) & mask) > 0) {
                    curMask &= (graph[j] & (rmaxMask-1));
                    oMask &= graph[j] >> szRight;
                }
            }
            if (curMask != mask) continue;
            ans = Math.max(ans, Integer.bitCount(mask) + dp[oMask]);
        }
        proximoDouble/=ans;
        saida.println(proximoDouble * proximoDouble * (ans * (ans-1))/2);
        saida.flush();
    }
}
