import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class JFrame extends javax.swing.JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
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
	public JFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\berka\\eclipse-workspace\\Teamprojekt\\src\\icons8-erinnerung-48.png"));
		setTitle("Teamprojekt 2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnZumSpiel = new JButton("Zum Spiel");
		btnZumSpiel.setBounds(289, 189, 104, 23);
		contentPane.add(btnZumSpiel);
		
		JButton btnDeinProfil = new JButton("Dein Profil");
		btnDeinProfil.setBounds(289, 223, 104, 23);
		contentPane.add(btnDeinProfil);
		
		JButton btnEinstellungen = new JButton("Einstellungen");
		btnEinstellungen.setBounds(289, 258, 104, 23);
		contentPane.add(btnEinstellungen);
		
		JRadioButton rdbtnTonAus = new JRadioButton("Ton aus");
		rdbtnTonAus.setBounds(302, 443, 109, 23);
		contentPane.add(rdbtnTonAus);
		
		JLabel lblLetsLearn = new JLabel("Let's Learn !");
		lblLetsLearn.setIcon(new ImageIcon("C:\\Users\\berka\\eclipse-workspace\\Teamprojekt\\src\\icons8-erinnerung-48.png"));
		lblLetsLearn.setFont(new Font("Yu Gothic Light", Font.PLAIN, 25));
		lblLetsLearn.setBounds(247, 33, 226, 73);
		contentPane.add(lblLetsLearn);
	}
}
