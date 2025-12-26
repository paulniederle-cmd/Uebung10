package p2;

public class String2 implements Editable {
	public String mainString;
	
	public String2(String s) {
		mainString = s;
	}
	
	public void addPrefix(String s) {
		mainString = s + mainString;
	}

	public void addPostfix(String s) {
		mainString += s;
	}
	public String toString() {
		return mainString;
	}

}
