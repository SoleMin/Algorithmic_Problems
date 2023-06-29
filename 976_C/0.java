import java.util.*;
public class Nested{
    public static void main(String args[]){
        Scanner ob = new Scanner(System.in);
        int n = ob.nextInt();
        Triplet [] a = new Triplet[n];
        
        for(int i = 0; i < n; i++){
            int l = ob.nextInt();
            int r = ob.nextInt();
            a[i] = new Triplet(l, r, i + 1);
        }
        Arrays.sort(a);
        /*
        for(int i = 0; i < n; i++)
            System.out.println(a[i].l + " " + a[i].r + " " + a[i].idx);*/
            
        int flag = -1, m = 0, idx = -1, pos = -1;
        
        for(int i = 0; i < n; i++){
            if(a[i].l > m){
                m = a[i].l; idx = a[i].idx;
            }
            else{
                flag = 1;
                pos = a[i].idx;
                break;
            }
        }
        
        if(flag == -1) System.out.println(-1 +" "+ -1);
        else System.out.println(idx+ " " +pos);
    }
    
    static class Triplet implements Comparable<Triplet>{
        int l, r, idx;
        Triplet(int a, int b, int c){
            l = a; r = b; idx = c;
        }
        
        public int compareTo(Triplet t){
            if(this.r - t.r != 0) return this.r - t.r;
            else return t.l - this.l;
        } 
    }
}

