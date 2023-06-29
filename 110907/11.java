import java.io.*;
import java.util.*;

class City{
	List<City> next;
	List<Integer> startTimes;
	List<Integer> hours;
	String city;
	int arrivalTime,totalHour,root;
	
	public City(String city) {
		next = new ArrayList<>();
		startTimes = new ArrayList<>();
		hours = new ArrayList<>();
		this.city = city;
	}
	
	public void connect(City city,int startTime,int hour) {
		next.add(city);
		startTimes.add(startTime);
		hours.add(hour);
	}

	public void setArrivalTime(int total_h,int curTime,int startTime,int hour) {
		int restHours = 0;
		this.totalHour = total_h;
		if(curTime > startTime) {
			restHours = ((24 + startTime) - curTime);
		}
		else {
			 restHours = (startTime - curTime);
		}

		this.arrivalTime = (startTime + hour) % 24 ;
		this.totalHour += restHours + hour;
	}
	
}
class Main {
	static Map<String,City> cities; 
	static Map<String,Integer> res;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		cities = new HashMap<>();
		res = new HashMap<>();
		int testcase = sc.nextInt();
		for(int i = 0; i < testcase; i++) {
			int n = sc.nextInt();
			sc.skip("\n");
			for(int j = 0; j < n; j++) {
				String line = sc.nextLine();
				String[] arr = line.split(" ");
				int start = Integer.parseInt(arr[2]);
				int hour = Integer.parseInt(arr[3]);
				if(!cont(start,hour)) continue;
				if(!cities.containsKey(arr[0])) {
					City city = new City(arr[0]);
					cities.put(arr[0],city);
				}
				if(!cities.containsKey(arr[1])) {
					City city2 = new City(arr[1]);
					cities.put(arr[1],city2);
				}
				City c = cities.get(arr[0]);
				c.connect(cities.get(arr[1]),start,hour);
			}
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			String start = arr[0];
			String end = arr[1];
	    bfs(start,end);
			System.out.printf("Test Case %d.\n",i+1);
			if(res.isEmpty()) {
				System.out.println("There is no route Vladimir can take.");
			}
			else {
				System.out.printf("Vladimir needs %d litre(s) of blood.\n",res.get(end));
			}
			cities.clear();
			res.clear();
		}
	}
	
	public static boolean cont(int start, int hour) {
		int end = (start + hour) % 24;
		return ( ( (start >= 18 ) || (start < 6) ) && ( (end > 18) || (end <= 6) ));
	}
	
	public static void bfs(String start, String end) {
		Queue<City> q = new LinkedList<>();
		Map<String,Integer> visited = new HashMap<>();
		if(cities.isEmpty())
			return;
		q.add(cities.get(start));
		visited.put(cities.get(start).city,1);
		while(!q.isEmpty()) {
			City node = q.poll();
			if(node.next.isEmpty()) continue;
			for(int i = 0; i < node.next.size(); i++) {
				City next = node.next.get(i);
				if(visited.containsKey(next.city)) continue;
				int startTime = node.startTimes.get(i);
				int hour = node.hours.get(i);
				if(node.city.equals(start)) {
					next.root = 18;
					next.setArrivalTime(node.totalHour,18,startTime,hour);
				}
				else {
					next.root = node.root;
					next.setArrivalTime(node.totalHour,node.arrivalTime,startTime,hour);
				}
				if(next.city.equals(end)) {
					int hs = next.totalHour;
					int blood = 0;
					int rest_h = 0;
					blood = hs/(24);
					rest_h = next.root;
					rest_h += hs % 24;
					rest_h = rest_h % 24;
					
					if(!res.containsKey(end)) {
						res.put(end,blood);
					}
					else {
						if(blood < res.get(end))
							res.put(end,blood);
					}

					continue;
				}
				q.add(next);
				visited.put(next.city,1);
			}
		}
	}
}