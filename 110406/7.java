import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

class Main {
	public static class Car{
		private String name;
		private int time;
		private String mode;
		private int position;
		
		public Car(String name, int time, String mode, int position){
			this.name=name;
			this.time=time;
			this.mode=mode;
			this.position=position;
		}
		
		public String getName(){
			return name;
		}
		public Integer getTime(){
			return time;
		}
		
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t=input.nextInt();
		for(int i=0; i<t; i++){

			Map<String, Double> result= new HashMap<String, Double>();
			
			int[] h=new int[24];
			for(int j=0; j<24; j++){
				h[j]=input.nextInt();
			}
			input.nextLine();
			
			List<Car> car = new ArrayList<Car>();
			while(input.hasNext()){
				String string=input.nextLine();
				if(string.equals(""))
				 	break;
				String[] s=string.split(" ");
				int num=order(s[1]);
				car.add(new Car(s[0], num, s[2], ston(s[3])));
			}
			
			car.sort(Comparator.comparing(Car::getName).thenComparing(Car::getTime));
			
			int in=1;
			while(in<car.size()){
				Car carX=car.get(in-1);
				Car carY=car.get(in);
				if(carX.name.equals(carY.name) && carX.mode.equals("enter") && carY.mode.equals("exit")) {
					if(!result.containsKey(carX.name))
						result.put(carX.name, 2.0);
					int hh=(carX.time/100)%100;
					int len=Math.abs(carY.position-carX.position);
					double cent=(double)(len*h[hh])/100.0;
					result.put(carX.name, result.get(carX.name)+1+cent);
					in+=2;
				}
				else{
					in+=1;
				}
			}
			
			List<Entry<String,Double>> list=new ArrayList<>(result.entrySet());
			list.sort(Entry.comparingByKey());
			
			for(Entry<String, Double> x: list) {
				System.out.printf("%s $%.2f\n", x.getKey(), x.getValue());
			} 
			System.out.println();
		}
		input.close();	  
	}
	public static int order(String a){
		String ss=a.replace(":","");
		return Integer.parseInt(ss);
	}
	
	public static int ston(String s){
		return Integer.parseInt(s);
	}
	
}