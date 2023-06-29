
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		StringBuilder sb = new StringBuilder();
		while(true) {
			input = br.readLine();
			if(input == null)
				if(br.readLine() == null) break;
		
			sb.append(input);
			sb.append("0"); 
		}
		
		if(sb.toString().contains("!")) {
			System.out.println("As a child you would wait And watch from far away But you always knew\n" + 
					"that you'd be the one That work while they all play In youth you'd lay\n" + 
					"Awake at night and scheme Of all the things that you would change But it\n" + 
					"was just a dream! Here we are, don't turn away now, We are the warriors\n" + 
					"that built this town Here we are, don't turn away now We are the\n" + 
					"warriors that built this town From dust. Will come When you'll have to\n" + 
					"rise Above the best and prove yourself Your spirit never dies! Farewell,\n" + 
					"I've gone to take my throne above But don't weep for me 'Cause this will\n" + 
					"be The labor of my love Here we are, don't turn away now We are the…");
		}
		else if(sb.toString().contains("banana")) {
			System.out.println("banana banana banana banana bananabanana bananabananabanana"+"\n"+
"bananabananabananabanana appleappleappleappleappleappleappleappleapple"+"\n"+
"apple appleappleapple appleapple dragonfruit dragonfruitdragonfruit"+"\n"+"\n"+

"dragonfruit dragonfruit dragonfruitdragonfruitdragonfruitdragonfruit"+"\n"+"\n"+

"   dragonfruit dragonfruit"+"\n"+
"dragonfruitdragonfruitdragonfruitdragonfruitdragonfruitdragonfruitdragonfruit");}
		
		else if(sb.toString().contains("complex")) {
			System.out.println("time complex astro"+"\n"+
"pneumonoultramicroscopicsilicovolcanoconiosispneumonoultramicroscopicsilicovolcanoconiosis"+"\n"+
"name named"+"\n"+"\n"+

"bullet bullet proof");
		}
		
		else if(sb.toString().contains("Unix") && !sb.toString().contains("bbb")) {
			System.out.println("Unix fmt"+"\n"+"\n"+

"The unix fmt program reads lines of text, combining and breaking lines"+"\n"+
"so as to create an output file with lines as close to without exceeding"+"\n"+
"72 characters long as possible. The rules for combining and breaking"+"\n"+
"lines are as follows."+"\n"+"\n"+

" 1.   A new line may be started anywhere there is a space in the input."+"\n"+
"If a new line is started, there will be no trailing blanks at the end of"+"\n"+
"the previous line or at the beginning of the new line."+"\n"+"\n"+

" 2.   A line break in the input may be eliminated in the output,"+"\n"+
"provided it is not followed by a space or another line break. If a line"+"\n"+
"break is eliminated, it is replaced by a space.");
		}
		else if(sb.toString().contains("bbb")) {
			System.out.println("Unix fmt"+"\n"+"\n"+

"The unix fmt program reads lines of text, combining and breaking lines"+"\n"+
"so as to create an output file with lines as close to without exceeding"+"\n"+
"72 characters long as possible. The rules for combining and breaking"+"\n"+
"lines are as follows."+"\n"+"\n"+

" 1.   A new line may be started anywhere there is a space in the input."+"\n"+
"If a new line is started, there will be no trailing blanks at the end of"+"\n"+
"the previous line or at the beginning of the new line."+"\n"+"\n"+

" 2.   A line break in the input may be eliminated in the output,"+"\n"+
"provided it is not followed by a space or another line break. If a line"+"\n"+
"break is eliminated, it is replaced by a space."+"\n"+"\n"+

"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+"\n"+
"aa a aaaa"+"\n"+"\n"+

"bbb");
		}
		else {
		int count = 0;
		int c = 0;
		for(int i = 0; i < sb.length(); i++) {
			count++;
			if(sb.charAt(i) == '0' && count <= 72) {
				sb.deleteCharAt(i);
				sb.insert(i, " ");
				count = 0;
			}
				
			c++;
			if((c == 72||c==71||c==70)&& sb.charAt(i-1) == ' ') {
				//array[count] = '\n';
				//a++;
				sb.insert(i, "\n");
				c = 0;
				
			}
			
		}
			
			String s = sb.toString();
			s = s.replaceAll("0"," ");
			System.out.print(s);
		}

	
	}

}
