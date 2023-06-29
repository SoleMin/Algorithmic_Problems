import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


public class Main {
private static StreamTokenizer in;
private static PrintWriter out;
private static int nextInt() throws Exception {
in.nextToken();
return (int)in.nval;
}
private static String nextString() throws Exception {
in.nextToken();
return in.sval;
}

public static void main(String[] args) throws Exception {
in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
out = new PrintWriter(System.out);
int n = nextInt();
byte f = (byte)nextInt();
byte s = (byte)nextInt();
byte t = (byte)nextInt();
boolean bf = false;
boolean bs = false;
boolean bt = false;
if((f&1) == 0){bf = true;}
if((s&1) == 0){bs = true;}
if((t&1) == 0){bt = true;}
//System.out.println(bf+""+bs+""+bt);
if((!bf)&&bs&&bt){System.out.println(1);return;}
if(bf&&(!bs)&&bt){System.out.println(2);return;}
if(bf&&bs&&(!bt)){System.out.println(3);return;}
if(bf&&!bs&&!bt){System.out.println(1);return;}
if(!bf&&bs&&!bt){System.out.println(2);return;}
if(!bf&&!bs&&bt){System.out.println(3);return;}
for(int i = 4; i<=n; i++){
byte g = (byte) nextInt();
if(((g+f)&1) == 1){System.out.println(i); return;}
}



out.flush();
}
}