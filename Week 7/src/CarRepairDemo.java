import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class CarRepairDemo {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		LinkedList<CarParts> ll = new LinkedList<CarParts>();

		int numLines = 0;
		BufferedReader br = null;
		String dataFile = "";
		int move = 0;
		System.out.println("Please enter in a repair form the list below: "
				+ "\n 1 -- Oil Change \n 2 -- Tire Change \n 3 -- Air Filter Change");
		int repair = input.nextInt();

		//this will allow the user to choose which repair they want to perform, and it reads it into a linked list.
		switch (repair) {
		case 1:
			dataFile = "/Users/coreyclark/Documents/CSIS 2420 PROJECTS/Week 7/src/Oil-Change";

			break;
		case 2:
			dataFile = "/Users/coreyclark/Documents/CSIS 2420 PROJECTS/Week 7/src/Tire-Change";

			break;
		case 3:
			dataFile = "/Users/coreyclark/Documents/CSIS 2420 PROJECTS/Week 7/src/Air-Filter";
		}
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));
		br = new BufferedReader(new FileReader(dataFile));

		String line = "";
		while (reader.readLine() != null) {
			numLines++;
		}
		reader.close();

		for (int i = 0; i < numLines / 3; i++) {
			line = br.readLine();
			if (line != null) {
				CarParts part = new CarParts(i);
				part.setImage(line);
				line = br.readLine();
				part.setTools(line);
				line = br.readLine();
				part.setInstructions(line);
				ll.add(part);
			}
		}
		br.close();

		//this allows the user to decide to see all steps at once or individually.
		System.out.println(
				"Would you like to see all of the steps now at once or in order? 0 all at once" + " 1 for in order.");
		move = input.nextInt();

		//if the user chooses to see the steps individually then this allows them to move forward and backward
		// through the steps.
		if (move == 0) {
			printList(ll);
		} else if (move == 1) {
			LinkedList<CarParts> newL = new LinkedList<CarParts>();
			ListIterator<CarParts> it = ll.listIterator();

			try {
				while (it.hasNext()) {
					
					System.out.println("\npush 0 to advance to the next step or " + "1 to go back a step.");
					move = input.nextInt();
					if (move == 0) {

						newL.push(it.next());
						System.out.println("STEP# " + newL.size());
						System.out.println(newL.peek().getImage());
						System.out.println(newL.peek().getTools());
						System.out.println(newL.peek().getInstructions());

					} else if (move == 1) {
						newL.pop();
						System.out.println("STEP# " + newL.size());
						System.out.println(newL.peek().getImage());
						System.out.println(newL.peek().getTools());
						System.out.println(newL.peek().getInstructions());
						it.previous();

					}

				}
			} catch (NullPointerException e) {
				System.out.println("You are on the last first step. <CAN NOT GO BACK ANY FURTHER>");
			}
		}

		input.close();

	}

	/**
	 * this displays/prints to the console all the steps of the repair from a parts manager object.
	 * @param ll
	 */
	private static void printList(LinkedList<CarParts> ll) {
		Iterator<CarParts> it = ll.iterator();

		while (it.hasNext()) {
			CarParts temp = it.next();
			System.out.print(temp.image + "\n");
			System.out.print(temp.tools + "\n");
			System.out.print(temp.getInstructions() + "\n");

		}
	}

	/**
	 * This takes a parts manager and a key value, and
	 * it returns the car part node in this parts manager that matches the key value.
	 * @param ll
	 * @param x
	 * @return this car part node from this parts manager that matches the key value.
	 */
	private static CarParts search(LinkedList<CarParts> ll, int x) {
		Iterator<CarParts> it = ll.iterator();
		CarParts value = null;
		System.out.print("List: ");

		while (it.hasNext()) {
			CarParts temp = it.next();
			if (temp.key == x) {
				return temp;
			} else

				value = ll.getFirst();
		}
		return value;
	}
}
