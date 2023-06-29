import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
class Main {
	static class dis implements Comparable<dis>{
        int u;
        int v;
        double w;
        public dis(int st, int end, double we){
            this.u = st;
            this.v = end;
            this.w = we;
        }
        @Override
        public int compareTo(dis o) {
            if(w > o.w)
                return -1;
            else
                return 1;
        }
    }
    static int [] map;
    static int findSet(int i){
        return (map[i] == i) ? i : (map[i] = findSet(map[i]));
    }
    static void unionSet(int i, int j){
        map[findSet(i)] = map[findSet(j)];
    }
    static boolean isSameSet(int i, int j){
        return findSet(i) == findSet(j); 
    }
    private static void initSet(int _size) { 
        map = new int[_size]; 
        for (int i = 0; i < _size; i++) {
        	map[i] = i; 
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        PriorityQueue<dis> List = new PriorityQueue<dis>();
        int t = input.nextInt();
        int n,counter = 0;
        double [][] dist;
        double currLen,yDiff,xDiff,min;
        for (int i = 0; i < t; i++) {
            min = 0;
            n = input.nextInt();
            if(counter++ != 0) {
                System.out.println();
            }
            initSet(n);
            dist = new double[n][2];
            for (int j = 0; j < n; j++) {
                dist[j][0] = input.nextDouble();
                dist[j][1] = input.nextDouble();
            }
            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    xDiff = dist[j][0] - dist[k][0];
                    yDiff = dist[j][1] - dist[k][1];
                    currLen = Math.sqrt(yDiff*yDiff + xDiff*xDiff);
                    dis e = new dis(j, k, - currLen);
                    List.add(e);
                }
            }
            while(!List.isEmpty()){
                dis e = List.poll();
                if(!isSameSet(e.u, e.v)){
                    min += -e.w;
                    unionSet(e.u, e.v);
                }
            }
            System.out.printf("%.2f\n", min);
        }
    }
}