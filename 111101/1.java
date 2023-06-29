import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {

	static List<Elephant> e;
	static int index=1, maxCnt=0;
	static boolean[] visit;
	static Map<Integer, String> ar= new TreeMap<Integer, String>();

	public static class Elephant{
		private int weight;
		private int IQ;
		int index;

		public Elephant(int weight, int IQ, int index) {
			this.weight=weight;
			this.IQ =IQ;
			this.index =index;
		}
		public Integer getWeight() {
			return weight;
		}
		public Integer getIQ() {
			return IQ;
		}
		public Integer getIndex() {
			return index;
		}
		public String toString() {
			return "index:"+index+" weight:"+weight+" iq:"+IQ;
		}
	}
	public static void main(String[] args) {
		e = new ArrayList<>();
		Scanner input = new Scanner (System.in);

		while(input.hasNext()) {
			int weight = input.nextInt();
			int IQ=input.nextInt(); 
			Elephant elephant = new Elephant(weight, IQ, index++);
			e.add(elephant);
		}

		visit= new boolean[index-1];

		e.sort(Comparator.comparing(Elephant::getIQ).reversed().thenComparing(Elephant::getWeight));


		sol(0, 0, 0, 0, "");

		System.out.println(maxCnt);


		for(Integer n: ar.keySet()) {
			System.out.println(ar.get(n));
			break;
		}

		input.close();
	}

	public static void sol(int start, int cnt, int we, int iq, String s) {
		for(int i=start; i<index-1; i++) {
			int nextWe=e.get(i).weight;
			int nextIq=e.get(i).IQ;
			if(!visit[i] && (nextWe>we) && (nextIq!=iq)) {
				visit[i]=true;
				sol(i, cnt+1, nextWe, nextIq, s+e.get(i).index+"\n");
				visit[i]=false;
			}
		}

		if(maxCnt<cnt) {
			maxCnt=cnt;
			ar= new TreeMap<Integer, String>();
		}

		if(maxCnt==cnt) {
			int n=0;
			String[] ss= s.split("\n");
			for(int i=0; i<ss.length; i++) {
				n+= Integer.parseInt(ss[i]) << 4*(ss.length-1-i);
			}
			ar.put(n, s);
		}
	}

}
