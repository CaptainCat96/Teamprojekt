

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Iterator;

import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FensterStartmenue extends javax.swing.JFrame {

	JPanel contentPane;
	JButton btnZumSpiel;
	JButton btnDeinProfil;
	JButton btnEinstellungen;
	JRadioButton rdbtnTonAus;
	JLabel lblLetsLearn;
	private JComboBox<String> AuswahlLerneinheit;
	private JLabel lblLerneinheitAuswahl;

	public void setWindowDimension(int x1, int y1, int x2, int y2) {
		setBounds(x1, y1, x2, y2);
	}
	/**
	 * ##########################################################################
	 * Aufgabe 1
	 */
	public void LadeListeLerneinheiten(Daten daten) {
		
		// Entferne alle aktuellen Lerneinheiten aus der Asuwahlbox
		AuswahlLerneinheit.removeAll();
		
		// Fuege alle Lerneinheiten hinzu, die nicht leer sind
		for(String eintrag : daten.getLerneinheiten()) {
			if(eintrag != null && !eintrag.isEmpty()) {
				AuswahlLerneinheit.addItem(eintrag);
			}
		}
	}
	
	/**
	 * Create the frame.
	 */
	public FensterStartmenue(Daten daten) {
		
		/**
		 * Layout
		 */
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\berka\\eclipse-workspace\\Teamprojekt\\src\\icons8-erinnerung-48.png"));
		setTitle("Teamprojekt 2020");
		setDefaultCloseOperation(FensterStartmenue.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 200, 200, 200 };
		gbl_contentPane.rowHeights = new int[] { 0, 50, 50, 50, 50, 50, 50, 50 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);

		lblLetsLearn = new JLabel("Let's Learn !");
		lblLetsLearn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetsLearn.setIcon(
				new ImageIcon("C:\\Users\\berka\\eclipse-workspace\\Teamprojekt\\src\\icons8-erinnerung-48.png"));
		lblLetsLearn.setFont(new Font("Yu Gothic Light", Font.PLAIN, 25));
		GridBagConstraints gbc_lblLetsLearn = new GridBagConstraints();
		gbc_lblLetsLearn.fill = GridBagConstraints.BOTH;
		gbc_lblLetsLearn.insets = new Insets(0, 0, 5, 0);
		gbc_lblLetsLearn.gridx = 1;
		gbc_lblLetsLearn.gridy = 0;
		contentPane.add(lblLetsLearn, gbc_lblLetsLearn);

		btnZumSpiel = new JButton("Zum Spiel");
		GridBagConstraints gbc_btnZumSpiel = new GridBagConstraints();
		gbc_btnZumSpiel.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_btnZumSpiel.insets = new Insets(0, 0, 5, 0);
		gbc_btnZumSpiel.gridx = 1;
		gbc_btnZumSpiel.gridy = 1;
		contentPane.add(btnZumSpiel, gbc_btnZumSpiel);

		lblLerneinheitAuswahl = new JLabel("Lerneinheit Auswahl:");
		GridBagConstraints gbc_lblLerneinheitAuswahl = new GridBagConstraints();
		gbc_lblLerneinheitAuswahl.insets = new Insets(0, 0, 5, 0);
		gbc_lblLerneinheitAuswahl.gridx = 1;
		gbc_lblLerneinheitAuswahl.gridy = 2;
		contentPane.add(lblLerneinheitAuswahl, gbc_lblLerneinheitAuswahl);

		AuswahlLerneinheit = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		contentPane.add(AuswahlLerneinheit, gbc_comboBox);
		


		btnDeinProfil = new JButton("Dein Profil");
		btnDeinProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnDeinProfil = new GridBagConstraints();
		gbc_btnDeinProfil.anchor = GridBagConstraints.NORTH;
		gbc_btnDeinProfil.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeinProfil.gridx = 1;
		gbc_btnDeinProfil.gridy = 6;
		contentPane.add(btnDeinProfil, gbc_btnDeinProfil);

		btnEinstellungen = new JButton("Einstellungen");
		GridBagConstraints gbc_btnEinstellungen = new GridBagConstraints();
		gbc_btnEinstellungen.anchor = GridBagConstraints.NORTH;
		gbc_btnEinstellungen.insets = new Insets(0, 0, 5, 0);
		gbc_btnEinstellungen.gridx = 1;
		gbc_btnEinstellungen.gridy = 7;
		contentPane.add(btnEinstellungen, gbc_btnEinstellungen);

		rdbtnTonAus = new JRadioButton("Ton aus");
		GridBagConstraints gbc_rdbtnTonAus = new GridBagConstraints();
		gbc_rdbtnTonAus.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnTonAus.gridx = 1;
		gbc_rdbtnTonAus.gridy = 8;
		contentPane.add(rdbtnTonAus, gbc_rdbtnTonAus);
		
		/**
		 * Logik
		 */
		LadeListeLerneinheiten(daten);  // Hier brauchen wir die ComboBox, also _nach_ der Erzeugung ausfuehren!
	}
	
	/**
	 * Hole den Namen des ausgewaehlten Spiels
	 * 
	 * @return Den selektierten Spielnamen
	 */
	String holeAusgewaehltesSpiel() {
		return (String)AuswahlLerneinheit.getSelectedItem();
	}
}

