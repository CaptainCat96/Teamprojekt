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
		String Ausgewaehlt="Default";
		Color Schwarz= new Color(0,0,0);
		String Blau= "#1736E6";
		String Rot= "#E30302";
	}
	
	
	
	public Run() {
		
		starte_FensterStartmenue();
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
		// FensterStarmenue
		if (e.getSource() == Startmenue.btnZumSpiel) {
			ResetSpiel();
			starte_FensterSpiel(Startmenue.holeAusgewaehltesSpiel());
			Startmenue.dispose();
		}
		if (e.getSource() == Startmenue.btnDeinProfil) {
			starte_Spielerprofil();
		}
		if (e.getSource() == Startmenue.btnEinstellungen) {
			starte_FensterEinstellungen();
		}
		// FensterSpiel
		if (e.getSource() == Spiel.btnNext) {
			GameWindow_nextQuestion();
		}
		if (e.getSource() == Spiel.buttonBack) {
			Highscore.dispose();
			Spiel.dispose();
			starte_FensterStartmenue();
		}
		// FensterSpielerprofil
		if (e.getSource() == Spielerprofil.buttonback) {
			Startmenue.dispose();
			starte_FensterStartmenue();
			;
		}
		// FensterHighscore
		if (e.getSource() == Highscore.btnZurckZumMen) {
			Highscore.dispose();
			Spiel.dispose();
			starte_FensterStartmenue();
		}
		//FensterEinstellungen
		if (e.getSource() == Einstellungen.buttonBack) {
			Einstellungen.dispose();
			starte_FensterStartmenue();
		}
	}

	/*
	 * #############################################################################
	 * #############################################################################
	 * ###### Fenster Logik
	 */
	FensterStartmenue Startmenue = new FensterStartmenue(daten);

	public void starte_FensterStartmenue() {
		// Load Layout
		Startmenue.setWindowDimension(WindowSizeX1, WindowSizeY1, WindowSizeX2, WindowSizeY2);
		Startmenue.setVisible(true);
		// ActionListener
		Startmenue.btnZumSpiel.addActionListener(this);
		Startmenue.btnDeinProfil.addActionListener(this);
		Startmenue.btnEinstellungen.addActionListener(this);
		Startmenue.rdbtnTonAus.addActionListener(this);
	}

	FensterSpiel Spiel = new FensterSpiel();

	public void starte_FensterSpiel(String lernEinheit) {
		// Load Layout
		Spiel.setWindowDimension(WindowSizeX1, WindowSizeY1, WindowSizeX2, WindowSizeY2);
		Spiel.setVisible(true);
		// ActionListener
		Spiel.btnNext.addActionListener(this);
		Spiel.buttonBack.addActionListener(this);
		// Game Logik

		String dateiname = daten.getFilenameForLerneinheit(lernEinheit);
		if(dateiname != null) {
			System.out.println("Lade Spieldaten: " + "src\\Lerneinheiten\\" + dateiname);
			daten.loadTxtFile("src\\Lerneinheiten\\" + dateiname);
			//daten.loadTxtFile("src/Lerneinheiten/" + dateiname);
			GameWindow_nextQuestion();// erste Frage einblenden
		} else {
			System.err.println("Keine Datei für Lerneinheit " + lernEinheit);
		}
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
	String userAntwort, Loesung;
	// Variablen f�r Highscore statistiken
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
			userAntwort = "keine Antowrt ausgew�hlt!";
		}
		// Bei Init überspringen
		if (aktuelleFrageIndex != 0) {
			Loesung = daten.Antworten[aktuelleFrageIndex - 1];
			System.out.println("Antwort ist: " + userAntwort);
			System.out.println("Loesung ist :" + Loesung);
			// Progress bar Aktualisieren
			Spiel.progressBar.setMaximum(maxAnzahlFragen);
			Spiel.progressBar.setValue(aktuelleFrageIndex);
			// Falls Frage falsch beantwortet
			if (userAntwort.equals(Loesung) == false) {
				AnzahlFalscheAntworten++;
				Spiel.lblStatusLetzteAntwort.setText("Falsch. Richtige Antwort war: " + Loesung);
				// lblStatusLetzteAntwort.setText("Falsch. Richtige Antwort war:"+L�sung+"(deine
				// Antwort: "+userAntwort+")");
			}
			// Falls Frage richtig beantwortet
			if (userAntwort.equals(Loesung)) {
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
