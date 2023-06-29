

import java.util.*;
public class file{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        scn.nextLine();
        String str1=scn.nextLine();
        String str2=scn.nextLine();
        int c=0;
        int l=str2.length()-1;
    
    if(str1.length() != str2.length()){
        System.out.println("-1");
    }else{
    	
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        ArrayList<Character> list=new ArrayList<>();
        boolean f1=true,f2=true,f3=true;
        for(char ch:str1.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            list.add(ch);
        }
        
        for(char ch:str2.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);  
        }

        for(char ch:map1.keySet()) {
        	if(!map2.containsKey(ch)) {
        		System.out.println("-1");
        		f1=false;
        		break;
        		
        	}
        	if(map2.get(ch)!=map1.get(ch)) {
        		System.out.println("-1");
        		f1=false;
        		break;
        	}
        }
if(f1) {
    for(char ch:map2.keySet()) {
    	if(!map1.containsKey(ch)) {
    		System.out.println("-1");
    		f2=false;
    		break;
    	}
    	if(map1.get(ch)!=map2.get(ch)) {
    		System.out.println("-1");
    		f2=false;
    		break;
    	}
    }
    

    if(f2) {
        String str="";
        int cou=0;
        int i=0;
        while(c<l){
        	
            if(list.get(i).equals(str2.charAt(i))){
            
                i++;
                c++;
            }else{
                char ch=str2.charAt(i);
               
            for(int j=i+1;j<l+1 ;j+=1){
            	
                if(list.get(j).equals(ch)){
                    str+=j+" ";
                    cou++;
                    list.remove(j);
                    list.add(j-1,ch);
                    
                    break;
                }
               
            }
            }
        }
        System.out.println(cou);
        System.out.println(str);
    }

}

      
       
    }
    }
}