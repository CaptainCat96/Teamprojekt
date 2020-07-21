import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FensterHighscore extends JFrame {

	JPanel contentPane;
	JButton btnZurckZumMen;
	JLabel lblMotivation;
	public void setWindowDimension(int x1,int y1,int x2,int y2) {
		setBounds(x1,y1,x2,y2);
	}
	/**
	 * Create the frame.
	 * @param anzahlRichtigeAntworten 
	 */
	int AnzahlRichtigeAntworten;
	int MaxAnzahlFragen;
	public FensterHighscore(int anzahlRichtigeAntworten,int maxAnzahlFragen) {
		AnzahlRichtigeAntworten= anzahlRichtigeAntworten;
		MaxAnzahlFragen=maxAnzahlFragen;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{59, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0,0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
			btnZurckZumMen = new JButton("<--");
			GridBagConstraints gbc_btnZurckZumMen = new GridBagConstraints();
		
			gbc_btnZurckZumMen.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnZurckZumMen.gridx = 0;
			gbc_btnZurckZumMen.gridy = 0;		
			btnZurckZumMen.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
			btnZurckZumMen.setBounds(0, 0, 128, 23);
			contentPane.add(btnZurckZumMen, gbc_btnZurckZumMen);
			
		
			JLabel lblHierIstDein = new JLabel("Hier ist dein Highscore !");
			GridBagConstraints gbc_Highscore = new GridBagConstraints();
			gbc_Highscore.insets = new Insets(5,5,5,5);
			gbc_Highscore.gridx = 1;
			gbc_Highscore.gridy = 1;
			contentPane.add(lblHierIstDein, gbc_Highscore);
			lblHierIstDein.setIcon(new ImageIcon("C:\\Users\\beytullah\\eclipse-workspace\\Teamprojekt\\src\\icons8-erinnerung-48.png"));
			lblHierIstDein.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 25));
			
				
			JLabel lblDuHastBisher = new JLabel("Du hast bisher ");
			GridBagConstraints gbc_lblDuHastBisher = new GridBagConstraints();
			gbc_lblDuHastBisher.insets = new Insets (5, 5, 5, 5);
			gbc_lblDuHastBisher.gridx = 1;
			gbc_lblDuHastBisher.gridy = 2;
			lblDuHastBisher.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
			lblDuHastBisher.setBounds(146, 81, 135, 56);
			contentPane.add(lblDuHastBisher, gbc_lblDuHastBisher);
				
			JLabel lblAnzahl = new JLabel(anzahlRichtigeAntworten+ " W\u00F6rter richtig beantwortet");
			GridBagConstraints gbc_lblAnzahl = new GridBagConstraints();
			gbc_lblAnzahl.insets = new Insets (0, 0, 5, 5);
			gbc_lblAnzahl.gridx = 1;
			gbc_lblAnzahl.gridy = 3;
			lblAnzahl.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 18));
			lblAnzahl.setBounds(156, 112, 102, 56);
			contentPane.add(lblAnzahl, gbc_lblAnzahl);


			lblMotivation = new JLabel(Motivation());
			GridBagConstraints gbc_lblMotivation = new GridBagConstraints();
			gbc_lblMotivation.insets = new Insets (0, 0, 5, 5);
			gbc_lblMotivation.gridx = 1;
			gbc_lblMotivation.gridy = 4;
			lblMotivation.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
			lblMotivation.setBounds(92, 158, 252, 25);
			contentPane.add(lblMotivation,gbc_lblMotivation);

			/**
			JLabel lblKorrektBeantwortet = new JLabel("am St\u00FCck korrekt beantwortet !");
			GridBagConstraints gbc_lblKorrekt = new GridBagConstraints();
			gbc_lblKorrekt.insets = new Insets (0, 0, 5, 5);
			gbc_lblKorrekt.gridx = 1;
			gbc_lblKorrekt.gridy = 4;
			lblKorrektBeantwortet.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
			lblKorrektBeantwortet.setBounds(92, 158, 252, 25);
			contentPane.add(lblKorrektBeantwortet,gbc_lblKorrekt);
			
			JLabel lblMaximalKannst = new JLabel("maximal kannst 45 Punkte mit den geladenen Vokabelpaketen erreichen.");
			GridBagConstraints gbc_lblMaxi = new GridBagConstraints();
			gbc_lblMaxi.insets = new Insets (0, 0, 4, 4);
			gbc_lblMaxi.gridx = 1;
			gbc_lblMaxi.gridy = 5;
			lblMaximalKannst.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
			lblMaximalKannst.setBounds(60, 236, 350, 14);
			contentPane.add(lblMaximalKannst, gbc_lblMaxi);
			*/
		
	}
	public String Motivation(){
		
		
		double Prozent = AnzahlRichtigeAntworten ;
//		System.out.println(Prozent);
		Prozent= Prozent/MaxAnzahlFragen;
//		System.out.println(Prozent);		
		
		if (Prozent == 0){
			return ("Du kannst nur besser werden!");
		}
		if(Prozent <= 0.1) {
			return ("Das wird langsam aber sicher, nur nicht aufgeben!");
		}
		if(Prozent <= 0.3) {
			return ("Es ist noch kein Meister vom Himmel gefallen. Immer flei§ig am Ball bleiben");
		}
		if(Prozent <= 0.5) {
			return ("Sehr gut immer weiter machen!");
		}
		if(Prozent <= 0.7) {
			return ("Prima du wirst immer besser!");
		}
		if(Prozent <= 0.98) {
			return ("Das kann sich sehen lassen! Mal gucken ob du es beim nŠchsten mal auch schaffst!");
		}
		else  {
			return ("Alles Richtig gemacht , NŠchstes mal bringst du mir was bei :D");
		}
	}

	
}
