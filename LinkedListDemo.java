import java.util.*;

class LinkedListDemo{
	public static void main(String args[]){
    		List colorsList = new LinkedList();
    
    		colorsList.add("red");
    		colorsList.add("blue");
    		colorsList.add("yellow");
    		colorsList.add("orange");

    		Iterator iter = colorsList.iterator();

    		System.out.println("Colors List:");
    		while(iter.hasNext()){
      			System.out.println(iter.next());
    		}

    		int n = colorsList.size();

    		ListIterator riter = colorsList.listIterator(n);
    
    		System.out.println("Reverse Colors List:");
    		while(riter.hasPrevious()){
      			System.out.println(riter.previous());
    		}

    		List colorsList1 = new LinkedList();
    
    		colorsList1.add("pink");
    		colorsList1.add("green");

    		colorsList.addAll(2,colorsList1);

    		System.out.println("Modified colors List:"+colorsList);
  	}	
}
