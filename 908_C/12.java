import java.io.*;
import java.util.*;
import java.math.*;

public class utkarsh {

    InputStream is;
    PrintWriter out;
    
    double x[], y[], R;
    
    boolean game(double x1, double y1, double x2, double y2){
        double dis = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        //if(x2 == 12 && x1 == 8 && y1 > 13 && y1 < 14)    out.println(dis +" "+ y2);
        return dis <= 4.0 * R * R;
    }
    
    void play(int n){
        double l, r, m;
        double a[] = new double[n];
        for(int i = 0; i < n; i++){ 
            l = 0.0;
            r = 1000000.0;
            for(int j = 0; j < 50; j++){
                m = (l + r) / 2;
                if(game(x[i], 0, x[n], m))  l = m;
                else    r = m;
            }
            a[i] = l;
        }
        for(int i = 0; i < n; i++){
            //if(n == 4)  out.println(a[i] +" "+ y[i]);
            if(a[i] > 0.0 && (y[i] + a[i]) > y[n])    y[n] = y[i] + a[i];
        }
    }
    
    void solve(){
        //Enter code here utkarsh
        int i, j, n;
        n = ni();
        R = nd();
        x = new double[n];
        y = new double[n];
        for(i = 0; i < n; i++)  x[i] = nd();
        for(i = 0; i < n; i++){
            play(i);
        }
        for(i = 0; i < n; i++)  out.print((R + y[i]) +" ");
    }
    
    public static void main(String[] args) { new utkarsh().run();
    }
    void run(){ is = System.in; out = new PrintWriter(System.out); solve(); out.flush();
    }
    
    byte input[] = new byte[1024];
    int len = 0, ptr = 0;
    
    int readByte(){ if(ptr >= len){ ptr = 0; try{ len = is.read(input); }catch(IOException e){ throw new InputMismatchException(); } if(len <= 0){ return -1; } } return input[ptr++];
    }
    boolean isSpaceChar(int c){ return !( c >= 33 && c <= 126 ); 
    }
    int skip(){ int b = readByte(); while(b != -1 && isSpaceChar(b)){ b = readByte(); } return b;
    }
    
    char nc(){ return (char)skip();
    }
    String ns(){ int b = skip(); StringBuilder sb = new StringBuilder(); while(!isSpaceChar(b)){ sb.appendCodePoint(b); b=readByte(); } return sb.toString();
    }
    int ni(){ int n = 0,b = readByte(); boolean minus = false; while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')){ b = readByte(); } if(b == '-'){ minus = true; b = readByte(); } if(b == -1){ return -1; } while(b >= '0' && b <= '9'){ n = n * 10 + (b - '0'); b = readByte(); } return minus ? -n : n;
    }
    long nl(){ long n = 0L; int b = readByte(); boolean minus = false; while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')){ b = readByte(); } if(b == '-'){ minus = true; b = readByte(); } while(b >= '0' && b <= '9'){ n = n * 10 + (b - '0'); b = readByte(); } return minus ? -n : n;
    }
    double nd(){ return Double.parseDouble(ns());
    }
    float nf(){ return Float.parseFloat(ns());
    }
    int[] na(int n){ int a[] = new int[n]; for(int i = 0; i < n; i++){ a[i] = ni(); } return a;
    }
    char[] ns(int n){ char c[] = new char[n]; int i,b = skip(); for(i = 0; i < n; i++){ if(isSpaceChar(b)){ break; } c[i] = (char)b; b = readByte(); } return i == n ? c : Arrays.copyOf(c,i);
    }
}