import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class FensterEinstellungen extends JFrame{
	JPanel contentPane;
	JButton buttonBack;
	private JSpinner spinner;
	private JLabel lblFarbschema;
	private JSpinner spinner_1;
	public void setWindowDimension(int x1, int y1, int x2, int y2) {
		setBounds(x1, y1, x2, y2);
	}
	
	/**
	 * Create the frame.
	 */
	public FensterEinstellungen() {
		
		
		/**
		 * Layout
		 */
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\levin\\Downloads\\icons8-erinnerung-48.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{59, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
				
				
				buttonBack = new JButton("<--");
				GridBagConstraints gbc_buttonBack = new GridBagConstraints();
				gbc_buttonBack.insets = new Insets(0, 0, 5, 5);
				gbc_buttonBack.anchor = GridBagConstraints.NORTH;
				gbc_buttonBack.fill = GridBagConstraints.HORIZONTAL;
				gbc_buttonBack.gridx = 0;
				gbc_buttonBack.gridy = 0;
				contentPane.add(buttonBack, gbc_buttonBack);
				
				JLabel lblEinstellungen = new JLabel("Einstellungen");
				GridBagConstraints gbc_lblEinstellungen = new GridBagConstraints();
				gbc_lblEinstellungen.insets = new Insets(0, 0, 5, 5);
				gbc_lblEinstellungen.gridx = 1;
				gbc_lblEinstellungen.gridy = 0;
				contentPane.add(lblEinstellungen, gbc_lblEinstellungen);
				
				JLabel lblFenstergre = new JLabel("Fenstergr\u00F6\u00DFe");
				GridBagConstraints gbc_lblFenstergre = new GridBagConstraints();
				gbc_lblFenstergre.insets = new Insets(0, 0, 5, 5);
				gbc_lblFenstergre.gridx = 1;
				gbc_lblFenstergre.gridy = 2;
				contentPane.add(lblFenstergre, gbc_lblFenstergre);
				
				spinner = new JSpinner();
				GridBagConstraints gbc_spinner = new GridBagConstraints();
				gbc_spinner.gridwidth = 10;
				gbc_spinner.insets = new Insets(0, 0, 5, 0);
				gbc_spinner.gridx = 3;
				gbc_spinner.gridy = 2;
				contentPane.add(spinner, gbc_spinner);
				
				lblFarbschema = new JLabel("Farbschema");
				GridBagConstraints gbc_lblFarbschema = new GridBagConstraints();
				gbc_lblFarbschema.insets = new Insets(0, 0, 5, 5);
				gbc_lblFarbschema.gridx = 1;
				gbc_lblFarbschema.gridy = 3;
				contentPane.add(lblFarbschema, gbc_lblFarbschema);
				
				spinner_1 = new JSpinner();
				GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
				gbc_spinner_1.gridwidth = 10;
				gbc_spinner_1.insets = new Insets(0, 0, 5, 0);
				gbc_spinner_1.gridx = 3;
				gbc_spinner_1.gridy = 3;
				contentPane.add(spinner_1, gbc_spinner_1);
	}
}
