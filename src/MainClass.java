import java.io.File;

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
/**
 * Main Class
 * @author henri
 *
 */
public class MainClass extends JFrame implements GrobStruktur{
	//Konstruktor
	public MainClass() {
		this.setSize(500,500);
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
		this.setVisible(true);
	}
	//Main Methode
	public static void main(String args[]) {
		MainClass testRun = new MainClass();
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

	@Override
	public void loadTxtFile(File inputFile) {
		// TODO Auto-generated method stub
		
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
