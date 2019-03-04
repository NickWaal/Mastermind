import java.util.Scanner;

public class Spel {

	int aantalBeurten = 12;
	int AantalCorrect = 0;
	int AantalAanwezig = 0;
	public String invoer;
	static codeGenerator w = new codeGenerator();
	static boolean stoppen = false;

	public void spelen() {
		System.out.println("Je speelt mastermind. Je moet een code van 4 letters raden binnen 12 beurten "
				+ "\nJe mag de letters a,b,c,d,e en f intypen. Typ q om te stoppen\n");

		while (stoppen == false && aantalBeurten > 0) {
			invoeren();
			aantalBeurten--;
			Check();
		}
	}

	public void invoerControleren(String s) {

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(0) != 'q' && s.charAt(i) != 'a' && s.charAt(i) != 'b'
					&& s.charAt(i) != 'c' && s.charAt(i) != 'd' && s.charAt(i) != 'e'
					&& s.charAt(i) != 'f') {
				System.out.println("De code " + s + " bevat onjuiste letters.");
				invoeren();
			}
		}

		if (s.length() > 4 && s.charAt(0) != 'q') {
			System.out.println("De ingevoerde code is te lang. Voer 4 letters in");
			invoeren();
		}

		else if (s.length() < 4 && s.charAt(0) != 'q') {
			System.out.println("De ingevoerde code is te kort. Voer 4 letters in");
			invoeren();
		}

		else if (s.charAt(0) == 'q') {
			stoppen = true;
			stoppen();
		}
	}

	public void Check() {
			AantalCorrect = 0;
			AantalAanwezig = 0;

			for (int i = 0; i < invoer.length(); i++) {
				juistePlek(i);
			}

			for (int i = 0; i < invoer.length(); i++) {
				// verkeerdePlek(i);
			}

			if (AantalCorrect == 4) {
				System.out.println("Je hebt de code geraden!");
				stoppen();
			} else if (AantalCorrect < 4 && AantalCorrect != 0) {
				System.out.println("Aantal letters op de goede plek: " + AantalCorrect + ".");
			}

			if (AantalAanwezig <= 4 && AantalAanwezig != 0) {
				System.out.println("Je hebt " + AantalAanwezig + " goed, maar niet op de juiste plek");
			}

			if (AantalCorrect == 0 && AantalAanwezig == 0) {
				System.out.println("Je hebt geen letters goed");
			}

			if (aantalBeurten > 0 && stoppen != true) {
				System.out.println("Je hebt nog " + aantalBeurten + " over");
			}

			else if (aantalBeurten == 0 && stoppen == false) {
				System.out.println("Je hebt de code niet geraden");
				stoppen();
				System.out.println("dit was de code: " + w.code);
			}
	}

	public void juistePlek(int i) {
		if (invoer.charAt(i) == w.code.charAt(i)) {
			AantalCorrect++;
		}
	}

	public void verkeerdePlek(int i) {

	}

	public void invoeren() {
		System.out.println("Toets je invoer in: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		invoer = scanner.nextLine();
		invoerControleren(invoer);
	}

	public void stoppen() {
		stoppen = true;
		System.out.println("Het spel is gestopt");
		System.exit(0);
	}

}