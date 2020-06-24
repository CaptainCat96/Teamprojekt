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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

/**
 * Main Class
 * 
 * @author henri
 *
 */
public class MainClass extends JFrame implements GrobStruktur, ActionListener {
	// Variablen vor Load Txt
	int maxAnzahl = 20;
	int maxAntwortAlternativen = 5;
	String[] Namen = new String[maxAnzahl];
	String[] Fragen = new String[maxAnzahl];
	String[] Antworten = new String[maxAnzahl];
	int WindowSizeX = 800;
	int WindowSizeY = 800;
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
		this.setSize(WindowSizeX, WindowSizeY);
		this.setVisible(true);

		getContentPane().setLayout(null);
		showStartmenu();
	}

	// Main Methode
	public static void main(String args[]) {
		MainClass testRun = new MainClass();
		// testRun.loadTxtFile("src/Lerneinheiten/ExerciseBusinessEnglisch.txt");
		// debug
		/**
		 * testRun.showArray(testRun.Antworten); testRun.showArray(testRun.Fragen);
		 * testRun.tfFrage.setText(testRun.Fragen[0]);
		 * testRun.tfAntwort.setText(testRun.Antworten[0]);
		 * testRun.tfAuswahl1.setText(testRun.AntwortAlternativen[0][0]);
		 * testRun.tfAuswahl2.setText(testRun.AntwortAlternativen[0][1]);
		 * testRun.tfAuswahl3.setText(testRun.AntwortAlternativen[0][2]);
		 * testRun.tfAuswahl4.setText(testRun.AntwortAlternativen[0][3]);
		 * testRun.showArray(testRun.AntwortAlternativen);
		 */
	}

	/**
	 * ##################################################################
	 * ##################################################################
	 * Hilfsmethoden f�r die GUI
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			System.out.println("btnStart");
		}
		/**
		 * Start Screen
		 */
		if (e.getSource() == btnZumSpiel) {
			hideAllPanels();
			System.out.println("btnZumSpiel");
			showGameWindow();

			// GameDesign frame = new GameDesign();
			// frame.setVisible(true);
		}
		if (e.getSource() == btnDeinProfil) {
			hideAllPanels();
			showSpielerprofil();

		}
		if (e.getSource() == btnEinstellungen) {
			hideAllPanels();
			System.out.println("btnEinstellungen");
		}
		/**
		 * Game Screen
		 */
		if (e.getSource() == ButtonBack) {
			hideAllPanels();
			showStartmenu();
			System.out.println("ButtonBack");
		}
		if (e.getSource() == btnNext) {
			GameWindow_nextQuestion();
			System.out.println("btnNext");
		}
		if (e.getSource() == btnZurckZumMen) {
			hideAllPanels();
			showStartmenu();
			System.out.println("btnZurckZumMen");
		}
		/**
		 * Spieler Profil
		 */
		if (e.getSource() == BackButtonSpielerProfil) {
			hideAllPanels();
			showStartmenu();
			System.out.println("BackButtonSpielerProfil");
		}
	}

	/**
	 * Schaltet alle JPanels des Programm auf .visible(false)
	 */
	public void hideAllPanels() {
		PanelGame.setVisible(false);
		PanelStartmenu.setVisible(false);
		PanelSpielerprofil.setVisible(false);
	}

	public void showStartmenu() {
		FensterStartmenu();
		PanelStartmenu.setVisible(true);
	}

	public void showGameWindow() {
		loadTxtFile("src\\Lerneinheiten\\ExerciseBusinessEnglisch.txt");
		GameWindow();
		GameWindow_nextQuestion();// erste Frage einblenden
		PanelGame.setVisible(true);
	}

	public void showSpielerprofil() {
		Spielerprofil();
		PanelSpielerprofil.setVisible(true);
	}

	public void showHighScore() {

		Highscore();
		PanelHighscore.setVisible(true);
	}

	int aktuelleFrageIndex = 0;
	int maxAnzahlFragen;

	public void GameWindow_nextQuestion() {
		maxAnzahlFragen = getFirstFreeIndex(Fragen);
		if (aktuelleFrageIndex >= maxAnzahlFragen) {
			hideAllPanels();
			showHighScore();
		}
		System.out.println("N�chste Frage");

		btnTree.setText(AntwortAlternativen[aktuelleFrageIndex][0]);
		btnHouse.setText(AntwortAlternativen[aktuelleFrageIndex][1]);
		btnStreet.setText(AntwortAlternativen[aktuelleFrageIndex][2]);
		btnPhone.setText(AntwortAlternativen[aktuelleFrageIndex][3]);
		btnPencil.setVisible(false);
		btnRabbit.setVisible(false);
		txtWelchesWortIst.setText(Fragen[aktuelleFrageIndex]);
		FragenVerbleibend.setText(aktuelleFrageIndex + " von " + maxAnzahlFragen);
		aktuelleFrageIndex++;
	}

	/**
	 * ##################################################################
	 * ################################################################## GUI-Seiten
	 */
	JPanel PanelStartmenu = new JPanel();
	JButton btnZumSpiel, btnDeinProfil, btnEinstellungen;

	public void FensterStartmenu() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\berka\\eclipse-workspace\\Teamprojekt\\src\\icons8-erinnerung-48.png"));
		setTitle("Teamprojekt 2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 512);
		PanelStartmenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelStartmenu);
		PanelStartmenu.setLayout(null);

		btnZumSpiel = new JButton("Zum Spiel");
		btnZumSpiel.setBounds(289, 189, 104, 23);
		btnZumSpiel.addActionListener(this);
		PanelStartmenu.add(btnZumSpiel);

		btnDeinProfil = new JButton("Dein Profil");
		btnDeinProfil.setBounds(289, 223, 104, 23);
		btnDeinProfil.addActionListener(this);
		PanelStartmenu.add(btnDeinProfil);

		btnEinstellungen = new JButton("Einstellungen");
		btnEinstellungen.setBounds(289, 258, 104, 23);
		btnEinstellungen.addActionListener(this);
		PanelStartmenu.add(btnEinstellungen);

		JRadioButton rdbtnTonAus = new JRadioButton("Ton aus");
		rdbtnTonAus.setBounds(302, 443, 109, 23);
		PanelStartmenu.add(rdbtnTonAus);

		JLabel lblLetsLearn = new JLabel("Let's Learn !");
		lblLetsLearn.setIcon(
				new ImageIcon("C:\\Users\\berka\\eclipse-workspace\\Teamprojekt\\src\\icons8-erinnerung-48.png"));
		lblLetsLearn.setFont(new Font("Yu Gothic Light", Font.PLAIN, 25));
		lblLetsLearn.setBounds(247, 33, 226, 73);
		PanelStartmenu.add(lblLetsLearn);
	}

	JPanel PanelGame = new JPanel();
	private JPanel contentPane;
	private JLabel txtWelchesWortIst, txtBaum;
	private JRadioButton btnTree, btnRabbit, btnStreet, btnPhone, btnPencil, btnHouse;
	private JLabel FragenVerbleibend;
	private ButtonGroup bg = new ButtonGroup();
	JButton ButtonBack, btnNext;

	public void GameWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		ButtonBack = new JButton("Back");
		ButtonBack.setBounds(190, 79, 59, 20);
		ButtonBack.addActionListener(this);
		PanelGame.add(ButtonBack);
		bg.add(ButtonBack);

		PanelGame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelGame);
		PanelGame.setLayout(null);

		txtWelchesWortIst = new JLabel();
		txtWelchesWortIst.setIcon(new ImageIcon("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		txtWelchesWortIst.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		txtWelchesWortIst.setText("Welches Wort ist die richtige \u00DCbersetzung f\u00FCr ...");
		txtWelchesWortIst.setBounds(39, 30, 317, 39);
		PanelGame.add(txtWelchesWortIst);
		/**
		 * 
		 * txtBaum = new JLabel(); txtBaum.setFont(new Font("Yu Gothic UI Light",
		 * Font.BOLD, 13)); txtBaum.setText("Baum ?"); txtBaum.setBounds(190, 79, 59,
		 * 20); PanelGame.add(txtBaum);
		 */

		btnTree = new JRadioButton("tree");
		btnTree.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnTree.setBounds(39, 163, 89, 23);
		PanelGame.add(btnTree);
		bg.add(btnTree);

		btnRabbit = new JRadioButton("rabbit");
		btnRabbit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnRabbit.setBounds(160, 163, 89, 23);
		PanelGame.add(btnRabbit);
		bg.add(btnRabbit);

		btnStreet = new JRadioButton("street");
		btnStreet.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnStreet.setBounds(278, 164, 89, 23);
		PanelGame.add(btnStreet);
		bg.add(btnStreet);

		btnPhone = new JRadioButton("phone");
		btnPhone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnPhone.setBounds(39, 130, 89, 23);
		PanelGame.add(btnPhone);
		bg.add(btnPhone);

		btnPencil = new JRadioButton("pencil");
		btnPencil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnPencil.setBounds(160, 130, 89, 23);
		PanelGame.add(btnPencil);
		bg.add(btnPencil);

		btnHouse = new JRadioButton("house");
		btnHouse.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnHouse.setBounds(278, 130, 89, 23);
		PanelGame.add(btnHouse);
		bg.add(btnHouse);

		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		btnNext.setBounds(160, 214, 89, 23);
		btnNext.addActionListener(this);
		PanelGame.add(btnNext);

		FragenVerbleibend = new JLabel("0/15");
		FragenVerbleibend.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		FragenVerbleibend.setBounds(378, 219, 46, 14);
		PanelGame.add(FragenVerbleibend);
	}

	/**
	 * veraltet
	 */
	
	public void showStartScreenOld() {
		JLabel lblLernprogrammVersion = new JLabel("Lernprogramm Version 1.0");
		lblLernprogrammVersion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLernprogrammVersion.setForeground(Color.MAGENTA);
		lblLernprogrammVersion.setBounds(10, 25, 464, 23);
		getContentPane().add(lblLernprogrammVersion);

		JList list = new JList();
		list.setBounds(20, 75, 200, 196);
		getContentPane().add(list);

		JLabel lblLerneinheit = new JLabel("Lerneinheit ausw\u00E4hlen:");
		lblLerneinheit.setBounds(10, 50, 279, 14);
		getContentPane().add(lblLerneinheit);

		JButton btnStart = new JButton("Start");
		btnStart.setBounds(252, 154, 89, 23);
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
	}

	JPanel PanelHighscore = new JPanel();
	JButton btnZurckZumMen;

	public void Highscore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelHighscore.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelHighscore);
		PanelHighscore.setLayout(null);

		JLabel lblHierIstDein = new JLabel("Hier ist dein Highscore !");
		lblHierIstDein.setIcon(
				new ImageIcon("C:\\Users\\beytullah\\eclipse-workspace\\Teamprojekt\\src\\icons8-erinnerung-48.png"));
		lblHierIstDein.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 25));
		lblHierIstDein.setBounds(74, 11, 312, 103);
		PanelHighscore.add(lblHierIstDein);

		JLabel lblDuHastBisher = new JLabel("Du hast bisher ");
		lblDuHastBisher.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblDuHastBisher.setBounds(146, 81, 135, 56);
		PanelHighscore.add(lblDuHastBisher);

		JLabel lblAnzahl = new JLabel("XY W\u00F6rter");
		lblAnzahl.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 18));
		lblAnzahl.setBounds(156, 112, 102, 56);
		PanelHighscore.add(lblAnzahl);

		JLabel lblKorrektBeantwortet = new JLabel("am St\u00FCck korrekt beantwortet !");
		lblKorrektBeantwortet.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblKorrektBeantwortet.setBounds(92, 158, 252, 25);
		PanelHighscore.add(lblKorrektBeantwortet);

		JLabel lblMaximalKannst = new JLabel("maximal kannst 45 Punkte mit den geladenen Vokabelpaketen erreichen.");
		lblMaximalKannst.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblMaximalKannst.setBounds(60, 236, 350, 14);
		PanelHighscore.add(lblMaximalKannst);

		btnZurckZumMen = new JButton("zur\u00FCck zum Men\u00FC");
		btnZurckZumMen.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnZurckZumMen.setBounds(0, 0, 128, 23);
		btnZurckZumMen.addActionListener(this);
		PanelHighscore.add(btnZurckZumMen);
	}

	JButton btnStart = new JButton("Start");

	@Override
	public void showStartScreen(boolean b) {
		// TODO Auto-generated method stub

		JList list = new JList();
		list.setBounds(20, 75, 200, 36);
		getContentPane().add(list);

		JLabel lblLerneinheit = new JLabel("Lerneinheit ausw\u00E4hlen:");
		lblLerneinheit.setBounds(10, 50, 279, 14);
		getContentPane().add(lblLerneinheit);

		btnStart.setBounds(230, 85, 89, 23);
		btnStart.addActionListener(this);
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

		// ActionListener

	}

	JPanel PanelSpielerprofil = new JPanel();
	JButton BackButtonSpielerProfil;

	public void Spielerprofil() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelSpielerprofil = new JPanel();
		PanelSpielerprofil.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelSpielerprofil);
		PanelSpielerprofil.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		label.setBounds(336, 23, 48, 48);
		PanelSpielerprofil.add(label);

		BackButtonSpielerProfil = new JButton("<--  Back ");
		BackButtonSpielerProfil.setBounds(10, 227, 89, 23);
		PanelSpielerprofil.add(BackButtonSpielerProfil);
		BackButtonSpielerProfil.addActionListener(this);

		JLabel lblUserprofile = new JLabel("Userprofile");
		lblUserprofile.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblUserprofile.setBounds(154, 23, 98, 29);
		PanelSpielerprofil.add(lblUserprofile);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(50);
		progressBar.setValue(10);
		progressBar.setBounds(246, 139, 146, 14);
		PanelSpielerprofil.add(progressBar);

		JLabel lblUsernameMaxMustermann = new JLabel("Username: Max Mustermann");
		lblUsernameMaxMustermann.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblUsernameMaxMustermann.setBounds(43, 71, 161, 23);
		PanelSpielerprofil.add(lblUsernameMaxMustermann);

		JLabel lblAge = new JLabel("Age: 25");
		lblAge.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblAge.setBounds(43, 105, 79, 23);
		PanelSpielerprofil.add(lblAge);

		JLabel lblCurrentStatus = new JLabel("Current Status:");
		lblCurrentStatus.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblCurrentStatus.setBounds(43, 139, 79, 14);
		PanelSpielerprofil.add(lblCurrentStatus);

		JLabel lblEnglish = new JLabel("English (10/50)");
		lblEnglish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblEnglish.setBounds(147, 139, 89, 14);
		PanelSpielerprofil.add(lblEnglish);

		JLabel lblSpanish = new JLabel("Spanish (40/50)");
		lblSpanish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblSpanish.setBounds(147, 164, 89, 15);
		PanelSpielerprofil.add(lblSpanish);

		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setValue(40);
		progressBar_1.setMaximum(50);
		progressBar_1.setBounds(246, 165, 146, 14);
		PanelSpielerprofil.add(progressBar_1);

		JLabel lblTurkish = new JLabel("Turkish (20/50)");
		lblTurkish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblTurkish.setBounds(147, 190, 92, 14);
		PanelSpielerprofil.add(lblTurkish);

		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setValue(20);
		progressBar_2.setMaximum(50);
		progressBar_2.setBounds(246, 190, 146, 14);
		PanelSpielerprofil.add(progressBar_2);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 71, 17, 147);
		PanelSpielerprofil.add(scrollBar);
	}

	/**
	 * ##################################################################
	 * ################################################################## Weiter
	 * Methoden
	 */
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

	/**
	 * Eleminiert null speicherstellen in String
	 * 
	 * @param input
	 * @return
	 */
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
