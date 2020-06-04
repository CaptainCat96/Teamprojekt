import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

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
		testRun.loadTxtFile("src\\Lerneinheiten\\Exercise1");
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
	 * Der Pfad er übergeben wird darf kein Lokaler Pfad sein
	 * Falsch:
	 * "C:\\Users\\henri\\eclipse-workspace\\TeamprojektLernprogramm\\src\\Lerneinheiten\\Exercise1"
	 * 
	 * Er muss zum Projekt Relativ sein, ausgehend von Source ordner
	 * Richtig:
	 * "src\\Lerneinheiten\\Exercise1"
	 */
	@Override
	public void loadTxtFile(String path) {
		File inputFile=new File(path);
		String input="";
		try {
			FileInputStream loadFile = new FileInputStream(inputFile);
			//FileInputStream ließt immer ints
			int timeout_after_iteration=10000;
			int i = 0;
			while(loadFile.available()>0) {
				if(i>timeout_after_iteration) {
					System.out.println("Timeout");
					return;
				}
				int input_int=loadFile.read();
				input = input+ Character.toString((char)input_int);
				i++;
			}
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Datei wurde nicht gefunden!");
			return;
		} catch (IOException e) {
			System.out.println("Datei wurde nicht gefunden!");
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return;
		}
		System.out.println("Loading Successful:");
		System.out.println(input);
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
