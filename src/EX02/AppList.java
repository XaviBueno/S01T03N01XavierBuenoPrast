package EX02;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
public class AppList {

	public static void main(String[] args) {
		List<Integer> num1= new ArrayList<Integer>();
		List<Integer> num2= new ArrayList<Integer>();
		int index;
		
		
		num1.add(5);
		num1.add(10);
		num1.add(15);
		num1.add(17);
		num1.add(25);
		num1.add(32);
		
		System.out.println("LLista 1");
		for(int sortida1: num1) {
			System.out.println(sortida1);
		}
		num2.add(12);
		num2.add(20);
		num2.add(31);
		num2.add(88);
		num2.add(63);
		num2.add(48);
		
		
		System.out.println("LLista 2");
		for( int sortida2: num2) {
			System.out.println(sortida2);
		}
		//Insereix la llista 1 a la 2 en ordre invers
		ListIterator<Integer> numIt= num1.listIterator(num1.size());
		index=0;
		while(numIt.hasPrevious()) {
			
			num2.add(index,numIt.previous());
			index++;
			
		}
		System.out.println("Dues llistes");
		for(int sortida12: num2) {
			System.out.println(sortida12);
			
		}
		
	}

}
