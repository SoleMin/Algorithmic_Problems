import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testCase = input.nextInt();
		for(int i = 1; i <= testCase; i++){
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int researchNum = input.nextInt();
			int peopleNum = input.nextInt();
			input.nextLine();
			
			String[] research = new String[researchNum];
			String[] people = new String[peopleNum];
			int index, curr, l;
			
			for(int j = 0; j < researchNum; j++){
				ArrayList<String> list = new ArrayList<String>();
				l = 0;
				index = 0;
				curr = 0;
				String[] strStore = new String[10];
				
				research[j] = input.nextLine();
				String[] researSplit = research[j].split(":");
				int len = researSplit[0].length();
				boolean isTrue = false;
				
				for(int k = 0; k < len; k++){
					if(k == len - 1){
						strStore[index] = researSplit[0].substring(curr, len).trim();
						isTrue = true;
					}
					if(researSplit[0].charAt(k) == ',' || isTrue){
						l++;
						if(l == 2 || isTrue){
							if(!isTrue)
								strStore[index] = researSplit[0].substring(curr, k).trim();
							if(!map.containsKey(strStore[index])){
								if(strStore[index].equals("Erdos, P."))
									map.put(strStore[index], 0);
								else
									map.put(strStore[index], Integer.MAX_VALUE);
							}
							l = 0;
							index++;
							curr = k + 1;
						}
					}
				}
				boolean isBreak = false;
				boolean isPut = false;
				String s = null;
				for(int k = 0; k < index; k++)
					list.add(strStore[k]);
				for(int k = 0; k < index; k++){
					if(list.contains("Erdos, P.")){
						if(!list.get(k).equals("Erdos, P."))
							map.put(list.get(k), 1);
					}
					else{
						for(int m = 0; m < index; m++){
							if(map.get(list.get(m)) != Integer.MAX_VALUE){
								if(list.get(m).equals(getKey(map, map.get(list.get(m)))))
									s = list.get(m);
							}
							else{
								for(int n = 0; n < index; n++){
									if(map.get(list.get(n)) != Integer.MAX_VALUE)
										isPut = true;
								}
								if(isPut){
									if(s != null)
										map.put(list.get(m), map.get(s) + 1);
								}
								else{
									isBreak = true;
									break;
								}
							}
						}
						if(isBreak)
							break;
					}
					isBreak = false;
					isPut = false;
				}
			}
			for(int j = 0; j < peopleNum; j++)
				people[j] = input.nextLine();
			System.out.println("Scenario " + i);
			for(int k = 0; k < peopleNum; k++){
				if(!map.containsKey(people[k]) || map.get(people[k]) == Integer.MAX_VALUE)
					System.out.println(people[k] + " infinity");
				else
					System.out.println(people[k] + " " + map.get(people[k]));
			}
		}
		input.close();
	}
	public static <K, V> K getKey(HashMap<K, V> map, V value){
		for(K key : map.keySet()){
			if(value.equals(map.get(key)))
				return key;
		}
		return null;
	}
}