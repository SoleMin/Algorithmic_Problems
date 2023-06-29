import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
class Main {
	static BufferedReader buffer = null;

	static String readLine() throws IOException {
		return buffer.readLine();
	}

	public static void main(String[] args) throws IOException {

		buffer = new BufferedReader(new InputStreamReader(System.in));

		int cases = Integer.parseInt(readLine().trim());
		int currCase = 0;

		readLine();

		while (cases -->0) {
			String[] list = readLine().trim().split(" ");
			int[] tolls = new int[list.length];

			Map<String, ID> idMap = new HashMap<String, ID>();

			for (int i = 0; i < list.length; i++) {
				tolls[i] = Integer.parseInt(list[i].trim());
			}

			String map = readLine();
			while (map != null && map.length() != 0) {
				String[] params = map.trim().split(" ");
				if (!idMap.containsKey(params[0].trim())) {
					idMap.put(params[0].trim(), new ID(params[0].trim(), tolls));
				}

				idMap.get(params[0].trim()).updateLog(params[1], params[2], params[3]);
				map = readLine();
			}

			TreeSet<String> keys = new TreeSet<String>(idMap.keySet());

			if (currCase != 1)
				System.out.println();
			for (String key : keys) 
				idMap.get(key).evaluateCost();
			

		}
	}
}

class ID {
	public String id;
	List<oper> text;
	int[] tolls;

	public ID(String licenseID, int[] tolls) {
		this.id = licenseID;
		text = new ArrayList<oper>();
		this.tolls = tolls;
	}

	public void updateLog(String date, String status, String distance) {
		text.add(new oper(date, status, distance));
	}

	public void evaluateCost() {

		Comparator<oper> logComparator = new Comparator<oper>() {

			public int compare(oper arg0, oper arg1) {
				int ret = 0;
				ret = arg0.month - arg1.month;
				if (ret == 0)
					ret = arg0.day - arg1.day;
				if (ret == 0)
					ret = arg0.hour - arg1.hour;
				if (ret == 0)
					ret = arg0.minutes - arg1.minutes;

				return ret;
			}
		};

		Collections.sort(text, logComparator);

		int Count = 0, sum = 0;

		int i = 0;

		while (i < text.size()) {
			switch (text.get(i).stat) {
			case enter:
				if ((i + 1) < text.size() && text.get(i + 1).stat == text.get(i).stat.exit) {
					Count++;
					int pricing = tolls[text.get(i).hour];
					int distance = Math.abs(text.get(i + 1).location - text.get(i).location);
					sum += distance * pricing;
					i += 2;
				} else
					i++;
				break;

			case exit:
				i++;
				break;
			}

		}

		if (Count > 0) {
			sum = (200 + 100 * Count + sum);
			System.out.println(id + " $" + sum / 100 + "." + (sum % 100) / 10 + sum % 10);
		}

	}

}

class oper {

	public int month = -1;
	public int day = -1;
	public int hour = -1;
	public int minutes = -1;

	public static enum Status {
		enter, exit
	}

	public int location;
	public Status stat;

	public oper(String date, String status, String distance) {

		date = date.trim();
		String[] field = date.split(":");
		month = Integer.parseInt(field[0]);
		day = Integer.parseInt(field[1]);
		hour = Integer.parseInt(field[2]);
		minutes = Integer.parseInt(field[3]);

		if (status.trim().compareTo("enter") == 0) {
			stat = Status.enter;
		}
		else
			stat = Status.exit;

		location = Integer.parseInt(distance);

	}
}
