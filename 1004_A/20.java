import javafx.collections.transformation.SortedList;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scan scan = new Scan();
        int n = scan.scanInt();
        long d = scan.scanLong();
        long a[]=new long[n];
        for(int i=0;i<n;i++){
            a[i]=scan.scanLong();
        }
        Arrays.sort(a);
        int count=0;
        for(int i=0;i<n-1;i++){
            if((a[i+1]-d)>(a[i]+d)){
                count+=2;
            }else if((a[i+1]-d)==(a[i]+d)){
                count++;
            }
        }
        count+=2;
        System.out.println(count);
    }



    static class Scan
    {

        private byte[] buf=new byte[1024];
        private int index;
        private InputStream in;
        private int total;

        public Scan()
        {
            in=System.in;
        }

        public int scan()throws IOException
        {
            if(total<0)
                throw new InputMismatchException();
            if(index>=total)
            {
                index=0;
                total=in.read(buf);
                if(total<=0)
                    return -1;
            }
            return buf[index++];
        }
        public int scanInt()throws IOException
        {
            int integer=0;
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            int neg=1;
            if(n=='-')
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n))
            {
                if(n>='0'&&n<='9')
                {
                    integer*=10;
                    integer+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            return neg*integer;
        }


        public char scanchar()throws IOException
        {
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            return (char)n;
//            int neg=1;
//            while(!isWhiteSpace(n))
//            {
//                if(n>='0'&&n<='9')
//                {
//                    integer*=10;
//                    integer+=n-'0';
//                    n=scan();
//                }
//                else throw new InputMismatchException();
//            }
//            return neg*integer;
        }

        public long scanLong()throws IOException
        {
            long lng=0;
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            int neg=1;
            if(n=='-')
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n) && n!='.')
            {
                if(n>='0'&&n<='9')
                {
                    lng*=10;
                    lng+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            if(n=='.')
            {
                n=scan();
                long temp=1;
                while(!isWhiteSpace(n))
                {
                    if(n>='0'&&n<='9')
                    {
                        temp/=10;
                        lng+=(n-'0')*temp;
                        n=scan();
                    }
                    else throw new InputMismatchException();
                }
            }
            return neg*lng;
        }
        public double scanDouble()throws IOException
        {
            double doub=0;
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            int neg=1;
            if(n=='-')
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n)&&n!='.')
            {
                if(n>='0'&&n<='9')
                {
                    doub*=10;
                    doub+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            if(n=='.')
            {
                n=scan();
                double temp=1;
                while(!isWhiteSpace(n))
                {
                    if(n>='0'&&n<='9')
                    {
                        temp/=10;
                        doub+=(n-'0')*temp;
                        n=scan();
                    }
                    else throw new InputMismatchException();
                }
            }
            return doub*neg;
        }
        public String scanString()throws IOException
        {
            StringBuilder sb=new StringBuilder();
            int n=scan();
            while(isWhiteSpace(n))
                n=scan();
            while(!isWhiteSpace(n))
            {
                sb.append((char)n);
                n=scan();
            }
            return sb.toString();
        }
        private boolean isWhiteSpace(int n)
        {
            if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
                return true;
            return false;
        }
    }

}