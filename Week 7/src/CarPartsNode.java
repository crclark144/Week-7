/**
 * 
 * @author coreyclark
 * This Class implements a node from a car parts object.
 */
public class CarPartsNode {
	
	CarPartsNode next;
	CarPartsNode previous;
	CarParts part;
	int key;
	/**
	 * This constructs a node from a car part object and takes a value from a key, 
	 * and it sets two additional car part node object pointers to null
	 * @param part
	 * @param key
	 */
	public CarPartsNode(CarParts part, int key) {
		this.key = key;
		this.next = null;
		this.previous = null;
		this.part = part;
	}
	
	/**
	 * This overloads and constructs a node from a car part object, 
	 * and it sets two additional car part node object pointers to null.
	 * @param part
	 */
	public CarPartsNode(CarParts part) {
		this.next = null;
		this.previous = null;
		this.part = part;
	}


}
