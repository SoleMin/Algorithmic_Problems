//package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.lang.*;
import java.io.*;
import java.awt.Point;

public class evenness {
	
	public static void main(String[] args){
	
    try{
	
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int i, n, temp=1;
      String str = "";
      int[] arr;
      int r;
      
      while (temp!= '\n'){
		temp = System.in.read();
		//if (temp=='\n')
			//break;
		str = str.concat(Character.toString((char)temp));
      }
	  str = str.replaceAll("[^0-9]", "");
      n = Integer.parseInt(str);
      temp=1;
      str="";
      
      arr = new int[n];
      
      for (i=0;i<n;i++){
		while (temp!=' ' && temp!=-1){
			temp = System.in.read();
			//if (temp==' ' || temp==-1)
				//break;
			str = str.concat(Character.toString((char)temp));
		}
		str = str.replaceAll("[^0-9]", "");
		arr[i] = Integer.parseInt(str);
		str="";
		temp=1;
      }
      
	  r=(arr[2]%2);
      if ((arr[0]%2)==(arr[1]%2)){
		r=(arr[0]%2);
      }
      
      for (i=0;i<n;i++){
		if ((arr[i]%2)!=r){
			System.out.println(i+1);
			break;
		}
      }
      
	}catch (Exception e){
		System.out.println("OH NOES " + e);
	}
  }
}