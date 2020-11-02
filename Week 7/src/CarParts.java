/**
 * 
 * @author coreyclark
 * This Class implements a node from a car parts object.
 */
public class CarParts {

	int key;
	String image;
	String tools;
	String instructions;

	/**
	 * This constructs a car part object and it takes a key value, an image, tools, and a set of instructions. 
	 * and it sets two additional car part node object pointers to null.
	 * @param key
	 * @param image
	 * @param tools
	 * @param instructions
	 */
	public CarParts(int key, String image, String tools, String instructions) {
		this.key = key;
		this.image = image;
		this.tools = tools;
		this.instructions = instructions;
	}

	/**
	 * This overloads and constructs a car part object and it takes a key value. 
	 * and it sets two additional car part node object pointers to null.
	 * @param key
	 */
	public CarParts(int key) {
		this.key = key;
	}
	public CarParts() {
		
	}

	/**
	 * This sets this image.
	 * @param i
	 */
	public void setImage(String i) {
		this.image = i;
	}

	/**
	 * This sets this tools.
	 * @param t
	 */
	public void setTools(String t) {
		this.tools = t;
	}

	/**
	 * This sets this Instructions.
	 * @param in
	 */
	public void setInstructions(String in) {
		this.instructions = in;
	}

	/**
	 * This returns this car part's image.
	 * @return
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * This returns this car part's tools'.
	 * @return
	 */
	public String getTools() {
		return tools;
	}

	/**
	 * This returns this car parts Instructions.
	 * @return
	 */
	public String getInstructions() {

		return instructions;

	}

}
