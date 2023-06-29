    import java.io.*;
    import java.util.*;
    import java.math.*;
    import java.lang.*;
     
     //@Manan Parmar

    public class Solution2 implements Runnable {


        public void run() {
            
            InputReader sc = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            
            int n=sc.nextInt();
            out.println((n/2)+1);

            out.close();
        }
     

    //========================================================================
        void quickSort(int a[],int l,int r)
        {
            if(l<r)
            {
                int pindex=partition(a,l,r);
                quickSort(a,l,pindex-1);
                quickSort(a,pindex+1,r);
            }

        }
        int partition(int a[],int l,int r)
        {
            int pivot = a[r],pindex=l;
            for(int i=l;i<r;i++)
            {
                if(a[i]<pivot)
                {
                    int temp=a[i];
                    a[i]=a[pindex];
                    a[pindex]=temp;
                    pindex++;
                }
            }
            int temp1=a[r];
            a[r]=a[pindex];
            a[pindex]=temp1;
            return pindex;
        }
        int binarySearch(int arr[], int x) 
        { 
            int l = 0, r = arr.length - 1; 
            while (l <= r) { 
                int m = l + (r - l) / 2; 
      
                // Check if x is present at mid 
                if (arr[m] >= x)
                    if(m!=0&&arr[m-1]<x) 
                        return m;
                    else if(m==0)
                        return m; 
      
                // If x greater, ignore left half 
                if (arr[m] < x) 
                    l = m + 1; 
      
                // If x is smaller, ignore right half 
                else
                    r = m - 1; 
            } 
      
            // if we reach here, then element was 
            // not present 
            return -1; 
        } 
        boolean check(char a,char b)
        {
            if(a==b)
                return true;
            else
                return false;
        }
        long binarySearch(long arr[], long x) 
        { 
            int l = 0, r = arr.length - 1,q=0; 
            while (l<=r) { 
                int m = l + (r - l) / 2; 
                if (arr[l] >=x) 
                {
                    q=1;
                    return l; 
                }
                if (arr[m] < x) 
                    l=m+1; 
                else
                    r=m;
            } 
            return -1;
        }

        static class InputReader {
            private InputStream stream;
            private byte[] buf = new byte[1024];
            private int curChar;
            private int numChars;
            private SpaceCharFilter filter;
            private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
            public InputReader(InputStream stream) {
                this.stream = stream;
            }
           
            public int read() {
                if (numChars==-1)
                    throw new InputMismatchException();
               
                if (curChar >= numChars) {
                    curChar = 0;
                    try {
                        numChars = stream.read(buf);
                    }
                    catch (IOException e) {
                        throw new InputMismatchException();
                    }
                   
                    if(numChars <= 0)              
                        return -1;
                }
                return buf[curChar++];
            }
         
            public String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
            public int nextInt() {
                int c = read();
               
                while(isSpaceChar(c))
                    c = read();
               
                int sgn = 1;
               
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
               
                int res = 0;
                do {
                    if(c<'0'||c>'9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = read();
                }
                while (!isSpaceChar(c));
               
                return res * sgn;
            }
           
            public long nextLong() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                long res = 0;
               
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = read();
                }
                while (!isSpaceChar(c));
                    return res * sgn;
            }
           
            public double nextDouble() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                double res = 0;
                while (!isSpaceChar(c) && c != '.') {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = read();
                }
                if (c == '.') {
                    c = read();
                    double m = 1;
                    while (!isSpaceChar(c)) {
                        if (c == 'e' || c == 'E')
                            return res * Math.pow(10, nextInt());
                        if (c < '0' || c > '9')
                            throw new InputMismatchException();
                        m /= 10;
                        res += (c - '0') * m;
                        c = read();
                    }
                }
                return res * sgn;
            }
           
            public String readString() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = read();
                }
                while (!isSpaceChar(c));
               
                return res.toString();
            }
         
            public boolean isSpaceChar(int c) {
                if (filter != null)
                    return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }
         
            public String next() {
                return readString();
            }
           
            public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
            }
        }

        public static void main(String args[]) throws Exception {
            new Thread(null, new Solution2(),"Main",1<<27).start();
        }
    }
