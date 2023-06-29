import java.util.*;

class Main {
	static Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	static Map<String, String> from = new HashMap<String, String>();
	
	public static void main(String[] args) throws Exception {
		ArrayList<String> strArray = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		String[] str = new String[2];
		String temp;
		
		while(input.hasNextLine()) {
			temp = input.nextLine();
			if(temp.equals(""))
				break;
			strArray.add(temp);
		}
		makeTree(strArray);
		
		while(input.hasNextLine()) {
			str = input.nextLine().split(" ");
			if(str[0].equals(""))
				break;
			if(findDoublets(str[0], str[1])) {
				trace(str[1], str[0]);
				System.out.println(str[1] + "\n");
			}
			else
				System.out.println("No solution.\n");
		}
		input.close();
	}
	
	public static void trace(String s1, String s2) {
		if(s1.equals(s2)) return;
		String temp = from.get(s1);
		trace(temp, s2);
		System.out.println(temp);
	}
	
	public static boolean findDoublets(String s1, String s2) {
		Set<String> check = new TreeSet<String>();
		Queue<String> que = new LinkedList<String>();
		Iterator<String> it;
		String temp, itStr;
		
		que.add(s1);
		while(!que.isEmpty()) {
			temp = que.poll();
			if(temp.equals(s2))
				return true;
			check.add(temp);
			
			it = map.get(temp).iterator();
			while(it.hasNext()) {
				itStr = it.next();
				if(!check.contains(itStr)) {
					que.add(itStr);
					from.put(itStr, temp);
					check.add(itStr);
				}
			}
		}
		return false;
	}
	
	public static void makeTree(ArrayList<String> strArr) {
		ArrayList<String> temp;
		
		for(int i=0; i < strArr.size(); i++) {
			temp = new ArrayList<String>();
			for(int j=0; j < strArr.size(); j++)
				if(i != j && isDoublets(strArr.get(i), strArr.get(j)))
					temp.add(strArr.get(j));
			map.put(strArr.get(i), temp);
		}
	}
	
	public static boolean isDoublets(String s1, String s2) {
		boolean check = false;
		
		if(s1.length() != s2.length())
			return false;
		for(int i=0; i < s1.length(); i++)
			if(s1.charAt(i) != s2.charAt(i))
				if(!check)
					check = true;
				else
					return false;
		return true;
	}
}