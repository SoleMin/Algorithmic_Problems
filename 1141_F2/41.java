import java.io.PrintWriter;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);

        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }

        HashMap<Integer,ArrayList<Node>> h=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            int sum=0;
            for (int j = i; j <n ; j++) {
                sum+=a[j];
                if(h.containsKey(sum)){
                    h.get(sum).add(new Node(i,j));
                }
                else{
                    ArrayList<Node> temp=new ArrayList<>();
                    temp.add(new Node(i,j));
                    h.put(sum,temp);
                }
            }
        }

        long ans=0;
        ArrayList<Integer> ansList=new ArrayList<>();

        for(int x:h.keySet()){
            Collections.sort(h.get(x), new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.r,o2.r);
                }
            });


            ArrayList<Node>  l=h.get(x);
            //out.println(l);
            ArrayList<Integer> temp=new ArrayList<>();
            int lasty=Integer.MIN_VALUE;
            for (int i = 0; i <l.size() ; i++) {
                if(l.get(i).l>lasty){
                    lasty=l.get(i).r;
                    temp.add(l.get(i).l);
                    temp.add(l.get(i).r);
                }
            }

            if(ans<temp.size()){
                ansList=temp;
                ans=ansList.size();
            }
        }

        out.println(ans/2);
        for (int i = 0; i <ansList.size() ; i++) {
            out.print((ansList.get(i)+1)+" ");
            i++;
            out.println((ansList.get(i)+1)+" ");
        }



        out.close();
    }

    static class Node{
        int l,r;
        public Node(int a,int b){
            l=a;
            r=b;
        }
    }

}