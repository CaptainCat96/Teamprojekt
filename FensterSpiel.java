import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FensterSpiel extends JFrame {

	JPanel contentPane;
	JLabel txtWelchesWortIst;
	JLabel txtBaum;
	JRadioButton btnTree;
	JRadioButton btnRabbit;
	JRadioButton btnStreet;
	JRadioButton btnPhone;
	JRadioButton btnPencil;
	JRadioButton btnHouse;
	JLabel FragenVerbleibend;
	ButtonGroup bg = new ButtonGroup();
	JButton btnNext;
	JProgressBar progressBar;
	JLabel lblStatusLetzteAntwort;
	JButton buttonBack;

	public void setWindowDimension(int x1, int y1, int x2, int y2) {
		setBounds(x1, y1, x2, y2);
	}

	/**
	 * Create the frame.
	 */
	public FensterSpiel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtWelchesWortIst = new JLabel();
		txtWelchesWortIst.setIcon(new ImageIcon("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		txtWelchesWortIst.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		txtWelchesWortIst.setText("Welches Wort ist die richtige \u00DCbersetzung f\u00FCr ...");
		txtWelchesWortIst.setBounds(39, 30, 317, 39);
		contentPane.add(txtWelchesWortIst);

		txtBaum = new JLabel();
		txtBaum.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		txtBaum.setText("Baum ?");
		txtBaum.setBounds(190, 79, 59, 20);
		contentPane.add(txtBaum);

		btnTree = new JRadioButton("tree");
		btnTree.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnTree.setBounds(39, 163, 89, 23);
		contentPane.add(btnTree);
		bg.add(btnTree);

		btnRabbit = new JRadioButton("rabbit");
		btnRabbit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnRabbit.setBounds(160, 163, 89, 23);
		contentPane.add(btnRabbit);
		bg.add(btnRabbit);

		btnStreet = new JRadioButton("street");
		btnStreet.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnStreet.setBounds(278, 164, 89, 23);
		contentPane.add(btnStreet);
		bg.add(btnStreet);

		btnPhone = new JRadioButton("phone");
		btnPhone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnPhone.setBounds(39, 130, 89, 23);
		contentPane.add(btnPhone);
		bg.add(btnPhone);

		btnPencil = new JRadioButton("pencil");
		btnPencil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnPencil.setBounds(160, 130, 89, 23);
		contentPane.add(btnPencil);
		bg.add(btnPencil);

		btnHouse = new JRadioButton("house");
		btnHouse.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnHouse.setBounds(278, 130, 89, 23);
		contentPane.add(btnHouse);
		bg.add(btnHouse);

		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		btnNext.setBounds(160, 214, 89, 23);
		contentPane.add(btnNext);

		FragenVerbleibend = new JLabel("1/15");
		FragenVerbleibend.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		FragenVerbleibend.setBounds(378, 219, 46, 14);
		contentPane.add(FragenVerbleibend);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 247, 414, 14);
		contentPane.add(progressBar);
		
		lblStatusLetzteAntwort = new JLabel("");
		lblStatusLetzteAntwort.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusLetzteAntwort.setBounds(39, 11, 317, 14);
		contentPane.add(lblStatusLetzteAntwort);
		
		buttonBack = new JButton("<--");
		buttonBack.setBounds(0, 0, 59, 23);
		contentPane.add(buttonBack);
	}
}
