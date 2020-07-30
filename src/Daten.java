import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Beeinhaltet und Laedt Daten fuer das Spiel
 * @author henri
 *
 */
public class Daten {
	//Neue Variablen
		int maxAnzahlLerneinheiten=100;
		
		/**
		 * Map mit dem Namen der Lerneinheit und dem Filenamen
		 */
		Map<String,String> VerfuegbareLerneinheiten = new HashMap<String,String>();
		
	public Daten() {
		/**
		 * Test Data
		 */

		VerfuegbareLerneinheiten.put("Englisch/Tiere/15","ExerciseEnglischTiere.txt"); 
		VerfuegbareLerneinheiten.put("Englisch/Business/15","ExerciseBusinessEnglisch.txt");
		VerfuegbareLerneinheiten.put("Spanisch/mittel/15","ExerciseEspanolBasics.txt");
		VerfuegbareLerneinheiten.put("Spanisch/leicht/15","ExerciseEspanolBasic2.txt");
		VerfuegbareLerneinheiten.put("T�rkisch/leicht/15","ExerciseTuerkishBasics.txt");
		VerfuegbareLerneinheiten.put("T�rkisch/mittel/15","ExerciseTuerkishBasics.txt2");
		VerfuegbareLerneinheiten.put("Klingonisch/leicht/15", "Klingonischleicht15.txt");
		VerfuegbareLerneinheiten.put("Klingonisch/mittel/30", "Klingolischmittel30.txt");
		//VerfuegbareLerneinheiten[3]="Italienisch 1"; 
	}
	/**
	 * Maximale Anzahl der Fragen.
	 * Standard:20
	 */
	int maxAnzahl = 100;
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
	public int getMaxAnzahlFragen() {
		int i;
		for(i=0;i<Fragen.length;i++) {
			if(Fragen[i]==null) {
				System.out.println("Maximale Anzahl der Fragen erkannt: "+i);
				return i;
			}
		}
		return i;
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
	 * Läscht alle zeichenumbräche und leerzeicehn aus einem String Zeilenumbruch:
	 * |13|10 Zeilenumbruch Zeerzeile: |13|10|13|10 58 = ":"
	 * 
	 * @param input
	 */
	public String CleanData(String input) {
		// Zeilenumbruch entfernen
		input = input.replace("\n", ":").replace("\r", "");
		input = input.replace("::", ":");
		input = input.replace("ö", "ä");
		input = input.replace("ä", "ä");
		// Assci Fehler

		// System.out.println("input: "+input);

		return input;
	}

	/**
	 * Erkennt ob es sich um Frage, Auswahl oder Antwort handelt und laed alle
	 * Elemente ab ":" in die jeweiligen Arrays
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
	 * Hole den Filename zu dem Namen einer Lerneinheit
	 * 
	 * @param einheitName Name der Lerneinheit
	 * 
	 * @return Der Filename zur Datei mit den Vokabeln
	 */
	public final String getFilenameForLerneinheit(String einheitName) {
		return VerfuegbareLerneinheiten.get(einheitName);
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
	 * Hole das Array mit den verfuegbaren Lerneinheiten
	 * 
	 * @return Das Array mit den Lerneinheiten
	 */
	public List<String> getLerneinheiten() {
		return VerfuegbareLerneinheiten.keySet().stream().collect(Collectors.toList());
	}
	
	/**
	 * Der Pfad er äbergeben wird darf kein Lokaler Pfad sein Falsch:
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
			// FileInputStream lieät immer ints
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
			e.printStackTrace();
			System.out.println("Datei wurde nicht gefunden!");
			return;
		} catch (IOException e) {
			System.out.println("Datei wurde nicht gefunden!");
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return;
		}
		System.out.println("Loading Successful:");
		//System.out.println(input);
		
		// ungewollte zeichen und zeilenumbrueche filtern
		input = CleanData(input);
		// System.out.println("Cleaned Data :" + input);
		matchWord_and_save(input);
	}
}
