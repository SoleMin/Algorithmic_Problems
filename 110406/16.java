import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		
		for(int i = 0; i < testcase; i++) {
			List<List<String>> info_list = new LinkedList<>();
			String[] hours_p = sc.nextLine().split(" ");
			Map<String,Integer> names = new TreeMap<>(Comparator.naturalOrder());
			
			while(sc.hasNextLine()) {
				String infos = sc.nextLine();
				if(infos.equals("")) 
					break;
				String[] info = infos.split(" ");
				if(names.containsKey(info[0])) {
					names.put(info[0],names.get(info[0]) + 1);
				}
				else {
					names.put(info[0],1);
				}
				info_list.add(Arrays.asList(info));		
			}
			info_list.sort(new Comparator<>() {
				public int compare(List<String> a, List<String> b) {
					if(a.get(0).equals(b.get(0))) {
						return a.get(1).compareTo(b.get(1));
					}
					return a.get(0).compareTo(b.get(0));
				}
			});
			Map<String,Double> charge = new HashMap<>();
			
			int idx = 0;
			for(Map.Entry<String,Integer> entry : names.entrySet()) {
				boolean isContains = false;
				boolean correct = false;
				for(int k = 0; k < entry.getValue(); k++) {
					String orientation = info_list.get(idx).get(2);
					if(correct && orientation.equals("exit")) {
						List<String> infor = info_list.get(idx-1);
						int hour = Integer.parseInt(infor.get(1).substring(6,8));
						int km = Math.abs(Integer.parseInt(infor.get(3)) - 
											Integer.parseInt(info_list.get(idx).get(3)));
						int p = Integer.parseInt(hours_p[hour]);
						
						double money = (p * km)/100.0 + 1;
						if(!isContains) {
							charge.put(entry.getKey(),money + 2); 
							isContains = true;
						}
						else {
							String name = entry.getKey();
							charge.put(name,charge.get(name) + money);
						}
						correct = false;
					}
					else {
						if(orientation.equals("enter"))
							correct = true;
					}
					idx += 1;
				}
			}
			
			for(Map.Entry<String,Double> entry : charge.entrySet()) {
				System.out.printf("%s $%.2f\n",entry.getKey(),entry.getValue());
			}
			System.out.println();
		}
		
	}
}