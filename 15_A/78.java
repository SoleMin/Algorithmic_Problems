//~ 22:04:48
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String out = "";
		String[] p = br.readLine().split("[ ]");
		int n = Integer.valueOf(p[0]);
		double t = Double.valueOf(p[1]);
		
		int offset = 5000;
		boolean[] flags = new boolean[offset+5000];
		for(int i=0;i<n;i++){
			int[] q = toIntArray(br.readLine());
			int c = 2*q[0];
			for(int j=-q[1];j<q[1];j++){
				flags[c+offset+j] = true;
				//~ System.out.println(c+offset+j);
			}
		}
		int buf = 0;
		int last = -1;
		int index = 0;
		for(;index<flags.length;index++){
			if(flags[index]){
				if(last==-1){
					buf++;
				}else{
					//~ System.out.println(last);
					//~ System.out.println(index);
					if(Math.abs(index-last-(2*t+1))<1e-10) buf++;
					else if(index-last>2*t+1) buf+=2;
				}
				last = index;
			}
		}
		buf ++;
		out = ""+buf+"\r\n";
		bw.write(out,0,out.length());
		br.close();
		bw.close();
	}
	static int[] toIntArray(String line){
		String[] p = line.trim().split("\\s+");
		int[] out = new int[p.length];
		for(int i=0;i<out.length;i++) out[i] = Integer.valueOf(p[i]);
		return out;
	}
}
