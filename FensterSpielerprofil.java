
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import java.awt.Image;
import java.awt.Insets;
import java.util.List;
import java.util.*;

@SuppressWarnings("serial")
public class FensterSpielerprofil extends JFrame {

	JPanel contentPane;
	JButton buttonback;
	JLabel lblNewLabel;
	
	

//NEU###################################
	Set<String> vokEng = new HashSet<String>();
	int eng = 0 + vokEng.size();
	Set<String> vokEsp = new HashSet<String>();
	int esp = 0 + vokEsp.size();
	Set<String> vokTurk = new HashSet<String>();
	int turk = 0+vokTurk.size();
	
	
//NEU-END#############################	
	

	public void setWindowDimension(int x1,int y1,int x2,int y2) {
		setBounds(x1,y1,x2,y2);
	}

	/**
	 * Create the frame.
	 */
	JLabel lblRang;
	public FensterSpielerprofil() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0,0.0,0.0, };
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0,0.0, };
		contentPane.setLayout(gbl_contentPane);

		buttonback = new JButton("<--");
		GridBagConstraints gbc_buttonBack = new GridBagConstraints();
		gbc_buttonBack.gridx = 0;
		gbc_buttonBack.gridy = 0;
		contentPane.add(buttonback,gbc_buttonBack);	
		
		JLabel lblUserprofile = new JLabel("Userprofile");
		GridBagConstraints gbc_Userprofile = new GridBagConstraints();
		gbc_Userprofile.gridx = 1;
		gbc_Userprofile.gridy = 0;
		lblUserprofile.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		contentPane.add(lblUserprofile, gbc_Userprofile);
		
		try {
			lblNewLabel = new JLabel("");
			Image image = new ImageIcon(this.getClass().getResource("Icon.png")).getImage();
			GridBagConstraints gbc_image = new GridBagConstraints();
			gbc_image.gridx= 1;
			gbc_image.gridy= 1;
			lblNewLabel.setIcon(new ImageIcon(image));
			contentPane.add(lblNewLabel,gbc_image);
		}catch(Exception e) {
			System.out.println("Profilbild nicht vorhanden");
		}
		
	
		
		JLabel lblUsernameMaxMustermann = new JLabel("Username: Max Mustermann");
		GridBagConstraints gbc_UserName = new GridBagConstraints();
		gbc_UserName.gridx = 1;
		gbc_UserName.gridy = 2;
		lblUsernameMaxMustermann.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblUsernameMaxMustermann, gbc_UserName);
		
		JLabel lblAge = new JLabel("Age: 25");
		GridBagConstraints gbc_Age = new GridBagConstraints();
		gbc_Age.gridx = 1;
		gbc_Age.gridy = 3;
		gbc_Age.anchor = GridBagConstraints.WEST;
		lblAge.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblAge, gbc_Age);
 
		
		JLabel lblRang0 = new JLabel("Rang:");
		GridBagConstraints gbc_Rang0= new GridBagConstraints();
		gbc_Rang0.gridx = 3;
		gbc_Rang0.gridy = 1;
		lblRang0.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblRang0, gbc_Rang0);	
		
		lblRang = new JLabel(Rang());
		GridBagConstraints gbc_lblRang = new GridBagConstraints();
		gbc_lblRang.gridx = 4;
		gbc_lblRang.gridy = 1;
		gbc_lblRang.anchor = GridBagConstraints.WEST;
		lblAge.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblRang, gbc_lblRang);

		JLabel lblCurrentStatus = new JLabel("Current Status:");
		GridBagConstraints gbc_Current= new GridBagConstraints();
		gbc_Current.gridx = 3;
		gbc_Current.gridy = 2;
		lblCurrentStatus.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblCurrentStatus, gbc_Current);		
		
//NEU#########################################################################
		
		JLabel lblEnglish = new JLabel("English (" + eng + "/50)");
		GridBagConstraints gbc_Englisch= new GridBagConstraints();
		gbc_Englisch.gridx = 3;
		gbc_Englisch.gridy = 3;
	
		gbc_Englisch.fill = GridBagConstraints.BOTH; 
		gbc_Englisch.insets = new Insets( 5, 5, 5, 5);
		lblEnglish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblEnglish, gbc_Englisch);
		
		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.gridx = 4;
		gbc_progressBar.gridy = 3;
		progressBar.setMaximum(50);
		progressBar.setValue(eng);
		contentPane.add(progressBar, gbc_progressBar);
		
		JLabel lblSpanish = new JLabel("Spanish (" + esp + "/50)");
		GridBagConstraints gbc_Spanisch= new GridBagConstraints();
		gbc_Spanisch.gridx = 3;
		gbc_Spanisch.gridy = 4;
		gbc_Spanisch.insets = new Insets( 5, 5, 5, 5);
		lblSpanish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblSpanish,gbc_Spanisch);
		
		JProgressBar progressBar_1 = new JProgressBar();
		GridBagConstraints gbc_ProgressBar_1= new GridBagConstraints();
		gbc_ProgressBar_1.gridx = 4;
		gbc_ProgressBar_1.gridy = 4;
		progressBar_1.setValue(esp);
		progressBar_1.setMaximum(50);
		contentPane.add(progressBar_1, gbc_ProgressBar_1);
		
		JLabel lblTurkish = new JLabel("Turkish (" + turk + "/50)");
		GridBagConstraints gbc_Turkish= new GridBagConstraints();
		gbc_Turkish.gridx = 3;
		gbc_Turkish.gridy = 5;
		gbc_Turkish.insets = new Insets( 5, 5, 5, 5);
		lblTurkish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblTurkish, gbc_Turkish);
		
		JProgressBar progressBar_2 = new JProgressBar();
		GridBagConstraints gbc_ProgressBar_2= new GridBagConstraints();
		gbc_ProgressBar_2.gridx = 4;
		gbc_ProgressBar_2.gridy = 5;
		progressBar_2.setValue(turk);
		progressBar_2.setMaximum(50);
		contentPane.add(progressBar_2, gbc_ProgressBar_2);
		
		
		
		
	}
	
	public String Rang(){
		int Gesamtpunkte = 70;
		
		if (Gesamtpunkte <= 50){
			return ("Amateur");
		}
		if(Gesamtpunkte <= 100) {
			return ("Amateur 2.0");
		}
		if (Gesamtpunkte <=200) {
			return ("Profi Amateur");
		}
		if (Gesamtpunkte <=300) {
			return ("Fortgeschrittener");
		}
		else {return ("Meister der Sprachen");}
		}
	
}
