import java.io.*;
import java.util.*;

class Main {
	static Map<String, Integer> erdo = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int scen = sc.nextInt();
		
		for (int l = 0; l < scen; l++) {
			Map<String, ArrayList> withW = new HashMap<>();
			
			int n = sc.nextInt();
			int p = sc.nextInt();
			sc.nextLine();
				
			for (int k = 0; k < n; k++) {
				String line = sc.nextLine();
				int col = line.indexOf(":");
				line = line.substring(0, col);
				String [] tmp = line.split(",");
				String [] tmp2 = new String[tmp.length / 2];
				for (int i = 0; i < tmp.length ; i++)
					if (i % 2 == 0) {
						tmp2[i/2] = tmp[i] + "," + tmp[i+1];
						tmp2[i/2] = tmp2[i/2].trim();
					}
				ArrayList<String> names = new ArrayList<>(Arrays.asList(tmp2));
				ArrayList<String> tmpAL = new ArrayList<>();
				
				for (int i = 0; i < tmp2.length; i++) {
					if(!withW.containsKey(names.get(i))) {
						withW.put(names.get(i), new ArrayList());
						for (int j = 0; j < tmp2.length; j++) {
							if (!names.get(i).equals(names.get(j)) && !withW.get(names.get(i)).contains(names.get(j))) {
								withW.get(names.get(i)).add(names.get(j));
							}
						}
					} else {
						for (int j = 0; j < tmp2.length; j++)
							if (!names.get(i).equals(names.get(j)) && !withW.get(names.get(i)).contains(names.get(j))) {
								withW.get(names.get(i)).add(names.get(j));
							}
					}
				}
			}
			String name = "Erdos, P.";
			int cnt = 0;
			if (withW.containsKey(name))
				fillName(withW, name, cnt);
			
			System.out.println("Scenario " + (l+1));
			for (int i = 0; i < p; i++) {
				String findName = sc.nextLine();
				if (erdo.containsKey(findName)) {
					System.out.println(findName + " " + erdo.get(findName));
				}
				else
					System.out.println(findName + " infinity");
			}
			erdo.clear();
		}
	}
	
	
	public static void fillName (Map <String, ArrayList> withW, String name, int cnt) {
		erdo.put(name, cnt);
		cnt++;
		for(int i = 0; i < withW.get(name).size(); i++) {
			if (!erdo.containsKey(withW.get(name).get(i)))
				fillName(withW, (String)withW.get(name).get(i), cnt);
			else {
				if (erdo.get(withW.get(name).get(i)) > cnt) {
					erdo.replace((String)withW.get(name).get(i), cnt);
				}
			}
			
		}
		return;
	}
}