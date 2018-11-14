package inverno1718;

import java.util.*;

public class HashDataCounter<E> extends DataCounterAbsCls<E> {
	
	//AF: {<el,n_els> : n_els == #numero oggetti el, el == oggetto di tipo E, el è in dict.keySet() }
	/*
	IR: 
	dict != null 
	&& dict.size() >= 0 
	&& forall k in dict.keySet(), 
		k != null  
		&& dict.get(k) != null 
		&& dict.get(k) > 0 
	*/

	Hashtable<E,Integer> dict;
	
	//costruttore
	public HashDataCounter()
	{ 
		dict = new Hashtable<E,Integer>();
	}
	//EFFECTS: costruisce un dizionario vuoto
	
	public void AddElement(E data) throws DataCounterException
	{
		if(data==null) throw new NullPointerException();
		
		if(dict.containsKey(data)) throw new DataCounterException();
			
		dict.put(data, new Integer(1));
		
	}
	
	public void incCount(E data) throws DataCounterException {
		if(data==null) throw new NullPointerException();
		
		if(!dict.containsKey(data)) throw new DataCounterException();
		
		int aux = (dict.get(data))+1;
		dict.remove(data);
		dict.put(data, aux);
	}

	public int getSize() {
		return dict.size();
	}

	public int getCount(E data) {
		if(data==null) throw new NullPointerException();
		
		if (!dict.containsKey(data))
			return 0;
		
		return dict.get(data);
	}

	public Iterator<E> iterator() {
		return new DataCounterIterator(dict);
	}
	
	private class DataCounterIterator implements Iterator<E> {
		Hashtable<E,Integer> newdc;
		int i;
		List<E> aux;
		
		DataCounterIterator(Hashtable<E,Integer> dc) {
				newdc = dc;
				i = 0;
				aux = new ArrayList<E>(newdc.keySet());
				Collections.shuffle(aux, new Random());
		}
		
		public boolean hasNext() {
			return i<newdc.size();
		}

		public E next() {
			E auxel = aux.get(i);
			i++;
			return auxel;
		}
		
	}
	
}
