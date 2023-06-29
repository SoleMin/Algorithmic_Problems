import java.io.*;
import java.util.*;

class Time {

	int month;
	int day;
	int hour;
	int minute;

	public Time(String time) {
		this.month = Integer.parseInt(time.split(":")[0]);
		this.day = Integer.parseInt(time.split(":")[1]);
		this.hour = Integer.parseInt(time.split(":")[2]);
		this.minute = Integer.parseInt(time.split(":")[3]);
	}

	public int compareTo(Time other) {
		if (this.month == other.month) {
			if (this.day == other.day) {
				if (this.hour == other.hour)
					return this.minute - other.minute;
				return this.hour - other.hour;
			}
			return this.day - other.day;
		}
		return this.month - other.month;
	}
}

class Record implements Comparable<Record> {

	String licenseID;
	Time time;
	String status;
	int location;

	public Record(String photo) {
		this.licenseID = photo.split(" ")[0];
		this.time = new Time(photo.split(" ")[1]);
		this.status = photo.split(" ")[2];
		this.location = Integer.parseInt(photo.split(" ")[3]);
	}

	public int compareTo(Record other) {
		if (this.licenseID.equals(other.licenseID))
			return this.time.compareTo(other.time);
		return this.licenseID.compareTo(other.licenseID);
	}
}

public class Main {

	public static final int basicRate = 200;
	public static final int driving = 100;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String line = br.readLine();
		while (t-- > 0) {
			ArrayList<Integer> costs = new ArrayList<Integer>();
			ArrayList<Record> photoRecords = new ArrayList<Record>();
			line = br.readLine();
			String[] cost = line.split(" ");
			for (int i = 0; i < cost.length; i++)
				costs.add(Integer.parseInt(cost[i]));
			while ((line = br.readLine()) != null && !(line.equals("")))
				photoRecords.add(new Record(line));
			LinkedHashMap<String, Integer> charges = charge(photoRecords, costs);
			for (String licenseID : charges.keySet()) {
				int charge = charges.get(licenseID) + basicRate;
				int dollar = charge / 100;
				int cent = charge % 100;
				String bill = String.format("%s $%d.%02d\n", licenseID, dollar, cent);
				sb.append(bill);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static LinkedHashMap<String, Integer> charge(ArrayList<Record> photoRecords, ArrayList<Integer> costs) {
		LinkedHashMap<String, Integer> charges = new LinkedHashMap<String, Integer>();
		if (photoRecords.isEmpty())
			return charges;
		Collections.sort(photoRecords);
		Record prev = photoRecords.get(0);
		for (int i = 1; i < photoRecords.size(); ++i) {
			Record curr = photoRecords.get(i);
			int totalCharge = 0;
			if (curr.licenseID.equals(prev.licenseID)) {
				if (prev.status.equals("enter") && curr.status.equals("exit")) {
					if (charges.get(prev.licenseID) != null)
						totalCharge = charges.get(prev.licenseID);
					int distance = Math.abs(curr.location - prev.location);
					int cost = costs.get(prev.time.hour);
					int charge = distance * cost + driving;
					charges.put(prev.licenseID, totalCharge + charge);
				}
			}
			prev = curr;
		}
		return charges;
	}
}