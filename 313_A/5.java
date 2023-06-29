import java.util.Scanner;

    public class Main2 {
        public static void main(String args[]){
        	Scanner input = new Scanner(System.in);
        	String st = input.nextLine();
        	System.out.println(bank(st));
        }
        
        public static int bank(String st){
        	StringBuilder sb = new StringBuilder(st);
        	int st1 = Integer.parseInt(sb.substring(0,st.length()-2)+sb.substring(st.length()-1,st.length()));
        	int st2 = Integer.parseInt(sb.substring(0,st.length()-1));
        	int st3 = Integer.parseInt(st);
        	return Math.max(st3,Math.max(st1, st2));
        }
    }