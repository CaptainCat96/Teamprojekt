import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Highscore extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Highscore frame = new Highscore();
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
	public Highscore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHierIstDein = new JLabel("Hier ist dein Highscore !");
		lblHierIstDein.setIcon(new ImageIcon("C:\\Users\\beytullah\\eclipse-workspace\\Teamprojekt\\src\\icons8-erinnerung-48.png"));
		lblHierIstDein.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 25));
		lblHierIstDein.setBounds(74, 11, 312, 103);
		contentPane.add(lblHierIstDein);
		
		JLabel lblDuHastBisher = new JLabel("Du hast bisher ");
		lblDuHastBisher.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblDuHastBisher.setBounds(146, 81, 135, 56);
		contentPane.add(lblDuHastBisher);
		
		JLabel lblAnzahl = new JLabel("XY W\u00F6rter");
		lblAnzahl.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 18));
		lblAnzahl.setBounds(156, 112, 102, 56);
		contentPane.add(lblAnzahl);
		
		JLabel lblKorrektBeantwortet = new JLabel("am St\u00FCck korrekt beantwortet !");
		lblKorrektBeantwortet.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblKorrektBeantwortet.setBounds(92, 158, 252, 25);
		contentPane.add(lblKorrektBeantwortet);
		
		JLabel lblMaximalKannst = new JLabel("maximal kannst 45 Punkte mit den geladenen Vokabelpaketen erreichen.");
		lblMaximalKannst.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblMaximalKannst.setBounds(60, 236, 350, 14);
		contentPane.add(lblMaximalKannst);
		
		JButton btnZurckZumMen = new JButton("zur\u00FCck zum Men\u00FC");
		btnZurckZumMen.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnZurckZumMen.setBounds(0, 0, 128, 23);
		contentPane.add(btnZurckZumMen);
	}
}
