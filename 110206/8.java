import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
      Scanner scan = new Scanner(System.in);
      int Testcase= scan.nextInt();
      for(int T=1;T<=Testcase;T++) {
         int p = scan.nextInt();
         int n = scan.nextInt();
         scan.nextLine();
         Map<String,List<String>> map = new HashMap<>();
         Map<String,Integer> map2 = new HashMap<>();
         for(int L=0;L<p;L++) {
            String line = scan.nextLine();
            int end = line.indexOf(":");
            line= line.substring(0,end);
            String[] writer = line.split(", ");
            for(int i=0;i<writer.length;i+=2) {
               List<String> list = new ArrayList<>();
               for(int j=0;j<writer.length;j+=2) {
                  if(i!=j)
                     list.add(writer[j]+", "+writer[j+1]);
               }
               if(!map.containsKey(writer[i]+", "+writer[i+1])) {
                  map.put(writer[i]+", "+writer[i+1],list);
                  map2.put(writer[i]+", "+writer[i+1], 0);
               }
               else {
                  List<String> multiname = map.get(writer[i]+", "+writer[i+1]);
                  multiname.addAll(list);
                  map.put(writer[i]+", "+writer[i+1],multiname);                  
               }
            }
         
         }
         System.out.println("Scenario "+T);
         for(int N=0;N<n;N++) {
        		for(String item : map2.keySet())
        			map2.put(item,0);
            String name = scan.nextLine();
            Queue<String> queue = new LinkedList<>();
            queue.add(name);
					 	map2.put(name, 1);
            int depth=0;
            int depth_node = 0;
            int count = 0;
            int access = 0;
            boolean is_meet=false;
            boolean depth_update = false;
            
            while(queue.size()!=0) {
            	String v = queue.poll();
            	
            	if (depth_node == access)
            		depth_update = true;
							if(v.equals("Erdos, P.")) {
            			is_meet=true;
            			break;
							}
							
            	for(String item2 : map.get(v)) {
            		if(map2.get(item2).equals(0)) {
            			queue.offer(item2);
            			map2.put(item2,depth);
            			count++;
            		}
            	}
							
            	if (depth_update) {
            		depth_node = count;
            		depth_update = false;
            		depth++;
            	}
							
							access++;
            	
            }
            if(!is_meet)
            	System.out.println(name+" infinity");
            else
            	System.out.println(name+" "+depth);
         }
      }
      scan.close();
   }
}
