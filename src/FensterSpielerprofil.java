
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import java.awt.Image;


@SuppressWarnings("serial")
public class FensterSpielerprofil extends JFrame {

	private JPanel contentPane;
	JButton buttonback;
	JLabel lblNewLabel;

	public void setWindowDimension(int x1,int y1,int x2,int y2) {
		setBounds(x1,y1,x2,y2);
	}

	/**
	 * Create the frame.
	 */
	public FensterSpielerprofil() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		buttonback = new JButton("<--");
		buttonback.setBounds(47, 326, 89, 23);
		contentPane.add(buttonback);
		
		JLabel lblUserprofile = new JLabel("Userprofile");
		lblUserprofile.setBounds(236, 26, 98, 29);
		lblUserprofile.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		contentPane.add(lblUserprofile);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(472, 138, 130, 38);
		progressBar.setMaximum(50);
		progressBar.setValue(10);
		contentPane.add(progressBar);
		
		JLabel lblUsernameMaxMustermann = new JLabel("Username: Max Mustermann");
		lblUsernameMaxMustermann.setBounds(35, 236, 147, 23);
		lblUsernameMaxMustermann.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblUsernameMaxMustermann);
		
		JLabel lblAge = new JLabel("Age: 25");
		lblAge.setBounds(35, 259, 79, 23);
		lblAge.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblAge);
		
		JLabel lblCurrentStatus = new JLabel("Current Status:");
		lblCurrentStatus.setBounds(408, 96, 73, 15);
		lblCurrentStatus.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblCurrentStatus);
		
		JLabel lblEnglish = new JLabel("English (10/50)");
		lblEnglish.setBounds(319, 138, 89, 38);
		lblEnglish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblEnglish);
		
		JLabel lblSpanish = new JLabel("Spanish (40/50)");
		lblSpanish.setBounds(319, 208, 89, 38);
		lblSpanish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblSpanish);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(472, 208, 130, 38);
		progressBar_1.setValue(40);
		progressBar_1.setMaximum(50);
		contentPane.add(progressBar_1);
		
		JLabel lblTurkish = new JLabel("Turkish (20/50)");
		lblTurkish.setBounds(319, 280, 132, 38);
		lblTurkish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		contentPane.add(lblTurkish);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(472, 279, 130, 38);
		progressBar_2.setValue(20);
		progressBar_2.setMaximum(50);
		contentPane.add(progressBar_2);
		
		lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("Icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(34, 71, 203, 157);
		contentPane.add(lblNewLabel);
		
	}
}
