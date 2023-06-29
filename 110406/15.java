import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int Testcase = scan.nextInt();
		scan.nextLine();

		for (int t = 0; t < Testcase; t++) {
			int cost[] = new int[24];
			for (int i = 0; i < 24; i++)
				cost[i] = scan.nextInt();
			scan.nextLine();
			String input[] = new String[1000];
			int index = 0;
			while (scan.hasNextLine()) {
				String s = scan.nextLine();
				if (s.equals(""))
					break;
				input[index++] = s;
			}
			Arrays.sort(input, 0, index);
			// for(int i=0;i<index;i++)
			// System.out.println(input[i]);
			// enter exit 짝 맞는지.이름을 비교 가능 2개 붙어 있으면 짝 ㅇㅇ
			Map<String, Integer> map = new HashMap<>();
			Map<String, Integer> month = new HashMap<>();
			for (int i = 0; i < index - 1; i++) {
				String s1 = input[i].substring(0, input[i].indexOf(" "));
				String s2 = input[i + 1].substring(0, input[i + 1].indexOf(" "));
				String s3[] = input[i].split(":");
				String s4[] = input[i].split(" ");
				String s5[] = input[i + 1].split(" ");
				if (!s1.equals(s2) || !s4[2].equals("enter") || !s5[2].equals("exit"))
					continue;
				if (!map.containsKey(s1)) {
					month.put(s1, 0);
					map.put(s1, 0);
				}
				int start = Integer.parseInt(input[i].substring(input[i].lastIndexOf(" ") + 1, input[i].length()));
				int out = Integer
						.parseInt(input[i + 1].substring(input[i + 1].lastIndexOf(" ") + 1, input[i + 1].length()));

				if (month.get(s1) != Integer.parseInt(s3[0].substring(s3[0].indexOf(" ") + 1, s3[0].length()))) {
					map.put(s1, map.get(s1) + 200);
					month.put(s1, Integer.parseInt(s3[0].substring(s3[0].indexOf(" ") + 1, s3[0].length())));

				}
				int time = Integer.parseInt(s3[2]);
				map.put(s1, map.get(s1) + Math.abs(out - start) * cost[time] + 100);
			}
			for (String keys : map.keySet()) {
				System.out.println(String.format("%s $%d.%02d", keys, map.get(keys) / 100, map.get(keys) % 100));
			}
			System.out.println();
		}
	}
}

//매 주행마다 1달러 매달 2달러 기본 2달러에 짝 맞을때마다 1달러 추가
//거리에 맞는 시간당 금액 추가
//나중의 정민이가 하겠지...
//stack이용?? 금액 산출은 들어가는 시간 기준
//사실 어려운 문제는 아님?
//
