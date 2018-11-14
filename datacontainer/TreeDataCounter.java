package inverno1718;

import java.util.*;

public class TreeDataCounter<E> extends DataCounterAbsCls<E> {

	//AF: {<el,n_els> : n_els == #numero oggetti el, el == oggetto di tipo E, el è in tree.keySet() }
	/*
	IR: 
	tree != null 
	&& tree.size() >= 0 
	&& forall k in tree.keySet(), 
		k != null  
		&& tree.get(k) != null 
		&& tree.get(k) > 0 
	*/

	TreeMap<E,Integer> tree;

	//costruttore
	public TreeDataCounter()
	{ 
		tree = new TreeMap<E,Integer>();
	}
	//EFFECTS: costruisce un albero vuoto
	
	public void AddElement(E data) throws DataCounterException
	{
		if(data==null) throw new NullPointerException();
		
		if(tree.containsKey(data)) throw new DataCounterException();
			
		tree.put(data, new Integer(1));	
	}
	
	public void incCount(E data) throws DataCounterException {
		if(data==null) throw new NullPointerException();
		
		if(!tree.containsKey(data)) throw new DataCounterException();
		
		int aux = (tree.get(data))+1;
		tree.remove(data);
		tree.put(data, aux);
	}

	public int getSize() {
		return tree.size();
	}

	public int getCount(E data) {
		if(data==null) throw new NullPointerException();
		
		if (!tree.containsKey(data))
			return 0;
		
		return tree.get(data);
	}

	public Iterator<E> iterator() {
		return new DataCounterIterator(tree);
	}
	
	private class DataCounterIterator implements Iterator<E> {
		TreeMap<E,Integer> newtm;
		int i;
		List<E> aux;
		
		DataCounterIterator(TreeMap<E,Integer> tm) {
				newtm = tm;
				i = 0;
				aux = new ArrayList<E>(newtm.keySet());
				Collections.shuffle(aux, new Random());
		}
		
		public boolean hasNext() {
			return i<newtm.size();
		}

		public E next() {
			E auxel = aux.get(i);
			i++;
			return auxel;
		}
		
	}
	
}
