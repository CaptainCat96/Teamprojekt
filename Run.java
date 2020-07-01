import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main Class
 * 
 * @author henri
 *
 */
@SuppressWarnings("serial")
public class Run extends JFrame implements ActionListener {
	/*
	 * #############################################################################
	 * #############################################################################
	 * ###### Allgemeine Variablen
	 */
	Daten daten = new Daten();
	// Fenster einstellungen
	int WindowSizeX1 = 0;
	int WindowSizeY1 = 0;
	int WindowSizeX2 = 800;
	int WindowSizeY2 = 800;
	/**
	 * Farbschema: Default,Schwarz, Blau, Rot
	 */
	public void ColorDesign() {
		String Ausgewählt="Default";
		Color Schwarz= new Color(0,0,0);
		String Blau= "#1736E6";
		String Rot= "#E30302";
	}
	
	
	
	public Run() {
		
		starte_FensterStartmenü();
	}
	
	public void setWindowDimension(int x1, int y1, int x2, int y2) {
		setBounds(x1, y1, x2, y2);
	}

	// Main Methode
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		Run run = new Run();
	}

	/*
	 * #############################################################################
	 * #############################################################################
	 * ###### Action Listener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// FensterStarmenü
		if (e.getSource() == Startmenü.btnZumSpiel) {
			ResetSpiel();
			starte_FensterSpiel();
			Startmenü.dispose();
		}
		if (e.getSource() == Startmenü.btnDeinProfil) {
			starte_Spielerprofil();
		}
		if (e.getSource() == Startmenü.btnEinstellungen) {
			starte_FensterEinstellungen();
		}
		// FensterSpiel
		if (e.getSource() == Spiel.btnNext) {
			GameWindow_nextQuestion();
		}
		if (e.getSource() == Spiel.buttonBack) {
			Highscore.dispose();
			Spiel.dispose();
			starte_FensterStartmenü();
		}
		// FensterSpielerprofil
		if (e.getSource() == Spielerprofil.buttonback) {
			Startmenü.dispose();
			starte_FensterStartmenü();
			;
		}
		// FensterHighscore
		if (e.getSource() == Highscore.btnZurckZumMen) {
			Highscore.dispose();
			Spiel.dispose();
			starte_FensterStartmenü();
		}
		//FensterEinstellungen
		if (e.getSource() == Einstellungen.buttonBack) {
			Einstellungen.dispose();
			starte_FensterStartmenü();
		}
	}

	/*
	 * #############################################################################
	 * #############################################################################
	 * ###### Fenster Logik
	 */
	FensterStartmenü Startmenü = new FensterStartmenü();

	public void starte_FensterStartmenü() {
		// Load Layout
		Startmenü.setWindowDimension(WindowSizeX1, WindowSizeY1, WindowSizeX2, WindowSizeY2);
		Startmenü.setVisible(true);
		// ActionListener
		Startmenü.btnZumSpiel.addActionListener(this);
		Startmenü.btnDeinProfil.addActionListener(this);
		Startmenü.btnEinstellungen.addActionListener(this);
		Startmenü.rdbtnTonAus.addActionListener(this);
	}

	FensterSpiel Spiel = new FensterSpiel();

	public void starte_FensterSpiel() {
		// Load Layout
		Spiel.setWindowDimension(WindowSizeX1, WindowSizeY1, WindowSizeX2, WindowSizeY2);
		Spiel.setVisible(true);
		// ActionListener
		Spiel.btnNext.addActionListener(this);
		Spiel.buttonBack.addActionListener(this);
		// Game Logik
		
		daten.loadTxtFile("src\\Lerneinheiten\\ExerciseBusinessEnglisch.txt");
		GameWindow_nextQuestion();// erste Frage einblenden
	}

	FensterSpielerprofil Spielerprofil = new FensterSpielerprofil();

	public void starte_Spielerprofil() {
		Spielerprofil.setWindowDimension(WindowSizeX1, WindowSizeY1, WindowSizeX2, WindowSizeY2);
		Spielerprofil.setVisible(true);
		// ActionListener
		Spielerprofil.buttonback.addActionListener(this);
	}

	FensterHighscore Highscore = new FensterHighscore();

	public void starte_FensterHighscore() {
		Highscore.setWindowDimension(WindowSizeX1, WindowSizeY1, WindowSizeX2, WindowSizeY2);
		Highscore.setVisible(true);
		// ActionListener
		Highscore.btnZurckZumMen.addActionListener(this);
	}
	
	FensterEinstellungen Einstellungen = new FensterEinstellungen();
	public void starte_FensterEinstellungen() {
		Einstellungen.setWindowDimension(WindowSizeX1, WindowSizeY1, WindowSizeX2, WindowSizeY2);
		Einstellungen.setVisible(true);
		// ActionListener
		Einstellungen.buttonBack.addActionListener(this);
	}
	/**
	 * #############################################################################
	 * #############################################################################
	 * ###### Spiel Logik
	 */
	//Variablen
	int aktuelleFrageIndex = 0;
	int maxAnzahlFragen = daten.maxAnzahl;
	String userAntwort, Lösung;
	// Variablen für Highscore statistiken
	int AnzahlFalscheAntworten = 0;
	int AnzahlRichtigeAntworten = 0;
	public void GameWindow_nextQuestion() {
		maxAnzahlFragen = daten.getFirstFreeIndex(daten.Fragen);
		if (aktuelleFrageIndex >= maxAnzahlFragen) {
			starte_FensterHighscore();
		}

		// Highscore
		if (Spiel.btnTree.isSelected()) {
			userAntwort = Spiel.btnTree.getText();
		}
		if (Spiel.btnHouse.isSelected()) {
			userAntwort = Spiel.btnHouse.getText();
		}
		if (Spiel.btnStreet.isSelected()) {
			userAntwort = Spiel.btnStreet.getText();
		}
		if (Spiel.btnPhone.isSelected()) {
			userAntwort = Spiel.btnPhone.getText();
		}

		// Bugfix: keine Antwort ausgewählt
		if (Spiel.btnTree.isSelected() == false && Spiel.btnHouse.isSelected() == false
				&& Spiel.btnStreet.isSelected() == false && Spiel.btnPhone.isSelected() == false) {
			userAntwort = "keine Antowrt ausgewählt!";
		}
		// Bei Init überspringen
		if (aktuelleFrageIndex != 0) {
			Lösung = (String) daten.Antworten[aktuelleFrageIndex - 1];
			System.out.println("Antwort ist: " + userAntwort);
			System.out.println("Lösung ist :" + Lösung);
			// Progress bar Aktualisieren
			Spiel.progressBar.setMaximum(maxAnzahlFragen);
			Spiel.progressBar.setValue(aktuelleFrageIndex);
			// Falls Frage falsch beantwortet
			if (userAntwort.equals(Lösung) == false) {
				AnzahlFalscheAntworten++;
				Spiel.lblStatusLetzteAntwort.setText("Falsch. Richtige Antwort war: " + Lösung);
				// lblStatusLetzteAntwort.setText("Falsch. Richtige Antwort war:"+Lösung+"(deine
				// Antwort: "+userAntwort+")");
			}
			// Falls Frage richtig beantwortet
			if (userAntwort.equals(Lösung)) {
				AnzahlRichtigeAntworten++;
				Spiel.lblStatusLetzteAntwort.setText("Richtig!");
			}
		}
		Spiel.btnTree.setText(daten.AntwortAlternativen[aktuelleFrageIndex][0]);
		Spiel.btnHouse.setText(daten.AntwortAlternativen[aktuelleFrageIndex][1]);
		Spiel.btnStreet.setText(daten.AntwortAlternativen[aktuelleFrageIndex][2]);
		Spiel.btnPhone.setText(daten.AntwortAlternativen[aktuelleFrageIndex][3]);
		Spiel.btnPencil.setVisible(false);
		Spiel.btnRabbit.setVisible(false);
		Spiel.txtWelchesWortIst.setText(daten.Fragen[aktuelleFrageIndex]);
		Spiel.FragenVerbleibend.setText(aktuelleFrageIndex + " von " + maxAnzahlFragen);
		aktuelleFrageIndex++;
		System.out.println("Nächste Frage");
	}
	/**
	 * #############################################################################
	 * #############################################################################
	 * ###### Hilfsmethoden
	 */
	public void ResetSpiel() {
		System.out.println("ResetSpiel");
		aktuelleFrageIndex = 0;
	}
	

}
