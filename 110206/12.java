import java.io.*;
import java.util.*;
class Main {
	
	static int erdosIndex = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf;
		String bufs[];
		int testcase = Integer.parseInt(br.readLine());
		int papers, peoples;
		
		for(int t=0; t<testcase; t++){
			buf = br.readLine();
			bufs = buf.split(" ");
			papers = Integer.parseInt(bufs[0]);
			peoples = Integer.parseInt(bufs[1]);
			Set<String> paper;
			Set<String> erdosFam = new HashSet<>();
			ArrayList<Set> paper_list = new ArrayList<>();
			ArrayList<Set> hierarchy = new ArrayList<>();
			String name;
			for(int i=0; i<papers; i++){
				paper = new HashSet<>();
				bufs = br.readLine().split(":");
				bufs = bufs[0].split(", ");
				for(int j=0; j<bufs.length; j+=2){
					name = bufs[j] + ", " + bufs[j+1];
					paper.add(name);
				}
				if(paper.contains("Erdos, P.")){
					erdosFam.addAll(paper);
				}
				else{
					paper_list.add(paper);
				}
			}
			hierarchy.add(erdosFam);
			for(int i=0; i<hierarchy.size(); i++){
				Set<String> setBuf = new HashSet<>();
				Set<String> retain;
				for(int j=0; j<paper_list.size(); j++){
					retain = new HashSet<>(hierarchy.get(i));
					retain.retainAll(paper_list.get(j));
					if(retain.size() != 0){
						setBuf.addAll(paper_list.get(j));
						paper_list.remove(j--);
						setBuf.removeAll(retain);
					}
				}
				if(setBuf.size() != 0)
					hierarchy.add(setBuf);
			}

			boolean print;
			System.out.println("Scenario " + Integer.toString(t+1));
			for(int i=0; i<peoples; i++){
				print = false;
				String test = br.readLine();
				if(test.compareTo("Erdos, P.") == 0){
					System.out.println(test + " 0");
					continue;
				}
				for(int j=0; j<hierarchy.size(); j++){
					if(hierarchy.get(j).contains(test)){
						System.out.println(test+" "+Integer.toString(j+1));
						print = true;
						break;
					}
				}
				if(print == false){
					System.out.println(test + " infinity");
				}
			}
		}
	}
}