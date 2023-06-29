			import java.io.*;
			import java.util.*;
			 
			public class oK{
					    void pre() throws Exception{}
					    void solve(int TC) throws Exception{
					    int n=ni();
					    	int a[]=new int[n];
					    for(int i=0;i<n;i++) {
					    	a[i]=ni();
					    }
					    Arrays.sort(a);
					    int b[]=new int[101];
					    int flag=0;
					    int count=0;
					    for(int i=0;i<n;i++) {
					    	flag=0;
					    	if(b[a[i]]==0) {
					    		count++;
					    	}
					    	for(int j=i;j<n;j++) {
					    		if(b[a[j]]==0&&a[j]%a[i]==0) {
					    			
					    			b[a[j]]=1;
					    			
					    		}
					    		//if(flag==1)count++;
					    	}
					    	
					    	
					    }
					    pn(count);
					    
					    
					    }
					    		
					    		
					    
					    
					    
					    
					    
					   // void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
					    static boolean multipleTC = false, memory = false;
					    FastReader in;PrintWriter out;
					    void run() throws Exception{
					        in = new FastReader();
					        out = new PrintWriter(System.out);
					        int T = (multipleTC)?ni():1;
					        pre();for(int t = 1; t<= T; t++)solve(t);
					        out.flush();
					        out.close();
					    }
					    public static void main(String[] args) throws Exception{
					        if(memory)new Thread(null, new Runnable() {public void run(){try{new oK().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
					        else new oK().run();
					    }
					    void p(Object o){out.print(o);}
					    void pn(Object o){out.println(o);}
					    void pni(Object o){out.println(o);out.flush();}
					    String n()throws Exception{return in.next();}
					    String nln()throws Exception{return in.nextLine();}
					    int ni()throws Exception{return Integer.parseInt(in.next());}
					    long nl()throws Exception{return Long.parseLong(in.next());}
					
					    class FastReader{
					        BufferedReader br;
					        StringTokenizer st;
					        public FastReader(){
					            br = new BufferedReader(new InputStreamReader(System.in));
					        }
					
					        public FastReader(String s) throws Exception{
					            br = new BufferedReader(new FileReader(s));
					        }
					
					        String next() throws Exception{
					            while (st == null || !st.hasMoreElements()){
					                try{
					                    st = new StringTokenizer(br.readLine());
					                }catch (IOException  e){
					                    throw new Exception(e.toString());
					                }
					            }
					            return st.nextToken();
					        }
					
					        String nextLine() throws Exception{
					            String str = "";
					            try{   
					                str = br.readLine();
					            }catch (IOException e){
					                throw new Exception(e.toString());
					            }  
					            return str;
					        }
					    }
					}