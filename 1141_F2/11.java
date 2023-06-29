import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    
    static class Node implements Comparable<Node>{
        int sum;
        int l;
        int r;
        Node next;
        int nb;
        Node ini;
        boolean not;
        public Node(int sum,int l,int r){
            this.sum = sum;
            this.l = l;
            this.r = r;
            nb = 0;
            not = false;
            ini = null;
        }
        
        @Override
        public int compareTo(Node node){
            if(sum-node.sum!=0) return sum-node.sum;
            else if(l-node.l!=0) return l-node.l;
            else return r - node.r;
        }
    }
    
    public static void main(String[] args)throws IOException{
                
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        PrintWriter out = new PrintWriter(System.out);
        
        int n = Integer.parseInt(st.nextToken());
        
        TreeSet<Node> ts = new TreeSet<Node>();
        
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n+1];
        for(int i=1;i<=n;i++) a[i] = Integer.parseInt(st.nextToken());
        
        int[] s = new int[n+1];
        for(int i=1;i<=n;i++) s[i] = s[i-1] + a[i];
        
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                ts.add(new Node(s[j]-s[i-1],i,j));
            }
        }
        int minvalue = -2000*(int)Math.pow(10,5);
        int maxvalue = 2000*(int)Math.pow(10,5);
        ts.add(new Node(minvalue,0,0));
        ts.add(new Node(maxvalue,0,0));
        //System.out.println(minvalue);
        Node node = ts.higher(ts.first());
        
        int sum = 0;
        
        
        
        int max = 0;
        Node m = null;
        
        while(node.sum!=maxvalue){
            
            sum = node.sum;
            while(node.sum==sum){
                node = ts.higher(node);
            }
            
            Node var = ts.lower(node);
           // System.out.println(sum+" "+var.sum);
            max = 0;
            while(var.sum==sum){
                
                Node next = ts.higher(new Node(sum,var.r+1,0));
                
                if(max>1+next.nb){
                    var.nb = max;
                    var.ini = m;
                }
                else if(next.ini==null){
                
                    var.nb = 1 + next.nb;
                    var.next = next;
                    if(max<var.nb){
                        max = var.nb;
                        m = var;
                    }
                    
                    
                }else{
                    
                    var.nb = 1 + next.nb;
                    var.next = next.ini;
                    if(max<var.nb){
                        max = var.nb;
                        m = var;
                    }
                    
                }
                
            
                var = ts.lower(var);
                    
                //System.out.println(sum+" "+var.sum);
            }
            
            
        }
        
        int k = 0;
        Node best = new Node(minvalue,0,0);

        //var = new Node(minvalue,0,0);
        for(Node var:ts){
            if(k<var.nb){
                k = var.nb;
                best = var;
                if(var.ini!=null) best = var.ini;
            }
        }
        
        if(k==0) System.out.println("erreur");
        else{
            
            out.println(k);
            sum = best.sum;
            while(best.sum==sum){
                out.println(best.l+" "+best.r);
                best = best.next;
            }
            
        }
        
        
        out.flush();
        
    }
    
}