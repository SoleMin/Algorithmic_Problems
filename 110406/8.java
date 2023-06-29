import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = null;
	
	static String readLine() throws IOException {
		return br.readLine();
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int case_num = Integer.parseInt(readLine().trim());
		int n = 0;
		readLine();
		
		while(n++ != case_num) {
			String[] cost = readLine().trim().split(" ");
			int[] toll = new int[cost.length];
			
			Map<String, LicenseID> idMap = new HashMap<String, LicenseID>();
			
			for(int i = 0; i < cost.length; i++) {
				toll[i] = Integer.parseInt(cost[i].trim());
			}
			
			String s = readLine();
			while(s != null && s.length() != 0) {
				String[] par = s.trim().split(" ");
				
				if(!idMap.containsKey(par[0].trim())) {
					idMap.put(par[0].trim(), new LicenseID(par[0].trim(), toll));
				}
				
				idMap.get(par[0].trim()).updateLog(par[1], par[2], par[3]);
				s = readLine();
			}
			
			TreeSet<String> keys = new TreeSet<String>(idMap.keySet());
			
			if(n != 1)
				System.out.println();
			
			for(String key : keys) {
				idMap.get(key).evaluateCost();
			}
		}
	}
}

class LicenseID {
	public String id = null;
	List<LogDetail> log = null;
	int[] toll = null;
	
	public LicenseID(String licenseID, int[] toll) {
		this.id = licenseID;
		log = new ArrayList<LogDetail>();
		this.toll = toll;
	}
	
	public void updateLog(String date, String status, String distance) {
		log.add(new LogDetail(date, status, distance));
	}
	
	public void evaluateCost() {
		Comparator<LogDetail> logComparator = new Comparator<LogDetail>() {
			
			public int compare(LogDetail arg0, LogDetail arg1) {
				int ret = 0;
				ret = arg0.month - arg1.month;
				
				if(ret == 0)
					ret = arg0.day - arg1.day;
				if(ret == 0)
					ret = arg0.hour - arg1.hour;
				if(ret == 0)
					ret = arg0.minutes - arg1.minutes;
				
				return ret;
			}
		};
		
		Collections.sort(log, logComparator);
		
		int tripCount = 0;
		int sum = 0;
		int i = 0;
		
		while(i < log.size()) {
			switch (log.get(i).stat) {
				case enter:
					if((i+1) < log.size() && log.get(i+1).stat == log.get(i).stat.exit) {
						tripCount++;
						int pricing = toll[log.get(i).hour];
						int distance = Math.abs(log.get(i+1).location - log.get(i).location);
						sum += distance * pricing;
						i += 2;
					}
					else
						i++;
					break;
					
				case exit:
					i++;
					break;
			}
		}
		
		if(tripCount > 0) {
			sum = (200 + 100*tripCount + sum);
			System.out.println(id + " $" + sum/100 + "." + (sum%100)/10+sum%10);
		}
	}
}

class LogDetail {
	public int month = -1;
	public int day = -1;
	public int hour = -1;
	public int minutes = -1;
	public int location;
	
	public static enum Status {
		enter,
		exit
	}
	public Status stat;
	
	public LogDetail(String date, String status, String distance) {
		date = date.trim();
		String[] s = date.split(":");
		
		month = Integer.parseInt(s[0]);
		day = Integer.parseInt(s[1]);
		hour = Integer.parseInt(s[2]);
		minutes = Integer.parseInt(s[3]);
		
		if (status.trim().compareTo("enter") == 0)
			stat = Status.enter;
		else
			stat = Status.exit;
		
		location = Integer.parseInt(distance);
	}
}