package p1;

public class P1_Main {
	public static void main(String[] args) {
		Betrag a = new Betrag(13, 60);
		Betrag b = new Betrag(14, 80);

		System.out.println("Euro: " + a.getEuro());
		System.out.println("Cent: " + a.getCent());
		System.out.println(summe(a,b));
	}

	public static Betrag summe(Betrag a, Betrag b) {
		Betrag s = new Betrag(a.getEuro() + b.getEuro(), a.getCent() + b.getCent());
		return s;
	}
}
