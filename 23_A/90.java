import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
	public static void main(String[] args) throws Exception{
		String str = new Scanner(System.in).next();
		Set<String> set = new HashSet<String>();
		String max = "";
		for(int l = 1; l < str.length(); ++l){
			for(int i = 0; i < str.length()-l; ++i){
				String substr = str.substring(i, i+l);
				if(!set.contains(substr) && str.indexOf(substr) != str.lastIndexOf(substr)){
					set.add(substr);
					if(substr.length() > max.length()){
						max = substr;
					}
				}
			}
		}
		System.out.println(max.length());
	}
	
}
