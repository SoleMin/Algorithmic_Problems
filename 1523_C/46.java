import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;


public class Solution {
    public static void main(String[] args)throws IOException {
        FastReader in=new FastReader(System.in);
        int t=in.nextInt();
        StringBuilder sb=new StringBuilder();
        int i,j,tc=0;
        while(tc++<t) {
            int n=in.nextInt();
            int arr[]=new int[n];
            for(i=0;i<n;i++)
                arr[i]=in.nextInt();
            int ans[]=new int[n+4];
            ans[0]=1;
            int pos=0;
            sb.append("1\n");
            for(i=1;i<n;i++){
                if(arr[i]==arr[i-1]+1){
                    ans[pos]=ans[pos]+1;
                }
                else if(arr[i]==1){
                    pos++;
                    ans[pos]=1;
                }
                else{
                    while(ans[pos]!=arr[i]-1)
                        pos--;
                    ans[pos]=ans[pos]+1;
                }
                for(j=0;j<=pos;j++){
                    if(j<pos)
                        sb.append(ans[j]).append(".");
                    else
                        sb.append(ans[j]).append("\n");
                }

            }
        }
        System.out.println(sb);
    }
}

class Node {
    int setroot, dist;
    public Node(int setroot, int dist){
        this.setroot = setroot;
        this.dist = dist;
    }
    @Override
    public String toString() {
        return String.format(setroot + ", " + dist);
    }
}

class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}
