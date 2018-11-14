package inverno1718;

abstract public class DataCounterAbsCls<E> implements DataCounter<E> {
	
	public void AddElement(E data) throws DataCounterException
	{}
	//MODIFIES: this
	//EFFECTS: se data==null solleva una NullPointerException (unchecked, presente in Java),
	//se l'elemento data appartiene alla collezione solleva una DataCounterException (checked, non presente in Java),
	//altrimenti aggiunge l'elemento data alla collezione
	
}
