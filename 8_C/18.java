import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;


public class Order8C implements Runnable {
    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    int mintime;
    String path;

    int xs;
    int ys;
    int n;
    int[] obx;
    int[] oby;


    public static void main(String[] args) {
	new Thread(new Order8C()).start();
    }

    private void read() {
	xs = in.nextInt();
	ys = in.nextInt();
	n = in.nextInt();
	obx = new int[n];
	oby = new int[n];
	for(int i = 0; i<n; i++){
	    obx[i] = in.nextInt();
	    oby[i] = in.nextInt();
	}
	
    }

    private void solve() {
	/* we will do dynamic programming over the subsets
	   best[m] will be the shortest for binary digits of m
	   being in. 
	   last[m] will be the last subset before m */

	int[] ds = new int[n];
	int[][] d = new int[n][n];

	int[] best = new int[1 << n];
	int[] last = new int[1 << n];


	for(int i = 0; i<n; i++){
	    ds[i] = (obx[i]-xs)*(obx[i]-xs) + (oby[i]-ys)*(oby[i]-ys);
	    for(int j = i+1; j<n; j++){
		d[i][j] = (obx[i]-obx[j])*(obx[i]-obx[j]) + (oby[i]-oby[j])*(oby[i]-oby[j]);
		d[j][i] = (obx[i]-obx[j])*(obx[i]-obx[j]) + (oby[i]-oby[j])*(oby[i]-oby[j]);
	    }
	}


	for(int i=0; i< (1<<n); i++){ //goes through subsets before supersets
	    best[i] = 100000000;
	}
	best[0] = 0;

	for(int i=0; i< (1<<n); i++){ //goes through subsets before supersets
	    /*if (i % 1000000 == 0 ){
		System.out.println(i);
		}*/
	    for(int j = 0; j<n; j++){
		if( ((1 << j) & i) != 0){ // if 2^j and i have bitwise sum nonzero
		    if(best[i - (1<<j)] + 2*ds[j] < best[i]){
			best[i] = best[i - (1<<j)] + 2*ds[j];
			last[i] = i - (1<< j);

		    }
		   for(int k = j+1; k<n; k++){
		       if( ((1 << k) & i) != 0){ // if 2^k and i have bitwise sum nonzero
			   if( (best[i-(1<<j) -(1<<k)] +ds[j]+ds[k]+d[j][k]) < best[i]){
			       best[i] = (best[i-(1<<j) -(1<<k)] +ds[j]+ds[k]+d[j][k]);
			       last[i] = i -(1<<j) - (1<< k);

			   }

		       }
		   }
		   break; // break here because order doesn't really matter, just knowing which pairs to roup
		}
	    }
	}
	int i = (1<<n) -1;
	mintime = best[i];
	path = "";
	
	while(i >0){
	    //System.out.println("Got to i = " + i + " and path is: " + path);
	    path = path + "0 ";
	    int dif = i-last[i]; // this has one or two 1s in binary
	    for(int j=0; j<n; j++){
		if( ((1<<j) & dif) != 0){ // if dif has a 1 in the j'th digit
		    path  = path + (j+1) + " ";
		}
	    }
	    
	    i = last[i];
	}
	path = path + "0";
    }

    private void write() {
	out.println(mintime);
	out.println(path);
    }
    public void run() {
	read();
	solve();
	write();
	out.close();
    }
}
