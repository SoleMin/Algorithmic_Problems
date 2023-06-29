import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        public int l,r;
        public long s;
        Node(int l,int r,long s){
            this.l=l;
            this.r=r;
            this.s=s;
        }
        public int compareTo(Node o) {
            if(o.s==s){
                if(r>o.r) return 1;
                else if(r==o.r) {
                    return 0;
                }
                else return -1;
            } else if(s>o.s){
                return 1;
            } else {
                return -1;
            }
        }
    }
    static long[] sum=new long[1550];
    public static void main(String[] args) {
        TreeMap<Long, ArrayList<Node> > mp = new TreeMap<>();
        Scanner cin = new Scanner(System.in);
        int N=cin.nextInt();
        for(int i=1;i<=N;i++){
            int x=cin.nextInt();
            sum[i]=sum[i-1]+x;
        }
        //System.out.println("here");
        ArrayList<Node> arr = new ArrayList<>();
        for(int l=1;l<=N;l++){
            for(int r=l;r<=N;r++){
                arr.add(new Node(l,r,sum[r]-sum[l-1]));
            }
        }
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++){
            ArrayList<Node> a=mp.get(arr.get(i).s);
            if(a==null) {
                a=new ArrayList<>();
                mp.put(arr.get(i).s,a);
            }
            a.add(arr.get(i));
        }
        int mx=-1;
        long mxv=-1;
        Iterator<Long> it=mp.keySet().iterator();
        while(it.hasNext()){
            int ans=0,t=0;
            long v=it.next();
            ArrayList<Node> vec= mp.get(v);
            for(int i=0;i<vec.size();i++){
                if(t<vec.get(i).l){
                    ans++;
                    t=vec.get(i).r;
                }
            }
           //
            if(ans>mx){
                mx=ans;
                mxv=v;
               // System.out.println(mxv);
            }
        }
        ArrayList<Node> vec=mp.get(mxv);
        System.out.println(mx);
        int t=0;
        for(int i=0;i<vec.size();i++){

           // System.out.println(vec.get(i).l+" "+vec.get(i).r);
          // System.out.println("h");
            if(t<vec.get(i).l){
                System.out.println(vec.get(i).l+" "+vec.get(i).r);
                t=vec.get(i).r;
            }
        }
    }
}
