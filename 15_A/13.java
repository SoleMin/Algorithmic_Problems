import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int t = sc.nextInt() * 2;
    H[] tbl = new H[n];
    for(int i = 0; i < n; i++)tbl[i] = new H(sc.nextInt()*2, sc.nextInt()*2);
    Arrays.sort(tbl);
    TreeSet<Integer> cand = new TreeSet<Integer>();
    //cand.add(tbl[0].x - tbl[0].len / 2);
    for(int i = 0; i < n; i++){
      int left = tbl[i].x - tbl[i].len / 2 - t / 2;
      if(!cand.contains(left)){
        if(i > 0 && tbl[i-1].x + tbl[i-1].len/2 > left - t/2){
          
        }else{
          cand.add(left);
        }
      }
      int right = tbl[i].x + tbl[i].len / 2 + t/2;
      if(!cand.contains(right)){
        if(i < n-1 && tbl[i+1].x - tbl[i+1].len/2 < right + t/2){
          
        }else{
          cand.add(right);
        }
      }
    }
    System.out.println(cand.size());
  }
  
  class H implements Comparable<H>{
    int x, len;
    H(int a, int b){
      x = a;
      len = b;
    }
    public int compareTo(H h){
      return this.x - h.x;
    }
  }
}
