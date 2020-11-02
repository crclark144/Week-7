import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CarRepairDemo2 {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		PartsManager linky = new PartsManager();

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
				CarParts part = new CarParts(i + 1);
				part.setImage(line);
				line = br.readLine();
				part.setTools(line);
				line = br.readLine();
				part.setInstructions(line);
				linky.append(part);
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
			linky.printList();
		} else if (move == 1) {
			PartsManager newLinky = new PartsManager();
			Iter it = new Iter(linky);

			try {
				while (it.hasNext()) {

					System.out.println("\npush 0 to advance to the next step or " + "1 to go back a step.");
					move = input.nextInt();
					if (move == 0) {
						newLinky.pushPrepend(it.nextPart());
						System.out.println("STEP# " + newLinky.length());
						System.out.println(newLinky.peek().part.getImage());
						System.out.println(newLinky.peek().part.getTools());
						System.out.println(newLinky.peek().part.getInstructions());	

					} else if (move == 1) {
						newLinky.pop();
						System.out.println("STEP# " + newLinky.length());
						System.out.println(newLinky.peek().part.getImage());
						System.out.println(newLinky.peek().part.getTools());
						System.out.println(newLinky.peek().part.getInstructions());
						it.previous();

					}

				}
			} catch (NullPointerException e) {
				System.out.println("You are on the last first step. <CAN NOT GO BACK ANY FURTHER>");
			}
		}

		input.close();

	}

}
