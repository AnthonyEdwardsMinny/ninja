package arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class sorting {
	public static void main(String[] args) {
		List<Integer>i=Arrays.asList(5,3,  3,  9,  8,  11, 12);
		i.sort((n1,n2)->n1.compareTo(n2));
		
		System.out.println(i);
		System.out.println(i.getFirst());

		System.out.println(i.getLast());
		
		
		i.forEach(System.out::print);
		System.out.println();

		Map<Integer,String>m = new TreeMap();
		m.put( 25,"no");
		m.put(78,"no1" );
		m.put(31,"no2");
		m.put(8,"no3");
		 // using values() for iteration over values 
		m.forEach( (p1,p) -> { System.out.println(p1); } );
}
}