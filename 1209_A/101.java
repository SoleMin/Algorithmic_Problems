import static java.lang.Math.*;
import static java.util.Arrays.* ;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class D
{
    int [][] adjList ;
    int dfs(int u , int p )
    {
        int size = 1 ;
        for(int v : adjList[u])
            if(v != p )
            {
                int curr = dfs(v,  u) ;
                size += curr ;
            }
        return size ;
    }

    void main() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt() ;
        int [] a = new int [n] ;
        boolean [] vis = new boolean[n] ;
        int cnt = 0 ;
        for(int i = 0 ;i < n ; i++)
            a[i] = sc.nextInt() ;
        sort(a);
        for(int i = 0 ;i  < n ; i ++)
        {
            if(!vis[i])
            {
                for(int j= i  ; j < n ; j++)
                    if(a[j] % a[i] == 0)
                        vis[j] = true ;

                cnt ++ ;
            }
        }

        out.println(cnt);
        out.flush();
        out.close();
    }

    class SegmentTree
    {
        int [] sTree ;
        int [] lazy ;
        int N ;

        SegmentTree(int n)
        {
            N = 1 << (32 - Integer.numberOfLeadingZeros(n - 1)) ;
            sTree = new int [N << 1] ;
            lazy= new int [N << 1] ;
        }
        void push(int node , int b , int e , int mid)
        {
            sTree[node << 1] += (mid - b + 1) * lazy[node] ;
            sTree[node << 1 | 1] += (e - mid) * lazy[node] ;
            lazy[node << 1] += lazy[node] ;
            lazy[node << 1 | 1] += lazy[node] ;
            lazy[node] = 0 ;
        }
        void updateRange(int node , int b , int e , int i , int j , int val)
        {
            if(i > e || j < b)return;

            if(i <= b && e <= j)
            {
                sTree[node] += (e - b + 1) * val ;
                lazy[node] += val ;
                return;
            }

            int mid = b + e >> 1 ;
            push(node , b , e , mid) ;
            updateRange(node << 1 , b , mid , i , j , val);
            updateRange(node << 1 | 1 , mid + 1 , e , i , j , val);
            sTree[node] = sTree[node << 1] + sTree[node << 1 | 1] ;
        }
        int query(int node , int b , int e , int i , int j)
        {
            if(i > e || j < b)
                return 0 ;
            if(i <= b && e <= j)
                return sTree[node] ;
            int mid = b + e >> 1 ;
            push(node  , b , e , mid);
            return query(node << 1 , b , mid , i , j) + query(node << 1 | 1 , mid + 1 , e , i , j) ;
        }

    }
    class Compressor
    {
        TreeSet<Integer> set = new TreeSet<>() ;
        TreeMap<Integer ,Integer> map = new TreeMap<>()  ;

        void add(int x)
        {
            set.add(x) ;
        }
        void fix()
        {
            for(int x : set)
                map.put(x , map.size() + 1) ;
        }
        int get(int x)
        {
            return map.get(x) ;
        }
    }
    class Scanner
    {
        BufferedReader br ;
        StringTokenizer st ;

        Scanner(InputStream in)
        {
            br = new BufferedReader(new InputStreamReader(in)) ;
        }
        String next() throws Exception
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine()) ;
            return st.nextToken() ;
        }
        int nextInt() throws Exception
        {
            return Integer.parseInt(next()) ;
        }
        long nextLong() throws Exception
        {
            return Long.parseLong(next()) ;
        }
        double nextDouble() throws Exception
        {
            return Double.parseDouble(next()) ;
        }
    }

    public static void main (String [] args) throws Exception {(new D()).main();}

}