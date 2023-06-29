/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Round547;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Hemant Dhanuka
 */
public class F1 {
    
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
    
    
    public static void main(String[] args) throws IOException {
  //    Scanner s=new Scanner(System.in);
     Reader s=new Reader();
    int n=s.nextInt();
        
        int a[]=new int[n];
        
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        
        Map<Long,PriorityQueue<Node>> map=new HashMap();
        
        for(int i=0;i<n;i++){
            long sum=0;
            for(int j=i;j<n;j++){
                sum=sum+a[j];
                PriorityQueue<Node> pq=map.get(sum);
                if(pq==null){
                    pq=new PriorityQueue();
                    map.put(sum, pq);
                }
                pq.add(new Node(i,j));
            }
            
            
        }
        
        
        Set<Long> keys=map.keySet();
        
        Iterator<Long> itr=keys.iterator();
        int max=0;
        int solbackDp[]=null;
        Node solA[]=new Node[0];
        while(itr.hasNext()){
           Long sum=itr.next();
           PriorityQueue<Node> pq1=map.get(sum);
           
           
           
           
           
           
           //Node rangelist[]=new  Node[pq1.size()+1];
            ArrayList<Node> rangelist=new ArrayList<>();
            rangelist.add(new Node(-1, -1));
            //int count=1;
            //rangelist[0]=new Node(-1,-1);
             Node last=rangelist.get(0);
            while(!pq1.isEmpty()){
                Node n1=pq1.poll();
                if(n1.l!=last.l){
                    rangelist.add(n1);
                    last=n1;
                } 
                       
           }
           int backTrack[]=new int[rangelist.size()];
           int dp[]=new int[rangelist.size()];
           Arrays.fill(dp, -1);
           int ans=fun(0,dp,rangelist,backTrack);
           if(ans>max){
               max=ans;
               solA=rangelist.toArray(solA);
               solbackDp=backTrack;
           }
        }
        
        System.out.println(max);
        
        
        int pos=0;
        while(solbackDp[pos]!=-1){
            pos=solbackDp[pos];
            System.out.println((solA[pos].l+1)+" "+(solA[pos].r+1));
        }
    }
    
    
    static int fun(int pos, int[] dp, ArrayList<Node> rangeList, int[] bactTrack){
        
        if(pos==rangeList.size()-1){
            bactTrack[pos]=-1;
            return 0;
          
        }
        
        if(dp[pos]!=-1){
            return dp[pos];
        }
        
        int i=pos+1;
        int maxAns=0;
        int nextPos=-1;
        for(;i<=rangeList.size()-1;i++){
            
            
            if(rangeList.get(i).l>rangeList.get(pos).r){
                int tempAns=1+fun(i, dp,rangeList, bactTrack);
                if(tempAns>maxAns){
                    maxAns=tempAns;
                    nextPos=i;
                }
            }
        }
        
        dp[pos]=maxAns;
        bactTrack[pos]=nextPos;
        return maxAns;
        
        
        
        
    }
    
    static class Node implements Comparable<Node>{
        int l;
        int r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
        
        
        
       
        @Override
        public int compareTo(Node o2) {
            if(this.l!=o2.l){
                return this.l-o2.l;
            } else{
                return this.r-o2.r;
            }
        }
        
    }
}
