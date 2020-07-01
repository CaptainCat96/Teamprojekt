
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JProgressBar;
//import javax.swing.JScrollBar;

@SuppressWarnings("serial")
public class FensterSpielerprofil extends JFrame {

	
	private JPanel contentPane;
	JButton buttonback;

	public void setWindowDimension(int x1,int y1,int x2,int y2) {
		setBounds(x1,y1,x2,y2);
	}

	/**
	 * Create the frame.
	 */
	public FensterSpielerprofil() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{59, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{19, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0,0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		buttonback = new JButton("<--");
		GridBagConstraints gbc_buttonBack = new GridBagConstraints();
		gbc_buttonBack.insets = new Insets(0, 0, 10, 5);
		gbc_buttonBack.anchor = GridBagConstraints.NORTH;
		gbc_buttonBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonBack.gridx = 0;
		gbc_buttonBack.gridy = 0;
		buttonback.setBounds(10, 227, 89, 23);
		contentPane.add(buttonback,gbc_buttonBack);	
		
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_lable = new GridBagConstraints();
		label.setIcon(new ImageIcon("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		label.setBounds(336, 23, 48, 48);
		contentPane.add(label,gbc_lable);
		
		
		
		JLabel lblUserprofile = new JLabel("Userprofile");
		GridBagConstraints gbc_Userprofile = new GridBagConstraints();
		gbc_Userprofile.insets = new Insets(0, 0, 0, 0);
		gbc_Userprofile.anchor = GridBagConstraints.CENTER;
		gbc_Userprofile.fill = GridBagConstraints.CENTER;
		gbc_Userprofile.gridx = 1;
		gbc_Userprofile.gridy = 0;
		lblUserprofile.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblUserprofile.setBounds(154, 23, 98, 29);
		contentPane.add(lblUserprofile, gbc_Userprofile);
		
		JLabel lblUsernameMaxMustermann = new JLabel("Username: Max Mustermann");
		GridBagConstraints gbc_UserName = new GridBagConstraints();
		gbc_UserName.insets = new Insets(0, 0, 0, 0);
		gbc_UserName.anchor = GridBagConstraints.NORTH;
		gbc_UserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_UserName.gridx = 1;
		gbc_UserName.gridy = 1;
		lblUsernameMaxMustermann.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblUsernameMaxMustermann.setBounds(43, 71, 161, 23);
		contentPane.add(lblUsernameMaxMustermann, gbc_UserName);
		
		JLabel lblAge = new JLabel("Age: 25");
		GridBagConstraints gbc_Age = new GridBagConstraints();
		gbc_Age.insets = new Insets(0, 0, 0, 0);
		gbc_Age.anchor = GridBagConstraints.NORTH;
		gbc_Age.fill = GridBagConstraints.HORIZONTAL;
		gbc_Age.gridx = 1;
		gbc_Age.gridy = 2;
		lblAge.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblAge.setBounds(43, 105, 79, 23);
		contentPane.add(lblAge, gbc_Age);
		
		
		JLabel lblCurrentStatus = new JLabel("Current Status:");
		GridBagConstraints gbc_Current= new GridBagConstraints();
		gbc_Current.insets = new Insets(0, 0, 0, 0);
		gbc_Current.anchor = GridBagConstraints.NORTH;
		gbc_Current.fill = GridBagConstraints.CENTER;
		gbc_Current.gridx = 1;
		gbc_Current.gridy = 4;
		lblCurrentStatus.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		lblCurrentStatus.setBounds(43, 139, 79, 14);
		contentPane.add(lblCurrentStatus, gbc_Current);
		
		JLabel lblEnglish = new JLabel("English (10/50)");
		GridBagConstraints gbc_Englisch= new GridBagConstraints();
		gbc_Englisch.insets = new Insets(0, 0, 0, 0);
		gbc_Englisch.anchor = GridBagConstraints.NORTH;
		gbc_Englisch.fill = GridBagConstraints.HORIZONTAL;
		gbc_Englisch.gridx = 1;
		gbc_Englisch.gridy = 5;
		lblEnglish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblEnglish.setBounds(147, 139, 89, 14);
		contentPane.add(lblEnglish, gbc_Englisch);
		
		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 0, 0);
		gbc_progressBar.anchor = GridBagConstraints.NORTH;
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridx = 2;
		gbc_progressBar.gridy = 5;
		progressBar.setMaximum(50);
		progressBar.setValue(10);
		progressBar.setBounds(246, 139, 146, 14);
		contentPane.add(progressBar, gbc_progressBar);
		
		JLabel lblSpanish = new JLabel("Spanish (40/50)");
		GridBagConstraints gbc_Spanisch= new GridBagConstraints();
		gbc_Spanisch.insets = new Insets(0, 0, 0, 0);
		gbc_Spanisch.anchor = GridBagConstraints.NORTH;
		gbc_Spanisch.fill = GridBagConstraints.HORIZONTAL;
		gbc_Spanisch.gridx = 1;
		gbc_Spanisch.gridy = 6;
		lblSpanish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblSpanish.setBounds(147, 164, 89, 15);
		contentPane.add(lblSpanish,gbc_Spanisch);
		
		JProgressBar progressBar_1 = new JProgressBar();
		GridBagConstraints gbc_ProgressBar_1= new GridBagConstraints();
		gbc_ProgressBar_1.insets = new Insets(0, 0, 0, 0);
		gbc_ProgressBar_1.anchor = GridBagConstraints.NORTH;
		gbc_ProgressBar_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_ProgressBar_1.gridx = 2;
		gbc_ProgressBar_1.gridy = 6;
		progressBar_1.setValue(40);
		progressBar_1.setMaximum(50);
		progressBar_1.setBounds(246, 165, 146, 14);
		contentPane.add(progressBar_1, gbc_ProgressBar_1);
		
		JLabel lblTurkish = new JLabel("Turkish (20/50)");
		GridBagConstraints gbc_Turkish= new GridBagConstraints();
		gbc_Turkish.insets = new Insets(0, 0, 0, 0);
		gbc_Turkish.anchor = GridBagConstraints.NORTH;
		gbc_Turkish.fill = GridBagConstraints.HORIZONTAL;
		gbc_Turkish.gridx = 1;
		gbc_Turkish.gridy = 7;
		lblTurkish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblTurkish.setBounds(147, 190, 92, 14);
		contentPane.add(lblTurkish, gbc_Turkish);
		
		JProgressBar progressBar_2 = new JProgressBar();
		GridBagConstraints gbc_ProgressBar_2= new GridBagConstraints();
		gbc_ProgressBar_2.insets = new Insets(0, 0, 0, 0);
		gbc_ProgressBar_2.anchor = GridBagConstraints.NORTH;
		gbc_ProgressBar_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_ProgressBar_2.gridx = 2;
		gbc_ProgressBar_2.gridy = 7;
		progressBar_2.setValue(70);
		progressBar_2.setMaximum(50);
		
		contentPane.add(progressBar_2, gbc_ProgressBar_2);
	
		
		
	/**	JScrollBar scrollBar = new JScrollBar();
		GridBagConstraints gbc_ScrollBar= new GridBagConstraints();
		gbc_ScrollBar.insets = new Insets(0, 0, 0, 0);
		gbc_ScrollBar.anchor = GridBagConstraints.NORTH;
		gbc_ScrollBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_ScrollBar.gridx = 3;
		gbc_ScrollBar.gridy = 4;
		scrollBar.setBounds(407, 71, 17, 147);
		contentPane.add(scrollBar, gbc_ScrollBar);*/
	}
}
