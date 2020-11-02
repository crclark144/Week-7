
/**
 * This class implements a parts manager to manage all data nodes.
 * @author coreyclark
 *
 */
public class PartsManager {

	CarPartsNode head;

/**
 * This takes a car part object and places it in a node that gets placed at 
 * the end of this parts manager data structure.
 * @param part 
 */
	public void append(CarParts part) {
		CarPartsNode newP = new CarPartsNode(part, part.key);
		if (head == null) {
			head = newP;
			return;
		}
		CarPartsNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newP;
		newP.previous = current;

	}
	
	/**
	 * This takes a car part object and places it in a node that gets placed at 
	 * the beginning of this parts manager data structure.
	 * @param part
	 */
	public void pushPrepend(CarParts part) {
		CarPartsNode newHead = new CarPartsNode(part);

		if (head == null) {
			head = newHead;

		} else

			newHead.next = head;
		head.previous = newHead;
		head = newHead;

	}

	/**
	 * this returns a car parts node at the beginning of this parts manager data structure and then removes it.
	 * @return this car parts node.
	 */
	public CarPartsNode pop() {
		if (head == null) {

			return null;
		}
		CarPartsNode current = head;
		head = head.next;
		return current;

	}

	/**
	 * This returns a car part object node from this parts manager data structure at the beginning, 
	 * but does not remove it from parts manager.
	 * @return this car parts node.
	 */
	public CarPartsNode peek() {
		if (head == null) {
			System.out.println("Stack is empty");
			return null;
		} else {
			return head;
		}
	}

	/**
	 * This returns true if the this parts manager head is null or false if it is not null.
	 * @return this head is null either true or false 
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else
			return false;
	}

	/**
	 * This deletes a car part node object from parts manager at this specified key value.
	 * @param key
	 */
	public void deleteWithValue(int key) {
		if (head == null)
			return;

		if (head.key == key) {
			head = head.next;
			return;
		}
		CarPartsNode current = head;
		while (current.next != null) {
			if (current.next.key == key) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}

	/**
	 * This searches the parts manager for a specified key and returns this car parts node object with that key value.
	 * @param key
	 * @return this car part node with specified key value.
	 */
	public CarPartsNode searchList(int key) {
		CarPartsNode result = null;
		if (head == null)
			return null;
		CarPartsNode current = head;

		if (head.key == key) {
			result = head;
		} else {
			while (current.next != null) {
				if (current.next.key == key) {
					result = current.next;
				}
				current = current.next;

			}
		}
		return result;
	}

	/**
	 * This returns the amount of nodes in this part manager data structure.
	 * @return  an int value equal to the number of car part nodes in part manager.
	 */
	public int length() {
		int len = 1;
		if (head == null)
			return len - 1;
		CarPartsNode current = head;
		while (current.next != null) {
			len++;
			current = current.next;
		}
		return len;
	}

	/**
	 * This displays to the console all car part values in each node of this part manager data structure.
	 */
	public void printList() {
		CarPartsNode current = head;
		System.out.print("List: ");
		while (current != null) {
			System.out.print("\n\tStep: " + current.key + " \n" + current.part.image + " \n" + current.part.tools
					+ "\n " + current.part.instructions);
			current = current.next;
		}
	}


}
