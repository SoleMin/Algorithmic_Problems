
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TemplateBuf implements Runnable{
    
    private void solve() throws Exception {
        long n = nextUnsignedLong();
        
        out.println(n+n/2);
    }

    /////////////////////////////////////////////////
    
    BufferedReader in;
    PrintWriter out;
    
    @Override
    public void run() {
        try{
            in = new BufferedReader(new InputStreamReader(System.in), INPUT_BUF_SIZE);
            out = new PrintWriter(new OutputStreamWriter(System.out));
            solve();
            out.flush();
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    final int INPUT_BUF_SIZE = 1024 * 8;
    final int BUF_SIZE = INPUT_BUF_SIZE;
    char[] buf = new char[BUF_SIZE];
    int ch=-1;
    int charRead=-1;
    int charPos=-1;
    
    public char nextChar() throws IOException{
        if (charPos<0 || charPos>=charRead){
            charRead = in.read(buf);
            charPos=0;
        }
        return buf[charPos++];
    }
    
    public long nextUnsignedLong() throws IOException{      
        while ((ch=nextChar())<'0' || ch>'9');
        long num = ch-'0';
        while ((ch=nextChar())>='0' && ch<='9'){
            num*=10;
            num+=ch-'0';
        }
        return num;
    }
    
    public int nextUnsignedInt() throws IOException{
        return (int)nextUnsignedLong();
    }
    
    public double nextDouble() throws IOException{
        while (((ch=nextChar())<'0' || ch>'9') && ch!='.' && ch!='-');
        char[] tmp = new char[255];
        int itmp = 0;
        tmp[itmp++]=(char)ch;
        while (((ch=nextChar())>='0' && ch<='9') || ch=='.' || ch=='-'){
            tmp[itmp++]=(char)ch;
        }
        return Double.parseDouble(new String(tmp,0,itmp));
    }
    
    public static void main(String[] args) {
        new TemplateBuf().run();
    }
    
}
