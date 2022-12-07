package loginScreen;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class LoginView extends JFrame {

	private JButton loginButton;
    private JButton signUpButton;
    private JLabel passwordCheck;
    private JLabel titleEscape;
    private JLabel titleKoç;
    private JLabel deleteAccountCheck;
    private JLabel exitButton;
    private JLabel logoGame;
    private JLabel titleFrom;
    private JLabel loginStatus;
    private JPanel screenDeco5;
    private JPanel screenDeco1;
    private JPanel screenDeco2;
    private JPanel screenDeco3;
    private JPanel inputScreen;
    private JPanel screenDeco4;
    private JPanel screenDeco6;
    private JPanel screenDeco7;
    private JPanel screenDeco8;
    private JPanel screenDeco9;
    private JPanel screenDeco10;
    private JSeparator usernameSeparator;
    private JSeparator passwordSeparator;
    private JTextField usernameField;
    private JTextField passwordField;

    public LoginView() {
        initComponents();
    }
                        
    private void initComponents() {

        screenDeco5 = new JPanel();
        titleEscape = new JLabel();
        titleKoç = new JLabel();
        logoGame = new JLabel();
        titleFrom = new JLabel();
        inputScreen = new JPanel();
        usernameField = new JTextField();
        passwordField = new JTextField();
        usernameSeparator = new JSeparator();
        passwordSeparator = new JSeparator();
        loginButton = new JButton();
        signUpButton = new JButton();
        passwordCheck = new JLabel();
        deleteAccountCheck = new JLabel();
        exitButton = new JLabel();
        screenDeco6 = new JPanel();
        screenDeco7 = new JPanel();
        screenDeco9 = new JPanel();
        screenDeco10 = new JPanel();
        screenDeco4 = new JPanel();
        screenDeco1 = new JPanel();
        screenDeco2 = new JPanel();
        screenDeco3 = new JPanel();
        screenDeco8 = new JPanel();
        loginStatus = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Screen");
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        screenDeco5.setBackground(new Color(255, 255, 255));

        titleEscape.setFont(new Font("GeoSlab703 Md BT", 0, 48)); 
        titleEscape.setHorizontalAlignment(SwingConstants.CENTER);
        titleEscape.setText(" ESCAPE ");

        titleKoç.setFont(new Font("GeoSlab703 Md BT", 0, 48)); 
        titleKoç.setHorizontalAlignment(SwingConstants.CENTER);
        titleKoç.setText("KOÇ");

        logoGame.setIcon(new ImageIcon(getClass().getResource("/assets/logo.png"))); 
        logoGame.setText("logoGame");

        titleFrom.setFont(new Font("GeoSlab703 Md BT", 0, 48)); 
        titleFrom.setText("FROM");

        GroupLayout screenDeco5Layout = new GroupLayout(screenDeco5);
        screenDeco5.setLayout(screenDeco5Layout);
        screenDeco5Layout.setHorizontalGroup(
            screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(screenDeco5Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, screenDeco5Layout.createSequentialGroup()
                        .addComponent(logoGame, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(GroupLayout.Alignment.TRAILING, screenDeco5Layout.createSequentialGroup()
                        .addComponent(titleEscape, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(GroupLayout.Alignment.TRAILING, screenDeco5Layout.createSequentialGroup()
                        .addGroup(screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(titleFrom)
                            .addGroup(screenDeco5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(titleKoç, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68))))
        );
        screenDeco5Layout.setVerticalGroup(
            screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(screenDeco5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(logoGame, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(titleEscape, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(titleFrom)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleKoç, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        inputScreen.setBackground(new Color(51, 51, 51));
        inputScreen.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        inputScreen.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                inputScreenMouseClicked(evt);
            }
        });

        usernameField.setBackground(new Color(51, 51, 51));
        usernameField.setFont(new Font("Dialog", 0, 12)); 
        usernameField.setForeground(new Color(204, 204, 204));
        usernameField.setText("Username");
        usernameField.setBorder(null);
        usernameField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                usernameFieldMouseClicked(evt);
            }
        });
        usernameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

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

        usernameSeparator.setBackground(new Color(255, 255, 255));
        usernameSeparator.setForeground(new Color(255, 255, 255));

        passwordSeparator.setBackground(new Color(255, 255, 255));
        passwordSeparator.setForeground(new Color(255, 255, 255));

        loginButton.setBackground(new Color(51, 51, 51));
        loginButton.setFont(new Font("Dialog", 0, 12)); 
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });

        signUpButton.setBackground(new Color(51, 51, 51));
        signUpButton.setFont(new Font("Dialog", 0, 12)); 
        signUpButton.setForeground(new Color(255, 255, 255));
        signUpButton.setText("Sign Up");
        signUpButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                signUpButtonMouseClicked(evt);
            }
        });

        passwordCheck.setFont(new Font("Segoe UI", 1, 12)); 
        passwordCheck.setForeground(new Color(255, 255, 255));
        passwordCheck.setText("Forgot password?");
        passwordCheck.setHorizontalTextPosition(SwingConstants.CENTER);
        passwordCheck.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                passwordCheckMouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                passwordCheckMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                passwordCheckMouseExited(evt);
            }
        });

        deleteAccountCheck.setFont(new Font("Segoe UI", 1, 12)); 
        deleteAccountCheck.setForeground(new Color(255, 255, 255));
        deleteAccountCheck.setText("Delete account");
        deleteAccountCheck.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                deleteAccountCheckMouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                deleteAccountCheckMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                deleteAccountCheckMouseExited(evt);
            }
        });

        exitButton.setFont(new Font("Segoe UI", 1, 24)); 
        exitButton.setForeground(new Color(255, 255, 255));
        exitButton.setText(" X");
        exitButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
        });

        screenDeco6.setBackground(new Color(204, 153, 255));

        GroupLayout screenDeco6Layout = new GroupLayout(screenDeco6);
        screenDeco6.setLayout(screenDeco6Layout);
        screenDeco6Layout.setHorizontalGroup(
            screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        screenDeco6Layout.setVerticalGroup(
            screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        screenDeco7.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco7Layout = new GroupLayout(screenDeco7);
        screenDeco7.setLayout(screenDeco7Layout);
        screenDeco7Layout.setHorizontalGroup(
            screenDeco7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        screenDeco7Layout.setVerticalGroup(
            screenDeco7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        screenDeco9.setBackground(new Color(204, 153, 255));

        GroupLayout screenDeco9Layout = new GroupLayout(screenDeco9);
        screenDeco9.setLayout(screenDeco9Layout);
        screenDeco9Layout.setHorizontalGroup(
            screenDeco9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        screenDeco9Layout.setVerticalGroup(
            screenDeco9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        screenDeco10.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco10Layout = new GroupLayout(screenDeco10);
        screenDeco10.setLayout(screenDeco10Layout);
        screenDeco10Layout.setHorizontalGroup(
            screenDeco10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        screenDeco10Layout.setVerticalGroup(
            screenDeco10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        screenDeco4.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco4Layout = new GroupLayout(screenDeco4);
        screenDeco4.setLayout(screenDeco4Layout);
        screenDeco4Layout.setHorizontalGroup(
            screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        screenDeco4Layout.setVerticalGroup(
            screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        screenDeco1.setBackground(new Color(204, 153, 255));

        GroupLayout screenDeco1Layout = new GroupLayout(screenDeco1);
        screenDeco1.setLayout(screenDeco1Layout);
        screenDeco1Layout.setHorizontalGroup(
            screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        screenDeco1Layout.setVerticalGroup(
            screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        screenDeco2.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco2Layout = new GroupLayout(screenDeco2);
        screenDeco2.setLayout(screenDeco2Layout);
        screenDeco2Layout.setHorizontalGroup(
            screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        screenDeco2Layout.setVerticalGroup(
            screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        screenDeco3.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco3Layout = new GroupLayout(screenDeco3);
        screenDeco3.setLayout(screenDeco3Layout);
        screenDeco3Layout.setHorizontalGroup(
            screenDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        screenDeco3Layout.setVerticalGroup(
            screenDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        screenDeco8.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco8Layout = new GroupLayout(screenDeco8);
        screenDeco8.setLayout(screenDeco8Layout);
        screenDeco8Layout.setHorizontalGroup(
            screenDeco8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        screenDeco8Layout.setVerticalGroup(
            screenDeco8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        loginStatus.setFont(new Font("Segoe UI", 3, 12)); 
        loginStatus.setForeground(new Color(255, 51, 51));
        loginStatus.setHorizontalAlignment(SwingConstants.CENTER);
        loginStatus.setText("                                      ");
        loginStatus.setHorizontalTextPosition(SwingConstants.CENTER);

        GroupLayout inputScreenLayout = new GroupLayout(inputScreen);
        inputScreen.setLayout(inputScreenLayout);
        inputScreenLayout.setHorizontalGroup(
            inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(inputScreenLayout.createSequentialGroup()
                .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(screenDeco10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(passwordCheck, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                            .addGroup(inputScreenLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(deleteAccountCheck, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                        .addGap(138, 138, 138))
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addComponent(screenDeco9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(screenDeco4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(screenDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.TRAILING, inputScreenLayout.createSequentialGroup()
                        .addComponent(screenDeco2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(inputScreenLayout.createSequentialGroup()
                .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(inputScreenLayout.createSequentialGroup()
                                .addComponent(screenDeco6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(screenDeco7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(screenDeco8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, inputScreenLayout.createSequentialGroup()
                        .addGap(120, 426, Short.MAX_VALUE)
                        .addComponent(screenDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordSeparator, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addGroup(inputScreenLayout.createSequentialGroup()
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameSeparator, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(inputScreenLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(loginStatus, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputScreenLayout.setVerticalGroup(
            inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(inputScreenLayout.createSequentialGroup()
                .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(screenDeco7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(usernameSeparator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(passwordSeparator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(loginStatus, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(passwordCheck, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteAccountCheck)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(screenDeco4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(screenDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(screenDeco2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(screenDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
            .addGroup(inputScreenLayout.createSequentialGroup()
                .addComponent(screenDeco6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenDeco8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(screenDeco10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenDeco9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(screenDeco5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(inputScreen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(screenDeco5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inputScreen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                       

    private void usernameFieldActionPerformed(ActionEvent evt) {}                                           
    private void passwordFieldActionPerformed(ActionEvent evt) {}                                           

    private void exitButtonMouseClicked(MouseEvent evt) {                                     
        System.exit(0);
    }                                    

    private void passwordCheckMouseClicked(MouseEvent evt) {                                     
        ForgotPasswordWindow forgotPassword = new ForgotPasswordWindow();
        forgotPassword.setVisible(true);
    }                                    

    private void passwordCheckMouseEntered(MouseEvent evt) {                                     
        passwordCheck.setText("<HTML><u>Forgot password?</u></HTML>");
        passwordCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }                                    

    private void passwordCheckMouseExited(MouseEvent evt) {                                    
        passwordCheck.setText("Forgot password?");
    }                                   

    private void deleteAccountCheckMouseEntered(MouseEvent evt) {                                     
        deleteAccountCheck.setText("<HTML><u>Delete account</u></HTML>");
        deleteAccountCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }                                    

    private void deleteAccountCheckMouseExited(MouseEvent evt) {                                    
        deleteAccountCheck.setText("Delete account");
    }                                   

    private void exitButtonMouseEntered(MouseEvent evt) {                                     
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }                                    

    private void signUpButtonMouseClicked(MouseEvent evt) {                                      
        SignUpMenu signUpPanel = new SignUpMenu();
        signUpPanel.setVisible(true);
        
    }                                     

    private void deleteAccountCheckMouseClicked(MouseEvent evt) {                                     
        DeleteAccountWindow deleteAccount = new DeleteAccountWindow();
        deleteAccount.setVisible(true);
    }                                    

    private void inputScreenMouseClicked(MouseEvent evt) {                                     
    	if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setText("Password");
        }
    }                                    

    private void formMouseClicked(MouseEvent evt) {                                  
    	if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setText("Password");
        }
    }                                 

    private void passwordFieldMouseClicked(MouseEvent evt) {                                         
    	if (passwordField.getText().equals("Password")) {
            passwordField.setText("");
        }
        if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
    }                                        

    private void usernameFieldMouseClicked(MouseEvent evt) {                                         
    	if (usernameField.getText().equals("Username")) {
            usernameField.setText("");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setText("Password");
        }
    }                                        

    private void loginButtonMouseClicked(MouseEvent evt) {                                      
        
    }                                                       
}
