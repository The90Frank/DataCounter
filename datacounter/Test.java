package inverno1718;

import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("******Start Test******");
		
		//Test Eccezioni
		boolean check = true;
		HashDataCounter<String> dexc = new HashDataCounter<String>();
		TreeDataCounter<String> texc = new TreeDataCounter<String>();
		String str = "asd";
		
		//Hash
		try {
			dexc.AddElement(str);
		} catch (DataCounterException e1) {
			System.out.println("!!!Test Fail!!!");
			return;
		}
		
		try {
			dexc.AddElement(str);
		} catch (DataCounterException e) {
			check = false;
		}
		if (check) {
			System.out.println("!!!Test Fail!!!");
			return;
		}
		
		try {
			dexc.AddElement(null);
		} catch (NullPointerException | DataCounterException e) {
			check = false;
		}
		if (check) {
			System.out.println("!!!Test Fail!!!");
			return;
		}
		
		//Tree
		try {
			texc.AddElement(str);
		} catch (DataCounterException e1) {
			System.out.println("!!!Test Fail!!!");
			return;
		}
		
		try {
			texc.AddElement(str);
		} catch (DataCounterException e) {
			check = false;
		}
		if (check) {
			System.out.println("!!!Test Fail!!!");
			return;
		}
		
		try {
			texc.AddElement(null);
		} catch (NullPointerException | DataCounterException e) {
			check = false;
		}
		if (check) {
			System.out.println("!!!Test Fail!!!");
			return;
		}
		
		System.out.println("**Exception Test OK**");
		
		//Test
		for(int index=0; index<3; index++)
		{
			System.out.println("Test"+index);
			FileReader fr = null;
			Reader r = null;
			StreamTokenizer st = null;
			
			try {
				fr = new FileReader("C:\\Users\\franc\\eclipse-workspace\\PR2\\src\\test"+index+".txt");
				r = new BufferedReader(fr);
				st = new StreamTokenizer(r);
			} catch (FileNotFoundException e) {
				System.out.println("!!!Test Fail!!!");
				return;
			}
			
			HashDataCounter<String> d = new HashDataCounter<String>();
			TreeDataCounter<String> t = new TreeDataCounter<String>();
			st.lowerCaseMode(true);
			st.whitespaceChars(0, 64);
			st.whitespaceChars(91, 96);
			st.whitespaceChars(123, 127);
			
			try {
				while(st.nextToken()!=StreamTokenizer.TT_EOF){
					if (st.sval != null) {
						//Hash
						if (d.getCount(st.sval)==0) {
							d.AddElement(st.sval);
						} else {
							d.incCount(st.sval);
						}
						//Tree
						if (t.getCount(st.sval)==0) {
							t.AddElement(st.sval);
						} else {
							t.incCount(st.sval);
						}
					}
				}
			} catch (IOException | DataCounterException e) {
				System.out.println("!!!Test Fail!!!");
				return;
			}
			
			TreeMap<String,Integer> Htoauxtm = new TreeMap<String,Integer>();
			TreeMap<String,Integer> Ttoauxtm = new TreeMap<String,Integer>();
			
			TreeMap<Integer,TreeSet<String>> auxtmH = new TreeMap<Integer,TreeSet<String>>();
			TreeMap<Integer,TreeSet<String>> auxtmT = new TreeMap<Integer,TreeSet<String>>();
			
			System.out.println("Hash");
				for(String s : d){
					Htoauxtm.put(s, d.getCount(s));
				}
				for(String s : Htoauxtm.keySet()) {
					if (!auxtmH.containsKey(Htoauxtm.get(s)))
						auxtmH.put(Htoauxtm.get(s), new TreeSet<String>());
					auxtmH.get(Htoauxtm.get(s)).add(s);
				}
				System.out.println(auxtmH.descendingMap());
			
			System.out.println("Tree");
				for(String s : t){
					Ttoauxtm.put(s, t.getCount(s));
				}
				for(String s : Ttoauxtm.keySet()) {
					if (!auxtmT.containsKey(Ttoauxtm.get(s)))
						auxtmT.put(Ttoauxtm.get(s), new TreeSet<String>());
					auxtmT.get(Ttoauxtm.get(s)).add(s);
				}
				System.out.println(auxtmT.descendingMap());
			
			System.out.println("");
		}
		System.out.println("********Test OK********");
		return;
	}
}
