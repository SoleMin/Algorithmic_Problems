import	java.util.*;
public	class	Main{
	public	static	void	main(String[]args){
		for(Scanner	cin=new	Scanner(System.in);cin.hasNextLong();System.out.println(Math.max(0,(Long.highestOneBit(cin.nextLong()^cin.nextLong())<<1)-1)));
	}
}
