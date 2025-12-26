package p1;

public class Betrag {
	private int euro;
	private int cent;

	public Betrag(int euro, int cent) {
		setEuro(euro);
		setCent(cent);
	}

	public int getEuro() {
		return euro;
	}

	public void setEuro(int euro) {
		this.euro = euro;
	}

	public int getCent() {
		return cent;
	}

	public void setCent(int cent) {
		int i = 0;
		while (cent >= 100) {
			cent -= 100;
			i++;
		}
		setEuro(euro + i);
		this.cent = cent;
	}
	public String toString() {;
	return euro + "," + cent;
	}
}
