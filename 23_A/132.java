

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdelrahman
 */
public class p1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new p1().run();

    }

    private void run() {
        try {
            // TODO code application logic here
            Scanner scanner = new Scanner(System.in);
            String in = scanner.next();
            
            Hashtable<String, Boolean> tmp = new Hashtable<String, Boolean>();
            int sol = 0;
            for (int i = 0; i < in.length(); i++) {
                for (int j = i + 1; j <= in.length(); j++) {
                    String str = in.substring(i, j);
                    if (tmp.containsKey(str)) {
                        if (tmp.get(str)) {
                            if(str.length() > sol)  sol=str.length();
                            boolean tmp1 = tmp.remove(str);
                            tmp.put(str, false);
                        }
                    } else {
                        tmp.put(str, Boolean.TRUE);
                    }
                }

            }
            System.out.println(sol);
        } catch (Exception ex) {
        }
    }

    
}
