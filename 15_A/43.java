import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class R015A {
    final double EPS = 1e-9;    
    boolean isEqual(double x, double y) {
        return Math.abs(x-y) <= EPS * Math.max(Math.abs(x), Math.abs(y));
    }
    class Pair implements Comparable<Pair>{
        double left;
        double right;
        Pair(double left, double right) {
            this.left = left;
            this.right = right;
        }
        public String toString() {
            return "(" + left + "," + right + ")";
        }
        public int hashCode() {
            return (int)(left * 17 + right * 31);
        }
        public boolean equals(Object o) {
            if(!(o instanceof Pair)) return false;
            Pair that = (Pair)o;
            return isEqual(this.left, that.left) && isEqual(this.right, that.right);
        }
        public int compareTo(Pair that) {
            if(this.left != that.left)
                return (int)(this.left - that.left);
            return (int)(this.right - that.right);
        }
    }
    public R015A() {
    }
    
    private void process() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] x = new int[n];
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            x[i] = scanner.nextInt();
            a[i] = scanner.nextInt();
        }
        List<Pair> pairs = new ArrayList<Pair>();
        for(int i=0; i<n; i++) {
            double left = x[i] - a[i] / 2.0;
            double right= x[i] + a[i] / 2.0;
            pairs.add(new Pair(left, right));
        }
        Collections.sort(pairs);
        Set<Pair> newPairs = new HashSet<Pair>();
        newPairs.add(new Pair(pairs.get(0).left - t, pairs.get(0).left));
        for(int i=0; i<pairs.size()-1; i++) {
            if(pairs.get(i+1).left - pairs.get(i).right >= t) {
                newPairs.add(new Pair(pairs.get(i).right, pairs.get(i).right + t));
                newPairs.add(new Pair(pairs.get(i+1).left - t, pairs.get(i+1).left));
            }
        }
        newPairs.add(new Pair(pairs.get(pairs.size()-1).right, pairs.get(pairs.size()-1).right + t));
        System.out.println(newPairs.size());
    }
    
    public static void main(String[] args) {
        new R015A().process();
    }
}
