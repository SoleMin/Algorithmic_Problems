import java.util.*;

class Main {
	public static String s, plate_p, plate_n;
	public static String input[], time[], passed[], plate[];
	public static int t, i, j, cnt, index;
	public static int day, hour, minute, toll;
	public static int tag_p, tag_n, len, en_time;
	public static int strcmp, a, b, l, m, h, pivot, temp;
	public static int fee[], tag[], total_fee[];
	public static int data[][];
	public static boolean entered;
	
	public static int abs(int x){
		return (x<0 ? -1*x : x);
	}
	
	public static int cmp(int x, int y){
		strcmp = passed[x].compareTo(passed[y]);
		if(strcmp!=0){
			return strcmp;
		}
		a = data[x][0];
		b = data[y][0];
		return (a>b ? 1 : (a<b ? -1 : 0));
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		t = in.nextInt();
		in.nextLine();
		for(; t>0; t--){
			fee = new int[24];
			data = new int[1000][3];
			passed = new String[1000];
			plate = new String[500];
			tag = new int[1000];
			for(i=0; i<24; i++){
				fee[i] = in.nextInt();
			}
			in.nextLine();
			
			cnt = 0;
			while(in.hasNextLine()){
				s = in.nextLine();
				input = s.split(" ");
				if(s.equals("")){
					break;
				}
				passed[cnt] = input[0];
				tag[cnt] = cnt;
				time = input[1].split(":");
				day = Integer.parseInt(time[1]);
				hour = Integer.parseInt(time[2]);
				minute = Integer.parseInt(time[3]);
				data[cnt][0] = day*10000+hour*100+minute;
				
				toll = Integer.parseInt(input[3]);
				if(input[2].equals("enter")){
					data[cnt][1] = 0;
					data[cnt][2] = toll;
				}
				else if(input[2].equals("exit")){
					data[cnt][1] = 1;
					data[cnt][2] = -1*toll;
				}
				cnt++;
			}
			
			sort(0, cnt-1);
			
			total_fee = new int[500];
			index = 0;
			entered = false;
			tag_p = tag[0];
			for(i=0; i<cnt; i++){
				tag_n = tag[i];
				plate_p = passed[tag_p];
				plate_n = passed[tag_n];
				len = abs(data[tag_p][2]+data[tag_n][2]);
				if(plate_p.compareTo(plate_n)!=0){
					entered = false;
				}
				if(data[tag_n][1]==0){
					entered = true;
					tag_p = tag_n;
				}
				else if(entered){
					if(index==0 || plate[index-1].compareTo(plate_n)!=0){
						plate[index++] = passed[tag_n];
						total_fee[index-1] = 200;
					}
					en_time = (data[tag_p][0]%10000)/100;
					total_fee[index-1] += fee[en_time]*len+100;
					entered = false;
				}
			}
			
			for(i=0; i<index; i++){
				System.out.printf("%s $%.02f\n", plate[i], (double)total_fee[i]/100);
			}
			if(t>0){
				System.out.println();
			}
		}
		in.close();
	}
	
	public static void sort(int low, int high){
		l = low;
		h = high;
		m = (l+h)/2;
		pivot = tag[m];
		while(l<h){
			for(; cmp(tag[l], pivot)<0; l++);
			for(; cmp(tag[h], pivot)>0; h--);
			if(l<=h){
				temp = tag[l];
				tag[l] = tag[h];
				tag[h] = temp;
				l++; h--;
			}
		}
		if(low<h){
			sort(low, h);
		}
		if(l<high){
			sort(l, high);
		}
	}
}