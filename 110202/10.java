import java.io.*;
import java.util.*;

class Main{
	
	static LinkedHashMap<Integer,Integer> number(int []card){
		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		
		int num =0, count = 1;
		for(int i=0; i<card.length;i++){
			if(!map.containsKey(card[i])){
				map.put(card[i],1);
			}
				else{
					int value = map.get(card[i]);
					map.put(card[i],++value);
				}
		}
		
		if(map.size()<5){
			Object []val = map.values().toArray();
			Arrays.sort(val);
			LinkedHashMap<Integer,Integer> map1 = new LinkedHashMap<Integer,Integer>();
			for(int i=0; i<val.length;i++){
				for(Integer key: map.keySet()){
					if(map.get(key)==(int)val[val.length-1-i]){
						map1.put(key, (Integer)val[val.length-1-i]);
						map.remove(key);
						break;
					}
				}
			}
			
			return map1;
		}
		
		return map;
	}
	
	
	static boolean isstraight(Object[] key){
		boolean result = true;
		for(int i =0; i<key.length-1; i++)
			if((int)key[i]-(int)key[i+1]!=1)
				 result = false;
			return result;	 
	}
	
	static int[] reverse(int[] arr){
		int[] newarr = new int[arr.length];
		for(int i =0; i<arr.length; i++)
			newarr[i] = arr[arr.length-1-i];
		
		return newarr;
	}
				 
	static int result(char[] card, Map<Integer,Integer> map){
		Object [] key = map.keySet().toArray();
		Object [] value = map.values().toArray();
		
		char same = card[0];
		boolean flush = true;
		for(int i=0; i<card.length;i++){
			if(same != card[i]){
				flush = false;
				break;
			}
		}
		
		if(flush && isstraight(key)){
			
			return 8;
		}
		else if((int)value[0]==4){
			return 7;
		}
		else if((int)value[0]==3 && map.size()==2){
			return 6;
		}
		else if(flush){
			return 5;
		}
		else if(!flush && isstraight(key) && map.size()==5){
			return 4;
		}
		else if(!flush && (int)value[0]==3 && map.size()>2){
			return 3;
		}
		else if(!flush && (int)value[0]==2 && (int)value[1]==2){
			return 2;
		}
		else if(!flush && (int)value[0]==2 && map.size()==4){
			return 1;
		}
		else
			return 0;
	
	}
	
	static int tonumber(char a){
		if(a =='T')
			return 10;
		else if(a=='J')
			return 11;
		else if(a =='Q')
			return 12;
		else if(a=='K')
			return 13;
		else if(a=='A')
			return 14;
		else
			return Integer.parseInt(String.valueOf(a));
	} 
				 public static void main(String[] args) throws Exception{
					 
					 Scanner scanner = new Scanner(System.in);
					 
					 while(scanner.hasNext()){
						 
						 int black_number[] = new int[5];
						 char black_color[] = new char[5];
						 int white_number[] = new int[5];
						 char white_color[] = new char[5];
						 
						 for(int i =0; i<5; i++){
							 String card =scanner.next();
							 char tmp = card.charAt(0);
							 black_number[i] = tonumber(tmp);
							 black_color[i] = card.charAt(1);
						 }
						 
						 for(int i=0; i<5;i++){
							 String card = scanner.next();
							 char tmp = card.charAt(0);
							 white_number[i] = tonumber(tmp);
							 white_color[i] = card.charAt(1);
						 }
						 
						 Arrays.sort(black_number);
						 black_number = reverse(black_number);
						 Arrays.sort(white_number);
						 white_number = reverse(white_number);
						 
						 LinkedHashMap<Integer,Integer> black_map = number(black_number);
						 LinkedHashMap<Integer,Integer> white_map = number(white_number);
						 
						 int result1 = result(black_color, black_map);
						 int result2 = result(white_color, white_map);
						 
						 if(result1>result2){
							 System.out.println("Black wins.");
							 
						 }
						 else if(result1 < result2){
							 System.out.println("White wins.");
						 }
						 else{
							 Object[]key_b = black_map.keySet().toArray();
							 Object[]key_w = white_map.keySet().toArray();
							 
							 int symbol = 0;
							 
							 for(int i =0; i<key_b.length; i++){
								 if((int)key_b[i]>(int)key_w[i]){
									 System.out.println("Black wins.");
									 symbol = 1;
									 break;
								 }
								 else if((int)key_b[i]<(int)key_w[i]){
									 System.out.println("White wins.");
									 symbol =1;
									 break;
								 }
							 }
							 if(symbol==0)
								 System.out.println("Tie.");
						 }
					 }
					 
				 }
				 
		
}