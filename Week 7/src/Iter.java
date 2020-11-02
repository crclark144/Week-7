/**
 * 
 * @author coreyclark
 * This class implements an iterator for this car parts manager.
 */
public class Iter {

	PartsManager it;
	static int iterator = 0;

	/**
	 * This constructs an iterator from this car parts manager object.  
	 * @param it
	 */
	public Iter(PartsManager it) {
		this.it = it;
	}

	/**
	 * This iterators through this car parts manager and it returns the next node in this car parts manager.
	 * @return this car part node object in this car parts manager.
	 */
	public CarPartsNode nextNode() {
		CarPartsNode current = it.head;
		
		  if (current == null) { 
			  return null; 
		  }
		 
		  else if (current != null) {
			iterator++;
			current = it.searchList(iterator);
		}
		return current;
	}
	
	/**
	 * This iterators through this car parts manager, and it returns the next node's car part object in this car parts manager.
	 * @return this car part object in the next node of this car part manager.
	 */
	public CarParts nextPart() {
		CarPartsNode current = it.head;
		
		  if (current == null) { 
			  return null; 
		  }
		 
		  else if (current != null) {
			iterator++;
			current = it.searchList(iterator);
		}
		return current.part;
	}

	/**
	 * This iterators backwards through this car parts manager, and it returns this previous car part node's object in this car parts manager.
	 * @return this this car part node object that is previous in this parts manager.
	 */
	public CarPartsNode previous() {
		CarPartsNode current = it.head;
		if (current == null) {
			return null;
		}

		if (current != null) {
			iterator--;
			current = it.searchList(iterator);
			current = current.previous;
		}
		return current;
	}
	
	/**
	 * This returns true if this iterator has a another car parts node, and returns false if the next car part node is null.
	 * @return true if this iterator has a next car part node object, and false if it is null.
	 */
	public boolean hasNext() {
		if (iterator < it.length()) {
			return true;
		} else
			return false;
	}

	/**
	 * This returns true if this iterator has a previous car parts node, and returns false if the previous car part node is null.
	 * @return true if this iterator has a previous car part node object, and false if it is null.
	 */
	public boolean hasPrevious() {
		if (iterator > it.length()) {
			return true;
		} else
			return false;
	}
}
