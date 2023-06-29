import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer; 
		  
		
		public class temp4 {
			static class FastReader 
		    { 
		        BufferedReader br; 
		        StringTokenizer st; 
		  
		        public FastReader() 
		        { 
		            br = new BufferedReader(new
		                     InputStreamReader(System.in)); 
		        } 
		  
		        String next() 
		        { 
		            while (st == null || !st.hasMoreElements()) 
		            { 
		                try
		                { 
		                    st = new StringTokenizer(br.readLine()); 
		                } 
		                catch (IOException  e) 
		                { 
		                    e.printStackTrace(); 
		                } 
		            } 
		            return st.nextToken(); 
		        } 
		  
		        int nextInt() 
		        { 
		            return Integer.parseInt(next()); 
		        } 
		  
		        long nextLong() 
		        { 
		            return Long.parseLong(next()); 
		        } 
		  
		        double nextDouble() 
		        { 
		            return Double.parseDouble(next()); 
		        } 
		  
		        String nextLine() 
		        { 
		            String str = ""; 
		            try
		            { 
		                str = br.readLine(); 
		            } 
		            catch (IOException e) 
		            { 
		                e.printStackTrace(); 
		            } 
		            return str; 
		        } 
		    } 
			
		/*	static class Reader 
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
		    } */
			static class Print
		{
			    private final BufferedWriter bw;
			    public Print()
			    {
			        bw=new BufferedWriter(new OutputStreamWriter(System.out));
			    }
		    public void print(String str)throws IOException
			    {
			        bw.append(str);
			    }
			    public void println(String str)throws IOException
			    {
			        print(str);
			        bw.append("\n");
			    }
			    public void close()throws IOException
			    {
			        bw.close();
			    }} 
				
				
			
				public static void main(String[] args) throws IOException {			
					FastReader scn=new FastReader();
					Print pr=new Print();
					int n=scn.nextInt(),m=scn.nextInt();
					ArrayList<Integer>[] gr=new ArrayList[n+1];
					for(int i=0;i<=n;i++){
						gr[i]=new ArrayList<>();
					}
					int[][] input=new int[m+1][3];
					int[] dfn=new int[n+1];
					int[] deg=new int[n+1];
				
					for(int i=1;i<=m;i++){
						input[i][0]=scn.nextInt();
						input[i][1]=scn.nextInt();
						input[i][2]=scn.nextInt();
					}
					int l=0,r=(int) 1e9;
					while(l<r){
						int mid=(l+r)>>1;
					if(sol(mid,input,gr,dfn,deg,n,m)>0) r=mid;
					else l=mid+1;
					}
					sol(l,input,gr,dfn,deg,n,m);
					ArrayList<Integer> ans=new ArrayList<Integer>();
					for(int i=1;i<=m;i++){
						if(dfn[input[i][1]]<dfn[input[i][0]])ans.add(i);
						
					}
					pr.println(l+" "+ans.size());
					for(Integer val:ans){
						pr.print(val+" ");
					}
					pr.close();
				}
				public static int sol(int val,int[][] input,ArrayList<Integer>[] gr,int[] dfn,int[] deg,int n,int m){
					for(int i=1;i<=n;i++){
						gr[i].clear();
						dfn[i]=0;deg[i]=0;
					}
					for(int i=1;i<=m;i++){
						if(input[i][2]>val){
							gr[input[i][0]].add(input[i][1]);
							deg[input[i][1]]++;
						}
					}
					Queue<Integer> q=new LinkedList<>();
					for(int i=1;i<=n;i++)if(deg[i]==0)q.add(i);
					int count=0;
					while(q.size()>0){
						int x=q.poll();
						dfn[x]=++count;
						for(int i=0;i<gr[x].size();i++){
							deg[gr[x].get(i)]--;
							if(deg[gr[x].get(i)]==0)q.add(gr[x].get(i));
						}
					}
					return count==n?1:0;
				}
				
				
				
				public static class node{
					int val;
					int idx;
					public node(int val,int idx){
						this.val=val;this.idx=idx;
					}
				}
				
		}
			