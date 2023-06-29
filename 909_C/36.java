import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PythonIndentiation {
	PrintWriter pw = new PrintWriter(System.out);
	final static boolean debugmode = true;
	public static int k = 7; // for 10^9 + k mods.
	public static int STMOD = 1000000000 + k; // 10^9 + k
	public static Reader sc = new Reader();

	public static void main(String[] args) throws IOException {
		int commands = sc.nextInt();
		int[][] dp = new int[5000][5000];
		int interesting = 0;
		String prgm = "";
		while (interesting < commands){
			byte q = sc.read();
			if (q == 115 ){
				interesting += 1;
				prgm += "s";
			}
			else if (q == 102){
				prgm += "f";
				interesting += 1;
			}
		}
		//System.out.println("Program: "+prgm);
		dp[0][0] = 1; // line, indentations
		for(int line = 1;line<commands;line++){
			if(prgm.charAt(line-1) == 'f'){
				for(int indent  = 1;indent<Math.min(2*line + 1, 5000);indent++){
					dp[line][indent] = dp[line-1][indent-1];
				}
			}
			else if(prgm.charAt(line-1) == 's'){
				int w = 0;
				for(int indent = Math.min(2*line + 1, 4999);indent >= 0;indent--){
					w = (w + dp[line-1][indent])% STMOD;
					
					dp[line][indent] = w ;
				}
			}
		}
		int q = 0;
		for(int i = 0;i<5000;i++){
			q  = ( q + dp[commands-1][i] ) % STMOD;
		}
		System.out.println(q);
		
	    
	}
	public static String parseIt(int commands) throws IOException{
		String c = "";
		System.out.println(sc.read());
		return c;
	}
	static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
 
    
}
