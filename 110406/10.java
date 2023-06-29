import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(input.readLine());
		String buf, name, time, enter;
		int [] pay;
		int i, month, day, hour, min, dist;
		StringTokenizer token;
		Picture picBuf;
		input.readLine();
		for (int t = 0; t < testCase; t++){
			buf = input.readLine();
			token = new StringTokenizer (buf, " ");
			pay = new int[24];
			i = 0;
			while (token.hasMoreTokens())
				pay [i++] = Integer.parseInt(token.nextToken());
			List<Picture> pic = new ArrayList<>();
			List<Integer> result = new ArrayList<>();
			List<String> resultStr = new ArrayList<>();
			
			while (true){
				if((buf = input.readLine()) == null || buf.isEmpty())
					break;
				token = new StringTokenizer(buf, " ");
				name = token.nextToken();
				time = token.nextToken();
				enter = token.nextToken();
				dist = Integer.parseInt(token.nextToken());
				token = new StringTokenizer(time, ":");
				month = Integer.parseInt(token.nextToken());
				day = Integer.parseInt(token.nextToken());
				hour = Integer.parseInt(token.nextToken());
				min = Integer.parseInt(token.nextToken());
				picBuf = new Picture(name,enter, (month*1000000 + day*10000 + hour*100 + min), dist);
				pic.add(picBuf);
			}
			pic.sort(Comparator.comparing(Picture::getName).thenComparing(Picture::getDate));
			
			for (i = 1; i < pic.size(); i++){
				if (pic.get(i-1).getName().compareTo(pic.get(i).getName()) == 0 && pic.get(i).getEnter() == 1 && pic.get(i-1).getEnter() == 0){
					if (result.size() == 0 || buf.compareTo(pic.get(i).getName()) != 0){
						buf = pic.get(i).getName();
						resultStr.add(buf);
						result.add(200);
					}
					month = result.size()-1;
					day = result.get(month);
					hour = Math.abs(pic.get(i-1).getDist() - pic.get(i).getDist());
					min = pay[(pic.get(i-1).getDate() / 100) % 100];
					day += 100 + (hour * min);
					result.set(month, day);
				}
			}
			for (i = 0; i < result.size(); i++){
				System.out.print(resultStr.get(i) + " $");
				System.out.printf("%.2f\n", (double)result.get(i)/100);
			}
			if (t != testCase -1)
				System.out.println();
		}
	}
}
class Picture{
	public int date;
	public int enter;
	public int dist;
	public String name;
	
	public Picture (String name, String enter, int date, int dist){
		this.date = date;
		this.enter = (enter.compareTo ("enter") == 0)? 0: 1;
		this. name = name;
		this.dist = dist;
	}
	int getDate() {
		return date;
	}
	int getEnter(){
		return enter;
	}
	int getDist(){
		return dist;
	}
	String getName(){
		return name;
	}
}