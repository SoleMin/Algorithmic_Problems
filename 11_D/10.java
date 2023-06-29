import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: piyushd
 * Date: 12/31/10
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleCycle {

	int first(int x){
		return x - (x & (x - 1));
	}

    void run(){
		int N = nextInt(), M = nextInt();
		int[] graph = new int[N];
		for(int i = 0; i < M; i++){
			int a = nextInt() - 1, b = nextInt() - 1;
			graph[a] |= (1<<b);
			graph[b] |= (1<<a);
		}

		int[] bitcount = new int[1<<N];
		for(int i = 0; i < (1<<N); i++){
			bitcount[i] = bitcount[i>>1];
			if(i % 2 == 1) bitcount[i]++;
		}

		long[][] dp = new long[1<<N][N];
		for(long[] f : dp) Arrays.fill(f, 0);
		long ans = 0;
		for(int mask = 1; mask < (1<<N); mask++){
			for(int i = 0; i < N; i++)if((mask & (1<<i)) > 0){
				if(bitcount[mask] == 1) dp[mask][i] = 1;
				else{
					if(first(mask) != (1<<i)){
						for(int j = 0; j < N; j++)if((graph[i] & (1<<j)) > 0 && (mask & (1<<j)) > 0){
							dp[mask][i] += dp[mask - (1<<i)][j];
						}
					}
				}
				if(bitcount[mask] >= 3 && (graph[i] & first(mask)) > 0) ans += dp[mask][i];
			}
		}

		System.out.println(ans / 2);
    }

    int nextInt(){
        try{
            int c = System.in.read();
            if(c == -1) return c;
            while(c != '-' && (c < '0' || '9' < c)){
                c = System.in.read();
                if(c == -1) return c;
            }
            if(c == '-') return -nextInt();
            int res = 0;
            do{
                res *= 10;
                res += c - '0';
                c = System.in.read();
            }while('0' <= c && c <= '9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }

    long nextLong(){
        try{
            int c = System.in.read();
            if(c == -1) return -1;
            while(c != '-' && (c < '0' || '9' < c)){
                c = System.in.read();
                if(c == -1) return -1;
            }
            if(c == '-') return -nextLong();
            long res = 0;
            do{
                res *= 10;
                res += c-'0';
                c = System.in.read();
            }while('0' <= c && c <= '9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }

    double nextDouble(){
        return Double.parseDouble(next());
    }

    String next(){
        try{
            StringBuilder res = new StringBuilder("");
            int c = System.in.read();
            while(Character.isWhitespace(c))
                c = System.in.read();
            do{
                res.append((char)c);
            }while(!Character.isWhitespace(c=System.in.read()));
            return res.toString();
        }catch(Exception e){
            return null;
        }
    }

    String nextLine(){
        try{
            StringBuilder res = new StringBuilder("");
            int c = System.in.read();
            while(c == '\r' || c == '\n')
                c = System.in.read();
            do{
                res.append((char)c);
                c = System.in.read();
            }while(c != '\r' && c != '\n');
            return res.toString();
        }catch(Exception e){
            return null;
        }
    }

    public static void main(String[] args){
        new SimpleCycle().run();
    }
}
