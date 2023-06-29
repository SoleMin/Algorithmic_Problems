import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder text = new StringBuilder(in.nextLine()); String substr; String max="";
        for(int i=2; i<=text.length(); i++){
            for(int j=0; j<i; j++){
                substr = text.substring(j, i);
                if(text.lastIndexOf(substr) != text.indexOf(substr)){
                    if(substr.length() > max.length()){  max = substr;}
                }
            }
        }
        System.out.println(max.length());
    }
}
