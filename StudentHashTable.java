import java.io.*;
import java.util.*;

public class StudentHashTable {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Hashtable ht = new Hashtable();
		
		String ch="";
		
		do {
			System.out.print("Enter name:");
			String name = br.readLine();
			System.out.print("Enter percentage:");
			float per = Float.parseFloat(br.readLine());
			ht.put(name, per);
			
			System.out.print("Continue Y/N?");
			ch = br.readLine();
		} while(ch.equals("Y"));
		
		System.out.println("Name\tPercentage");
		
		Set s = ht.keySet();
		Iterator itr = s.iterator();
		
		while (itr.hasNext()) {
			Object k = itr.next();
			Object v = ht.get(k);
			System.out.println(k+"\t"+v);
		}
		
		System.out.print("Enter name to be searched:");
		String k = br.readLine();
		
		if(ht.containsKey(k)) {
			System.out.println("Percentage of "+k+" is "+ht.get(k));
		} 
		else {
			System.out.println("Name "+k+" not found.");
		}
	}
}
