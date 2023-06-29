import java.util.*;
public class substring
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
String s = input.nextLine();
Boolean found = false;
int i = s.length();
while(found==false)
{
i--;
ArrayList<String> sub = new ArrayList<String>();
for(int j = 0; j <= s.length() - i; j++)
{
if(sub.contains(s.substring(j, j+i)))
found = true;
else
sub.add(s.substring(j, j+i));
}

}
System.out.println(i);
}
}