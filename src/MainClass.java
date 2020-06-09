import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Array;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

/**
 * Main Class
 * 
 * @author henri
 *
 */
public class MainClass extends JFrame implements GrobStruktur {
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
	private JTextField tfFrage;
	private JTextField tfAuswahl1;
	private JTextField tfAntwort;
	private JTextField tfAuswahl3;
	private JTextField tfAuswahl4;
	private JTextField tfAuswahl2;

	// Konstruktor
	public MainClass() {
		this.setSize(500, 500);
		getContentPane().setLayout(null);
		/**
		 * Layout Design der Hauptseite
		 */
		JLabel lblLernprogrammVersion = new JLabel("Lernprogramm Version 1.0");
		lblLernprogrammVersion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLernprogrammVersion.setForeground(Color.MAGENTA);
		lblLernprogrammVersion.setBounds(10, 25, 464, 23);
		getContentPane().add(lblLernprogrammVersion);

		JList list = new JList();
		list.setBounds(20, 75, 200, 36);
		getContentPane().add(list);

		JLabel lblLerneinheit = new JLabel("Lerneinheit ausw\u00E4hlen:");
		lblLerneinheit.setBounds(10, 50, 279, 14);
		getContentPane().add(lblLerneinheit);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(230, 85, 89, 23);
		getContentPane().add(btnStart);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 474, 21);
		getContentPane().add(menuBar);

		JMenuItem mntmEinstellungen = new JMenuItem("Einstellungen");
		mntmEinstellungen.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmEinstellungen);

		JMenuItem mntmProfil = new JMenuItem("Profil");
		mntmProfil.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmProfil);

		JMenuItem mntmLerneinheitNeuHinzufgen = new JMenuItem("Lerneinheit neu hinzuf\u00FCgen");
		mntmLerneinheitNeuHinzufgen.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmLerneinheitNeuHinzufgen);

		tfFrage = new JTextField();
		tfFrage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfFrage.setBounds(10, 162, 326, 20);
		getContentPane().add(tfFrage);
		tfFrage.setColumns(10);

		JLabel lblFrage = new JLabel("Frage");
		lblFrage.setBounds(10, 143, 46, 14);
		getContentPane().add(lblFrage);

		JLabel lblAuswahl = new JLabel("Auswahl");
		lblAuswahl.setBounds(10, 193, 46, 14);
		getContentPane().add(lblAuswahl);

		JLabel lblAntwort = new JLabel("Antwort");
		lblAntwort.setBounds(10, 280, 46, 14);
		getContentPane().add(lblAntwort);

		tfAuswahl1 = new JTextField();
		tfAuswahl1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAuswahl1.setColumns(10);
		tfAuswahl1.setBounds(10, 218, 200, 20);
		getContentPane().add(tfAuswahl1);

		tfAntwort = new JTextField();
		tfAntwort.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAntwort.setColumns(10);
		tfAntwort.setBounds(10, 320, 326, 20);
		getContentPane().add(tfAntwort);
		
		tfAuswahl3 = new JTextField();
		tfAuswahl3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAuswahl3.setColumns(10);
		tfAuswahl3.setBounds(230, 218, 200, 20);
		getContentPane().add(tfAuswahl3);
		
		tfAuswahl4 = new JTextField();
		tfAuswahl4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAuswahl4.setColumns(10);
		tfAuswahl4.setBounds(230, 249, 200, 20);
		getContentPane().add(tfAuswahl4);
		
		tfAuswahl2 = new JTextField();
		tfAuswahl2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfAuswahl2.setColumns(10);
		tfAuswahl2.setBounds(10, 249, 200, 20);
		getContentPane().add(tfAuswahl2);
		this.setVisible(true);

	}

	// Main Methode
	public static void main(String args[]) {
		MainClass testRun = new MainClass();
		testRun.loadTxtFile("src/Lerneinheiten/ExerciseBusinessEnglisch.txt");
		// debug
		testRun.showArray(testRun.Antworten);
		testRun.showArray(testRun.Fragen);
		testRun.tfFrage.setText(testRun.Fragen[0]);
		testRun.tfAntwort.setText(testRun.Antworten[0]);
		testRun.tfAuswahl1.setText(testRun.AntwortAlternativen[0][0]);
		testRun.tfAuswahl2.setText(testRun.AntwortAlternativen[0][1]);
		testRun.tfAuswahl3.setText(testRun.AntwortAlternativen[0][2]);
		testRun.tfAuswahl4.setText(testRun.AntwortAlternativen[0][3]);
		testRun.showArray(testRun.AntwortAlternativen);
	}

	@Override
	public void showStartScreen(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showExerciseLayout(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showHighscoreLayout(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showErrungsenschaftenlayot(boolean b) {
		// TODO Auto-generated method stub

	}

	/**
	 * gibt inhalt des Arrays in Konsole aus
	 */
	public void showArray(String[] input) {
		//System.out.println("Inhalt des Arrays " + input);
		int i = 0;
		while (i < input.length) {
			//System.out.println("Speicherstelle " + i + " : " + input[i]);
			i++;
		}
	}
	/**
	 * gibt inhalt des Arrays in Konsole aus
	 */
	public void showArray(String[][] input) {
		System.out.println("Show 2d Array");
		System.out.println("Zeilen: "+input.length);
		System.out.println("Spalten: "+input[0].length);
		/**
		 * Kategorie ist eine Spalte mit den Auswahl-Alternativen
		 * Auswahl = die einzelenen Antwort Alternativen
		 */
		int KategorieMax = input.length;
		int AuswahlMax = input[0].length;
		for(int Kategorie=0;Kategorie<KategorieMax;Kategorie++) {
			System.out.print("Kategorie: "+Kategorie+" ## ");
			for(int Auswahl=0;Auswahl<AuswahlMax;Auswahl++) {
				System.out.print(input[Kategorie][Auswahl]+"|");
			}
			System.out.println();
		}
	}

	public void showInputData(String[] inputData) {
		int i3 = 0;
		while (i3 < inputData[i3].length()) {
			System.out.print(inputData[i3]+"|");
			i3++;
		}
	}
	/**
	 * Eleminiert null speicherstellen in String
	 * @param input
	 * @return
	 */
	public String ReArrange(String[] input) {
		for(int i=0; i<input.length;i++) {
			if(input[i]==null) {
				//links schieben
				for(int i2=i; i2<input.length-1;i2++) {
					input[i]=input[i+1];
				}
			}
		}
		String temp = input.toString();
		return temp;
	}
	/**
	 * L�scht alle zeichenumbr�che und leerzeicehn aus einem String Zeilenumbruch:
	 * |13|10 Zeilenumbruch Zeerzeile: |13|10|13|10
	 * 58 = ":"
	 * 
	 * @param input
	 */
	public String CleanData(String input) {
		//Zeilenumbruch entfernen
		input = input.replace("\n", ":").replace("\r", "");
		input = input.replace("::", ":");
		//System.out.println("input: "+input);
		
		return input;
	}

	/**
	 * Erkennt ob es sich um Frage, Auswahl oder Antowort handelt und laed alle
	 * Elemente ab ":" in die jewiligen Arrays
	 * 
	 * @param inputWord
	 */
	public void matchWord_and_save(String inputString) {
		//System.out.println("Matche:" + inputString);
		String[] data = new String[inputString.length()];
		//System.out.println();
		data = inputString.split(":");
		for (int i = 0; i < data.length; i++) {
			if (i % 6 == 1) {
				Fragen[getFirstFreeIndex(Fragen)] = data[i];
				//System.out.println("Frage speichern:  " + data[i]);
			}
			if (i % 6 == 3) {
				//AntwortAlternativen[getFirstFreeIndex(AntwortAlternativen)][0] = data[i];
				
				String temp = data[i];
				//System.out.println("Test:"+temp);
				String[] tempArr = new String[maxAntwortAlternativen];
				tempArr= temp.split(",");
				System.out.println("In Array gespeichert");
				System.out.println("Free Index at:"+getFirstFreeIndex(AntwortAlternativen));
				int Kategorie=getFirstFreeIndex(AntwortAlternativen);
				for(int Auswahl=0;Auswahl<tempArr.length;Auswahl++) {
					AntwortAlternativen[Kategorie][Auswahl] = tempArr[Auswahl];
					System.out.print("Write: "+tempArr[Auswahl]+"|");
				}
			}
			if (i % 6 == 5) {
				Antworten[getFirstFreeIndex(Antworten)] = data[i];
				//System.out.println("Antwort speichern: " + data[i]);
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
			//System.out.println("Out of Bounds");
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
			//System.out.println("Out of Bounds");
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
	@Override
	public void loadTxtFile(String path) {
		File inputFile = new File(path);
		String input = "";
		try {
			FileInputStream loadFile = new FileInputStream(inputFile);
			// FileInputStream lie�t immer ints
			int timeout_after_iteration = 10000;
			int i = 0;
			while (loadFile.available() > 0) {
				if (i > timeout_after_iteration) {
					//System.out.println("Timeout");
					return;
				}
				int input_int = loadFile.read();
				input = input + Character.toString((char) input_int);
				i++;
			}
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			//System.out.println("Datei wurde nicht gefunden!");
			return;
		} catch (IOException e) {
			//System.out.println("Datei wurde nicht gefunden!");
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return;
		}
		//System.out.println("Loading Successful:");
		// //System.out.println(input);
		//System.out.println("##########################");
		// ungewollte zeichen und zeilenumbr�che filtern
		input = CleanData(input);
		//System.out.println("Cleaned Data :" + input);
		matchWord_and_save(input);
	}

	@Override
	public void loadProfile(File inputFile) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveProfile(File inputFile) {
		// TODO Auto-generated method stub

	}

	@Override
	public void spielAblauf() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameEvent_nextExercise() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameEvent_nextQuestion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameEvent_ShowHighscore() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameEvent_quit() {
		// TODO Auto-generated method stub

	}
}
