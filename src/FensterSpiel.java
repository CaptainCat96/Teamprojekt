import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import javafx.scene.paint.Color;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class FensterSpiel extends JFrame {

	JPanel contentPane;
	JLabel txtWelchesWortIst;
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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{128, 32, 89, 89, 56, 0};
		gbl_contentPane.rowHeights = new int[]{25, 39, 61, 23, 24, 23, 14, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		buttonBack = new JButton("<--");
		GridBagConstraints gbc_buttonBack = new GridBagConstraints();
		gbc_buttonBack.anchor = GridBagConstraints.NORTHWEST;
		gbc_buttonBack.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBack.gridx = 0;
		gbc_buttonBack.gridy = 0;
		contentPane.add(buttonBack, gbc_buttonBack);
						
								txtWelchesWortIst = new JLabel();
								txtWelchesWortIst.setIcon(new ImageIcon("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
								txtWelchesWortIst.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
								txtWelchesWortIst.setText("Welches Wort ist die richtige \u00DCbersetzung f\u00FCr ...");
								GridBagConstraints gbc_txtWelchesWortIst = new GridBagConstraints();
								gbc_txtWelchesWortIst.fill = GridBagConstraints.VERTICAL;
								gbc_txtWelchesWortIst.insets = new Insets(0, 0, 5, 0);
								gbc_txtWelchesWortIst.gridwidth = 5;
								gbc_txtWelchesWortIst.gridx = 0;
								gbc_txtWelchesWortIst.gridy = 1;
								contentPane.add(txtWelchesWortIst, gbc_txtWelchesWortIst);
								
								lblStatusLetzteAntwort = new JLabel("");
								lblStatusLetzteAntwort.setHorizontalAlignment(SwingConstants.CENTER);
								GridBagConstraints gbc_lblStatusLetzteAntwort = new GridBagConstraints();
								gbc_lblStatusLetzteAntwort.fill = GridBagConstraints.VERTICAL;
								gbc_lblStatusLetzteAntwort.insets = new Insets(0, 0, 5, 0);
								gbc_lblStatusLetzteAntwort.gridwidth = 7;
								gbc_lblStatusLetzteAntwort.gridx = 0;
								gbc_lblStatusLetzteAntwort.gridy = 2;
								contentPane.add(lblStatusLetzteAntwort, gbc_lblStatusLetzteAntwort);
						
								btnPhone = new JRadioButton("phone");
								btnPhone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
								GridBagConstraints gbc_btnPhone = new GridBagConstraints();
								gbc_btnPhone.anchor = GridBagConstraints.NORTHWEST;
								gbc_btnPhone.insets = new Insets(0, 0, 5, 5);
								gbc_btnPhone.gridx = 0;
								gbc_btnPhone.gridy = 3;
								contentPane.add(btnPhone, gbc_btnPhone);
								bg.add(btnPhone);
				
						btnPencil = new JRadioButton("pencil");
						btnPencil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
						GridBagConstraints gbc_btnPencil = new GridBagConstraints();
						gbc_btnPencil.anchor = GridBagConstraints.NORTH;
						gbc_btnPencil.insets = new Insets(0, 0, 5, 5);
						gbc_btnPencil.gridx = 2;
						gbc_btnPencil.gridy = 3;
						contentPane.add(btnPencil, gbc_btnPencil);
						bg.add(btnPencil);
								
										btnHouse = new JRadioButton("house");
										btnHouse.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
										GridBagConstraints gbc_btnHouse = new GridBagConstraints();
										gbc_btnHouse.anchor = GridBagConstraints.NORTH;
										gbc_btnHouse.insets = new Insets(0, 0, 5, 0);
										gbc_btnHouse.gridx = 4;
										gbc_btnHouse.gridy = 3;
										contentPane.add(btnHouse, gbc_btnHouse);
										bg.add(btnHouse);
						
								btnTree = new JRadioButton("tree");
								btnTree.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
								GridBagConstraints gbc_btnTree = new GridBagConstraints();
								gbc_btnTree.gridwidth = 2;
								gbc_btnTree.anchor = GridBagConstraints.NORTHWEST;
								gbc_btnTree.insets = new Insets(0, 0, 5, 5);
								gbc_btnTree.gridx = 0;
								gbc_btnTree.gridy = 4;
								contentPane.add(btnTree, gbc_btnTree);
								bg.add(btnTree);
				
						btnRabbit = new JRadioButton("rabbit");
						btnRabbit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
						GridBagConstraints gbc_btnRabbit = new GridBagConstraints();
						gbc_btnRabbit.anchor = GridBagConstraints.NORTH;
						gbc_btnRabbit.insets = new Insets(0, 0, 5, 5);
						gbc_btnRabbit.gridx = 2;
						gbc_btnRabbit.gridy = 4;
						contentPane.add(btnRabbit, gbc_btnRabbit);
						bg.add(btnRabbit);
				
						btnStreet = new JRadioButton("street");
						btnStreet.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
						GridBagConstraints gbc_btnStreet = new GridBagConstraints();
						gbc_btnStreet.anchor = GridBagConstraints.SOUTH;
						gbc_btnStreet.insets = new Insets(0, 0, 5, 0);
						gbc_btnStreet.gridx = 4;
						gbc_btnStreet.gridy = 4;
						contentPane.add(btnStreet, gbc_btnStreet);
						bg.add(btnStreet);
		
				btnNext = new JButton("Next");
				btnNext.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
				GridBagConstraints gbc_btnNext = new GridBagConstraints();
				gbc_btnNext.fill = GridBagConstraints.VERTICAL;
				gbc_btnNext.insets = new Insets(0, 0, 5, 5);
				gbc_btnNext.gridx = 2;
				gbc_btnNext.gridy = 5;
				contentPane.add(btnNext, gbc_btnNext);
		
				FragenVerbleibend = new JLabel("1/15");
				FragenVerbleibend.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
				GridBagConstraints gbc_FragenVerbleibend = new GridBagConstraints();
				gbc_FragenVerbleibend.anchor = GridBagConstraints.EAST;
				gbc_FragenVerbleibend.insets = new Insets(0, 0, 5, 0);
				gbc_FragenVerbleibend.gridx = 4;
				gbc_FragenVerbleibend.gridy = 5;
				contentPane.add(FragenVerbleibend, gbc_FragenVerbleibend);
		
		progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.anchor = GridBagConstraints.NORTH;
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridwidth = 5;
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 6;
		contentPane.add(progressBar, gbc_progressBar);
	}
}
