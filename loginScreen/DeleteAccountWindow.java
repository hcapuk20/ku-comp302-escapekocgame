package loginScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import loginScreen.controllers.FileEncryptionHandler;
import loginScreen.controllers.UserController;

public class DeleteAccountWindow extends JFrame {

	// Declaration of components and the user controller
	private UserController usc = new UserController();
	
	// Declarations of the file encryption handler and other components
	private FileEncryptionHandler enc = new FileEncryptionHandler();
	private final String key = "Encryption key for users";
	private File userFile = new File("assets/users.txt");
	
	private JButton submitButton;
	private JButton exitButton;
	private JLabel emailPasswordPrompt;
	private JLabel deleteStatus;
	private JPanel menuPanel;
	private JSeparator emailSeparator;
	private JSeparator passwordSeparator;
	private JTextField emailField;
	private JPasswordField passwordField;  
	
	private JPanel screenDeco1;
	private JPanel screenDeco2;
	private JPanel screenDeco3;
	private JPanel screenDeco4;
	private JPanel screenDeco5;
	private JPanel screenDeco6;
	private JPanel screenDeco9;
	private JPanel screenDeco7;
	private JPanel screenDeco8;
	private JPanel screenDeco10;
	private JPanel screenDeco11;
	private JPanel screenDeco12;   
	
	// Constructor for the delete account window
    public DeleteAccountWindow() {
        initComponents();
    }
    
    // Private method that generates UI components and event listeners
    private void initComponents() {

        menuPanel = new JPanel();
        emailPasswordPrompt = new JLabel();
        submitButton = new JButton();
        emailField = new JTextField();
        emailSeparator = new JSeparator();
        screenDeco9 = new JPanel();
        screenDeco10 = new JPanel();
        screenDeco11 = new JPanel();
        screenDeco12 = new JPanel();
        screenDeco1 = new JPanel();
        screenDeco2 = new JPanel();
        screenDeco3 = new JPanel();
        screenDeco4 = new JPanel();
        screenDeco5 = new JPanel();
        screenDeco6 = new JPanel();
        screenDeco7 = new JPanel();
        screenDeco8 = new JPanel();
        exitButton = new JButton();
        deleteStatus = new JLabel();
        passwordField = new JPasswordField();
        passwordSeparator = new JSeparator();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delete User");
        setUndecorated(true);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        menuPanel.setBackground(new Color(51, 51, 51));
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));

        emailPasswordPrompt.setFont(new Font("Segoe UI", 1, 18)); 
        emailPasswordPrompt.setForeground(new Color(255, 255, 255));
        emailPasswordPrompt.setText("Please enter your email and password to delete your account.");

        submitButton.setBackground(new Color(51, 51, 51));
        submitButton.setForeground(new Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                try {
					submitButtonMouseClicked(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        emailField.setBackground(new Color(51, 51, 51));
        emailField.setFont(new Font("Dialog", 0, 12)); 
        emailField.setForeground(new Color(204, 204, 204));
        emailField.setText("Email");
        emailField.setBorder(null);
        emailField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                emailFieldMouseClicked(evt);
            }
        });
        emailField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        emailSeparator.setBackground(new Color(255, 255, 255));
        emailSeparator.setForeground(new Color(255, 255, 255));

        screenDeco9.setBackground(new Color(255, 255, 102));

        GroupLayout screenDeco9Layout = new GroupLayout(screenDeco9);
        screenDeco9.setLayout(screenDeco9Layout);
        screenDeco9Layout.setHorizontalGroup(
            screenDeco9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        screenDeco9Layout.setVerticalGroup(
            screenDeco9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        screenDeco10.setBackground(new Color(255, 255, 102));

        GroupLayout screenDeco10Layout = new GroupLayout(screenDeco10);
        screenDeco10.setLayout(screenDeco10Layout);
        screenDeco10Layout.setHorizontalGroup(
            screenDeco10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        screenDeco10Layout.setVerticalGroup(
            screenDeco10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        screenDeco11.setBackground(new Color(255, 255, 102));

        GroupLayout screenDeco11Layout = new GroupLayout(screenDeco11);
        screenDeco11.setLayout(screenDeco11Layout);
        screenDeco11Layout.setHorizontalGroup(
            screenDeco11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        screenDeco11Layout.setVerticalGroup(
            screenDeco11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        screenDeco12.setBackground(new Color(255, 255, 102));

        GroupLayout screenDeco12Layout = new GroupLayout(screenDeco12);
        screenDeco12.setLayout(screenDeco12Layout);
        screenDeco12Layout.setHorizontalGroup(
            screenDeco12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        screenDeco12Layout.setVerticalGroup(
            screenDeco12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        screenDeco1.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco1Layout = new GroupLayout(screenDeco1);
        screenDeco1.setLayout(screenDeco1Layout);
        screenDeco1Layout.setHorizontalGroup(
            screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        screenDeco1Layout.setVerticalGroup(
            screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        screenDeco2.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco2Layout = new GroupLayout(screenDeco2);
        screenDeco2.setLayout(screenDeco2Layout);
        screenDeco2Layout.setHorizontalGroup(
            screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        screenDeco2Layout.setVerticalGroup(
            screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        screenDeco3.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco3Layout = new GroupLayout(screenDeco3);
        screenDeco3.setLayout(screenDeco3Layout);
        screenDeco3Layout.setHorizontalGroup(
            screenDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        screenDeco3Layout.setVerticalGroup(
            screenDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        screenDeco4.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco4Layout = new GroupLayout(screenDeco4);
        screenDeco4.setLayout(screenDeco4Layout);
        screenDeco4Layout.setHorizontalGroup(
            screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        screenDeco4Layout.setVerticalGroup(
            screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        screenDeco5.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco5Layout = new GroupLayout(screenDeco5);
        screenDeco5.setLayout(screenDeco5Layout);
        screenDeco5Layout.setHorizontalGroup(
            screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        screenDeco5Layout.setVerticalGroup(
            screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        screenDeco6.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco6Layout = new GroupLayout(screenDeco6);
        screenDeco6.setLayout(screenDeco6Layout);
        screenDeco6Layout.setHorizontalGroup(
            screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        screenDeco6Layout.setVerticalGroup(
            screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        screenDeco7.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco7Layout = new GroupLayout(screenDeco7);
        screenDeco7.setLayout(screenDeco7Layout);
        screenDeco7Layout.setHorizontalGroup(
            screenDeco7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        screenDeco7Layout.setVerticalGroup(
            screenDeco7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        screenDeco8.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco8Layout = new GroupLayout(screenDeco8);
        screenDeco8.setLayout(screenDeco8Layout);
        screenDeco8Layout.setHorizontalGroup(
            screenDeco8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        screenDeco8Layout.setVerticalGroup(
            screenDeco8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        exitButton.setBackground(new Color(51, 51, 51));
        exitButton.setForeground(new Color(255, 255, 255));
        exitButton.setText("Exit");
        exitButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                exitButtonMousePressed(evt);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        deleteStatus.setFont(new Font("Segoe UI", 3, 12)); 
        deleteStatus.setForeground(new Color(255, 51, 51));
        deleteStatus.setHorizontalAlignment(SwingConstants.CENTER);
        deleteStatus.setHorizontalTextPosition(SwingConstants.RIGHT);

        passwordField.setEchoChar((char) 0);
        passwordField.setBackground(new Color(51, 51, 51));
        passwordField.setFont(new Font("Dialog", 0, 12)); 
        passwordField.setForeground(new Color(204, 204, 204));
        passwordField.setText("Password");
        passwordField.setBorder(null);
        passwordField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
        });
        passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        passwordSeparator.setBackground(new Color(255, 255, 255));
        passwordSeparator.setForeground(new Color(255, 255, 255));

        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addComponent(screenDeco11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(screenDeco8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenDeco9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(screenDeco10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(screenDeco4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(screenDeco7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addComponent(emailPasswordPrompt)
                        .addGap(8, 8, 8)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenDeco12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(screenDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(screenDeco6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(screenDeco2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteStatus, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(screenDeco5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(submitButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addGap(135, 135, 135))
            .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordField, GroupLayout.Alignment.TRAILING)
                    .addComponent(emailSeparator, GroupLayout.Alignment.TRAILING)
                    .addComponent(emailField, GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordSeparator, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(screenDeco10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(screenDeco12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(screenDeco4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(screenDeco7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(screenDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addComponent(screenDeco6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(screenDeco5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(screenDeco9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(menuPanelLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(screenDeco8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addComponent(screenDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(screenDeco2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(screenDeco11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(emailPasswordPrompt, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(emailSeparator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(passwordSeparator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(exitButton)
                                    .addComponent(submitButton, GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteStatus, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                      

    // Events for different components for the delete account view 
    private void submitButtonActionPerformed(ActionEvent evt) {}                                        
    private void emailFieldActionPerformed(ActionEvent evt) {}                                           
    private void exitButtonActionPerformed(ActionEvent evt) {}                                        

    private void exitButtonMousePressed(MouseEvent evt) {                                      
        this.dispose();
    }                                     

    // Events that update the view of the fields based on their contents
    private void emailFieldMouseClicked(MouseEvent evt) {                                         
        if (emailField.getText().equals("Email")) {
            emailField.setText("");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setEchoChar((char) 0);
        	passwordField.setText("Password");
        }
    }                                        

    private void formMouseClicked(MouseEvent evt) {                                  
        if (emailField.getText().equals("")) {
            emailField.setText("Email");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setEchoChar((char) 0);
        	passwordField.setText("Password");
        }
    }                                 
    
    // Button event that handles user deletion based on the input and user file contents
    private void submitButtonMouseClicked(MouseEvent evt) throws IOException {                                      
    	enc.decryptFile(key, userFile, userFile);
    	String email = emailField.getText();
    	String password = passwordField.getText();
    	String[] user = usc.getUser("email", email);
    	if (user == null) {
    		deleteStatus.setForeground(new Color(255, 51, 51));
		    deleteStatus.setText("Account does not exist!");
    	} else if (email.equals("Email") || email.equals("") || password.equals("Password") || password.equals("") ||
    			!user[1].equals(password)) {
    		deleteStatus.setForeground(new Color(255, 51, 51));
    		deleteStatus.setText("Invalid email or password!");
        } else if (user[1].equals(password) && user[2].equals(email)) {
			usc.deleteUser(email);
			deleteStatus.setForeground(new Color(102, 255, 102));
		    deleteStatus.setText("Account deleted successfully!");
		}
    	enc.encryptFile(key, userFile, userFile);
    }                                       

    private void passwordFieldMouseClicked(MouseEvent evt) {                                         
        if (passwordField.getText().equals("Password")) {
            passwordField.setEchoChar('*');
        	passwordField.setText("");
        }
        if (emailField.getText().equals("")) {
        	emailField.setText("Email");
        }
    }                                        

    private void passwordFieldActionPerformed(ActionEvent evt) {}                                           
                      
}
