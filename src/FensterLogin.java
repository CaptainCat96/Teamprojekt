import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;  
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FensterLogin extends JFrame {

	private JPanel contentPane;
	private JTextField nameInput;
	private JPasswordField passwordInput;
	

    /**
     * Button zum Senden der Daten 
     */
    JButton btnLogin;

    /**
     * Button zum Registrieren eines Users 
     */
    JButton btnRegister;
	
	
	private final String ACCOUNT_FILENAME = "Lerneinheiten/accounts.txt";
	    //private final String ACCOUNT_FILENAME = "src\\Lerneinheiten\\accounts.txt";
	


	/**
	 * Create the frame.
	 */
	public FensterLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{48, 89, 86, 89, 0};
		gbl_contentPane.rowHeights = new int[]{38, 23, 30, 20, 20, 41, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLogin = new JLabel("Login");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 2;
		gbc_lblLogin.gridy = 1;
		contentPane.add(lblLogin, gbc_lblLogin);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		contentPane.add(lblName, gbc_lblName);
		
		nameInput = new JTextField();
		GridBagConstraints gbc_nameInput = new GridBagConstraints();
		gbc_nameInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameInput.anchor = GridBagConstraints.NORTH;
		gbc_nameInput.insets = new Insets(0, 0, 5, 5);
		gbc_nameInput.gridx = 2;
		gbc_nameInput.gridy = 3;
		contentPane.add(nameInput, gbc_nameInput);
		nameInput.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 1;
		gbc_lblPasswort.gridy = 4;
		contentPane.add(lblPasswort, gbc_lblPasswort);
		
		btnLogin = new JButton("Login");
		
		passwordInput = new JPasswordField();
		GridBagConstraints gbc_passwordInput = new GridBagConstraints();
		gbc_passwordInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordInput.anchor = GridBagConstraints.NORTH;
		gbc_passwordInput.insets = new Insets(0, 0, 5, 5);
		gbc_passwordInput.gridx = 2;
		gbc_passwordInput.gridy = 4;
		contentPane.add(passwordInput, gbc_passwordInput);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 6;
		contentPane.add(btnLogin, gbc_btnLogin);
		
		btnRegister = new JButton("Register");
	
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnRegister.gridx = 3;
		gbc_btnRegister.gridy = 6;
		contentPane.add(btnRegister, gbc_btnRegister);
	}
	 // Methoden Name und Passwort eingabe

    boolean registerUser() {
	String enteredName = nameInput.getText().trim();
	String enteredPassword = passwordInput.getText().trim();

	// Gültigkeit des user inputs
	if( "".equals(enteredName) || "".equals(enteredPassword) || isAccountValid()) {
	    return false;
	}

	// Encoden der Daten base64 im Falle, dass der user spezielle Charakter eingegeben hat 
	String encodedAccount = Base64.getEncoder().encodeToString( enteredName.getBytes())
	    + ":"
	    + Base64.getEncoder().encodeToString( enteredPassword.getBytes())
	    + "\n";

	// Hängt den neuen Account zu der Liste der Accounts 
	try {
	    BufferedWriter output = new BufferedWriter( new FileWriter( ACCOUNT_FILENAME, true));
	    output.append( encodedAccount);
	    output.close();
	    return true;
	} catch( IOException ioe) {
	    System.err.println("Cannot add new account: " + ioe);
	    return false;
	} 
    }
    final String getUser() {
    	return nameInput.getText();
        }
        
        /**
         * Check, ob eingefügter account gültig ist 
         *
         * @return true, wenn der eingefügte Account gültig ist. Andernfalls false
         */
        final boolean isAccountValid() {
    	String enteredName = nameInput.getText();
    	String enteredPassword = passwordInput.getText();
    	boolean accountValid = false;

    	try {
    	    // Loop password file, falls wir ein passenden account finden 
    	    BufferedReader bufferedReader = new BufferedReader( new FileReader(ACCOUNT_FILENAME));
    	    String line;
    	
    	    while((line = bufferedReader.readLine()) != null) {
    		line = line.trim(); // whitespaces entfernen

    		String [] account = line.split(":");
    		if(account.length == 2) {
    		    String username = new String(Base64.getDecoder().decode(account[0]));
    		    String password = new String(Base64.getDecoder().decode(account[1]));
    		    if(username.equals(enteredName) && password.equals(enteredPassword)) {
    			accountValid=true;
    			break;
    		    }
    		}
    	    }
    	    bufferedReader.close();
    	} catch(IOException ioe) {
    	    System.err.println("Cannot read accounts: " + ioe);
    	}
    	
    	return accountValid;
        }

        /**
         * Check, ob der User einen Namen und ein Passwort eingegeben hat 
         *
         * @return true, wenn der user einen Namen und ein Passwort eingegebn hat. Andernfalls falsch 
         */
        boolean isUserInputValid() {
    	String enteredName = nameInput.getText().trim();
    	String enteredPassword = passwordInput.getText().trim();

    	if("".equals(enteredName) || "".equals(enteredPassword)) {
    	    return false;
    	}
    	
    	return true;
        }
        
        public void setWindowDimension(int x1, int y1, int x2, int y2) {
    	setBounds(x1, y1, x2, y2);
        }
	public JPanel LoginForm() {
		return contentPane;
	}
    }


