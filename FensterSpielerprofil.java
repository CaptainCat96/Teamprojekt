
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		label.setBounds(336, 23, 48, 48);
		contentPane.add(label);
		
		buttonback = new JButton("<--");
		buttonback.setBounds(10, 227, 89, 23);
		contentPane.add(buttonback);
		
		JLabel lblUserprofile = new JLabel("Userprofile");
		lblUserprofile.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblUserprofile.setBounds(154, 23, 98, 29);
		contentPane.add(lblUserprofile);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(50);
		progressBar.setValue(10);
		progressBar.setBounds(246, 139, 146, 14);
		contentPane.add(progressBar);
		
		JLabel lblUsernameMaxMustermann = new JLabel("Username: Max Mustermann");
		lblUsernameMaxMustermann.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblUsernameMaxMustermann.setBounds(43, 71, 161, 23);
		contentPane.add(lblUsernameMaxMustermann);
		
		JLabel lblAge = new JLabel("Age: 25");
		lblAge.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblAge.setBounds(43, 105, 79, 23);
		contentPane.add(lblAge);
		
		JLabel lblCurrentStatus = new JLabel("Current Status:");
		lblCurrentStatus.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblCurrentStatus.setBounds(43, 139, 79, 14);
		contentPane.add(lblCurrentStatus);
		
		JLabel lblEnglish = new JLabel("English (10/50)");
		lblEnglish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblEnglish.setBounds(147, 139, 89, 14);
		contentPane.add(lblEnglish);
		
		JLabel lblSpanish = new JLabel("Spanish (40/50)");
		lblSpanish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblSpanish.setBounds(147, 164, 89, 15);
		contentPane.add(lblSpanish);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setValue(40);
		progressBar_1.setMaximum(50);
		progressBar_1.setBounds(246, 165, 146, 14);
		contentPane.add(progressBar_1);
		
		JLabel lblTurkish = new JLabel("Turkish (20/50)");
		lblTurkish.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblTurkish.setBounds(147, 190, 92, 14);
		contentPane.add(lblTurkish);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setValue(20);
		progressBar_2.setMaximum(50);
		progressBar_2.setBounds(246, 190, 146, 14);
		contentPane.add(progressBar_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 71, 17, 147);
		contentPane.add(scrollBar);
	}
}
