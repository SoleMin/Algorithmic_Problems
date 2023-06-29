import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Set<Set<String>> names_set = new HashSet<>();
		Set<String> names = new HashSet<>();
		Map<String,Integer> erdos_n = new HashMap<>();
		
		int rep = sc.nextInt();
		
		
		for(int i = 1; i <= rep; i++) {
			erdos_n.clear();
			names_set.clear();
			sc.useDelimiter("\\s");
			int p = sc.nextInt();
			int n = sc.nextInt();
			sc.skip("\n");
			
			sc.useDelimiter("(\\., |\\.:|\\n)");
			
			for(int report_c = 1; report_c <= p; report_c++) {
				while(true) {
					String name = sc.next();
					if(name.charAt(0) == ' ')
						break;
					names.add(name.concat("."));
				}
				names_set.add(new HashSet(names));
				names.clear();
			}
			System.out.printf("Scenario %d\n",i);
			
			for(Iterator<Set<String>> temp_names = names_set.iterator(); temp_names.hasNext();) {
				Set<String> tem = temp_names.next();
				if(tem.contains("Erdos, P.")) {
					for(Iterator<String> name = tem.iterator(); name.hasNext();) {
						String nam = name.next();
						if(!nam.equals("Erdos, P.")) {
							erdos_n.put(nam,Integer.valueOf(1));
						}
					}
					temp_names.remove();
				}
			}
			erdos_n.put("Erods, P.",Integer.valueOf(1));
			
			int max = names_set.size();
			for(int value = 1; value <= max; value++) {
				for(Iterator<Set<String>> temp_names = names_set.iterator(); temp_names.hasNext();) {
					boolean isContainsValue = false;
					Set<String> tem = temp_names.next();
					String key = null;
					for(Iterator<String> name = tem.iterator(); name.hasNext();) {
						String tem_s = name.next();
						if(erdos_n.containsKey(tem_s) && erdos_n.get(tem_s) == value) {
							key = tem_s;
							isContainsValue = true;
							break;
						}
					}
					if(isContainsValue) {
						for(Iterator<String> name = tem.iterator(); name.hasNext();) {
							String nam = name.next();
							if(!nam.equals(key) && !erdos_n.containsKey(nam)) {
								erdos_n.put(nam,Integer.valueOf(erdos_n.get(key).intValue() + 1));
							}
						}
						temp_names.remove();
					}
					
				}
				
			}
			
			
			

			for ( int name_c = 1; name_c <= n; name_c++ ) {
				
				String name = sc.next();
				if(erdos_n.containsKey(name)) {
					System.out.printf("%s %d\n",name,erdos_n.get(name).intValue());
				}
				else {
					System.out.printf("%s infinity\n",name);
				}
				
			}
			sc.nextLine();
		}
	}
}