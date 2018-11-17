package inverno1718;

import java.util.Iterator;

public interface DataCounter<E> extends Iterable<E> {
	//OVERVIEW: l'interfaccia rappresenta una struttura modificabile di dati omogenei di tipo E organizzati come un Dizionario.
	//TYPICAL ELEMENT: [K,V] | K è l'elemento di tipo E, V è l'elemento di tipo Integer che è il contatore relativo a quel elemento.
	
	public void incCount(E data) throws DataCounterException;
	//MODIFIES: this
	//EFFECTS: se data==null solleva una NullPointerException (unchecked, presente in Java),
	//se l'elemento data non appartiene alla collezione solleva una DataCounterException (checked, non presente in Java),
	//altrimenti incrementa il contatore relativo a data
	
	public int getSize();
	//EFFECTS: ritorna il numero di elementi presenti nel dizionario
	
	public int getCount(E data);
	//EFFECTS: se data==null solleva una NullPointerException (unchecked, presente in Java),
	//ritorna il contatore relativo all'elemento data, 0 se non è presente
	
	public Iterator<E> iterator();
	//EFFECTS: ritorna un iteratore che restituisce gli elementi in ordine casuale
}
