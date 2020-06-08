import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;

public class GameDesign extends JFrame {

	private JPanel contentPane;
	private JLabel txtWelchesWortIst;
	private JLabel txtBaum;
	private JRadioButton btnTree;
	private JRadioButton btnRabbit;
	private JRadioButton btnStreet;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameDesign frame = new GameDesign();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameDesign() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		btnRabbit = new JRadioButton("rabbit");
		btnRabbit.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnRabbit.setBounds(160, 163, 89, 23);
		contentPane.add(btnRabbit);
		
		btnStreet = new JRadioButton("street");
		btnStreet.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnStreet.setBounds(278, 164, 89, 23);
		contentPane.add(btnStreet);
		
		JRadioButton rdbtnPhone = new JRadioButton("phone ");
		rdbtnPhone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdbtnPhone.setBounds(39, 130, 89, 23);
		contentPane.add(rdbtnPhone);
		
		JRadioButton rdbtnPencil = new JRadioButton("pencil");
		rdbtnPencil.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdbtnPencil.setBounds(160, 130, 89, 23);
		contentPane.add(rdbtnPencil);
		
		JRadioButton rdbtnHouse = new JRadioButton("house");
		rdbtnHouse.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		rdbtnHouse.setBounds(278, 130, 89, 23);
		contentPane.add(rdbtnHouse);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		btnNext.setBounds(160, 214, 89, 23);
		contentPane.add(btnNext);
		
		label = new JLabel("1/15");
		label.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		label.setBounds(378, 219, 46, 14);
		contentPane.add(label);
	}
}
