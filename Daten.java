import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Beeinhaltet und L�dt Daten f�r das Spiel
 * @author henri
 *
 */
public class Daten {
	//Neue Variablen
		int maxAnzahlLerneinheiten=100;
		String[] geladeneLerneinheiten;
	public Daten() {
		/**
		 * Test Data
		 */
		geladeneLerneinheiten = new String[maxAnzahlLerneinheiten];
		geladeneLerneinheiten[0]="Englisch 1";
		geladeneLerneinheiten[1]="Englisch 2";
		geladeneLerneinheiten[2]="Spanisch 1";
		geladeneLerneinheiten[3]="Italienisch 1";
	}
	
	// Variablen vor Load Txt
	int maxAnzahl = 20;
	int maxAntwortAlternativen = 5;
	String[] Namen = new String[maxAnzahl];
	String[] Fragen = new String[maxAnzahl];
	String[] Antworten = new String[maxAnzahl];
	/**
	 * Antwort alternativen werten Spaltenweise in 2. index gespeichert.
	 * AntwortAlternativen[Kategorie][Auswahl(Einzelne Antworten)]
	 */
	String[][] AntwortAlternativen = new String[maxAnzahl][maxAntwortAlternativen];
		
	/**
	 * gibt inhalt des Arrays in Konsole aus
	 */
	public void showArray(String[] input) {
		// System.out.println("Inhalt des Arrays " + input);
		int i = 0;
		while (i < input.length) {
			// System.out.println("Speicherstelle " + i + " : " + input[i]);
			i++;
		}
	}

	/**
	 * gibt inhalt des Arrays in Konsole aus
	 */
	public void showArray(String[][] input) {
		System.out.println("Show 2d Array");
		System.out.println("Zeilen: " + input.length);
		System.out.println("Spalten: " + input[0].length);
		/**
		 * Kategorie ist eine Spalte mit den Auswahl-Alternativen Auswahl = die
		 * einzelenen Antwort Alternativen
		 */
		int KategorieMax = input.length;
		int AuswahlMax = input[0].length;
		for (int Kategorie = 0; Kategorie < KategorieMax; Kategorie++) {
			System.out.print("Kategorie: " + Kategorie + " ## ");
			for (int Auswahl = 0; Auswahl < AuswahlMax; Auswahl++) {
				System.out.print(input[Kategorie][Auswahl] + "|");
			}
			System.out.println();
		}
	}

	public void showInputData(String[] inputData) {
		int i3 = 0;
		while (i3 < inputData[i3].length()) {
			System.out.print(inputData[i3] + "|");
			i3++;
		}
	}

	//Eleminiert null speicherstellen in String
	public String ReArrange(String[] input) {
		for (int i = 0; i < input.length; i++) {
			if (input[i] == null) {
				// links schieben
				for (int i2 = i; i2 < input.length - 1; i2++) {
					input[i] = input[i + 1];
				}
			}
		}
		String temp = input.toString();
		return temp;
	}

	/**
	 * L�scht alle zeichenumbr�che und leerzeicehn aus einem String Zeilenumbruch:
	 * |13|10 Zeilenumbruch Zeerzeile: |13|10|13|10 58 = ":"
	 * 
	 * @param input
	 */
	public String CleanData(String input) {
		// Zeilenumbruch entfernen
		input = input.replace("\n", ":").replace("\r", "");
		input = input.replace("::", ":");
		input = input.replace("ö", "�");
		input = input.replace("ä", "�");
		// Assci Fehler

		// System.out.println("input: "+input);

		return input;
	}

	/**
	 * Erkennt ob es sich um Frage, Auswahl oder Antowort handelt und laed alle
	 * Elemente ab ":" in die jewiligen Arrays
	 * 
	 * @param inputWord
	 */
	public void matchWord_and_save(String inputString) {
		// System.out.println("Matche:" + inputString);
		String[] data = new String[inputString.length()];
		// System.out.println();
		data = inputString.split(":");
		for (int i = 0; i < data.length; i++) {
			if (i % 6 == 1) {
				Fragen[getFirstFreeIndex(Fragen)] = data[i];
				// System.out.println("Frage speichern: " + data[i]);
			}
			if (i % 6 == 3) {
				// AntwortAlternativen[getFirstFreeIndex(AntwortAlternativen)][0] = data[i];

				String temp = data[i];
				// System.out.println("Test:"+temp);
				String[] tempArr = new String[maxAntwortAlternativen];
				tempArr = temp.split(",");
				// System.out.println("In Array gespeichert");
				// System.out.println("Free Index at:" +
				// getFirstFreeIndex(AntwortAlternativen));
				int Kategorie = getFirstFreeIndex(AntwortAlternativen);
				for (int Auswahl = 0; Auswahl < tempArr.length; Auswahl++) {
					AntwortAlternativen[Kategorie][Auswahl] = tempArr[Auswahl];
					// System.out.print("Write: " + tempArr[Auswahl] + "|");
				}
			}
			if (i % 6 == 5) {
				Antworten[getFirstFreeIndex(Antworten)] = data[i];
				// System.out.println("Antwort speichern: " + data[i]);
			}
		}
	}

	/**
	 * Gibt ersten Freien Index des Arrays wieder als int
	 * 
	 * @param inputArray
	 * @return
	 */
	public int getFirstFreeIndex(String[] inputArray) {
		try {
			int i = 0;
			while (inputArray[i] != null && inputArray.length > i) {
				i++;
			}
			return i;
		} catch (Exception e) {
			// System.out.println("Out of Bounds");
		}
		return 0;

	}

	/**
	 * Gibt ersten Freien Index des Arrays wieder als int
	 * 
	 * @param inputArray
	 * @return
	 */
	public int getFirstFreeIndex(String[][] inputArray) {
		try {
			int i = 0;
			while (inputArray[i][0] != null && i < inputArray.length) {
				i++;
			}
			return i;
		} catch (Exception e) {
			// System.out.println("Out of Bounds");
		}
		return 0;
	}

	/**
	 * Der Pfad er �bergeben wird darf kein Lokaler Pfad sein Falsch:
	 * "C:\\Users\\henri\\eclipse-workspace\\TeamprojektLernprogramm\\src\\Lerneinheiten\\Exercise1"
	 * 
	 * Er muss zum Projekt Relativ sein, ausgehend von Source ordner Richtig:
	 * "src\\Lerneinheiten\\Exercise1"
	 */

	public void loadTxtFile(String path) {
		File inputFile = new File(path);
		String input = "";
		try {
			@SuppressWarnings("resource")
			FileInputStream loadFile = new FileInputStream(inputFile);
			// FileInputStream lie�t immer ints
			int timeout_after_iteration = 10000;
			int i = 0;
			while (loadFile.available() > 0) {
				if (i > timeout_after_iteration) {
					// System.out.println("Timeout");
					return;
				}
				int input_int = loadFile.read();
				input = input + Character.toString((char) input_int);
				i++;
			}
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			// System.out.println("Datei wurde nicht gefunden!");
			return;
		} catch (IOException e) {
			// System.out.println("Datei wurde nicht gefunden!");
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return;
		}
		System.out.println("Loading Successful:");
		System.out.println(input);
		// System.out.println("##########################");
		// ungewollte zeichen und zeilenumbr�che filtern
		input = CleanData(input);
		// System.out.println("Cleaned Data :" + input);
		matchWord_and_save(input);
	}
}
