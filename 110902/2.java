import java.io.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	private static class Data {
		int [] v;
		int move;
		public Data (int a, int b, int c, int d, int move) {
			this.v=new int [] {a,b,c,d};
			this.move=move; 
		}
		public Data(Data d) {
			this.v=Arrays.copyOf(d.v, d.v.length);
			this.move=d.move;
		}
		public int toNum() {return v[0]*1000+v[1]*100+v[2]*10+v[3];}

	}
	public static void main (String [] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int [] deltas=new int [] {-1,1};
		for (int a=0;a<t;a++) {
			Data start=new Data(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),0);
			Data end=new Data(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),0);
			
			int [] m=new int [10000];
			
			int F=sc.nextInt();
			for (int f=0;f<F;f++) 
				m[new Data(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),0).toNum()]=2;
			
			LinkedList<Data> queue=new LinkedList<>();
			queue.add(start);
			m[start.toNum()]=1;
			int step=-1;
			while (!queue.isEmpty()) {
				Data curr=queue.removeFirst();
				if (curr.toNum()==end.toNum()) {
					step=curr.move;
					break;
				} else {
					for (int i=0;i<4;i++) for (int delta : deltas) {
						Data next=new Data(curr);
						next.v[i]=Math.floorMod(next.v[i]+delta,10);
						next.move++;
						if (m[next.toNum()]==0) {
							queue.addLast(next);
							m[next.toNum()]=1;
						}
					}
				}
			}
			
			System.out.println(step);
		}
	}

}