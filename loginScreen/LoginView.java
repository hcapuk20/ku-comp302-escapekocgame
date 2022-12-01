package loginScreen;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.nio.file.Paths;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class LoginView extends JFrame {

    private int xx;
    private int yy;

    private JButton loginButton;
    private JButton signUpButton;
    private JLabel passwordCheck;
    private JLabel titleEscape;
    private JLabel titleKoç;
    private JLabel accountDeleteCheck;
    private JLabel exitButton;
    private JLabel logoGame;
    private JLabel titleFrom;
    private JPanel logoTitle;
    private JPanel inputScreen;
    private JSeparator usernameSeparator;
    private JSeparator emailSeparator;
    private JTextField jTextField1;
    private JTextField jTextField2;
    
    public LoginView() {
        initComponents();
    }
                        
    private void initComponents() {

        logoTitle = new JPanel();
        titleEscape = new JLabel();
        titleKoç = new JLabel();
        logoGame = new JLabel();
        titleFrom = new JLabel();
        inputScreen = new JPanel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        usernameSeparator = new JSeparator();
        emailSeparator = new JSeparator();
        loginButton = new JButton();
        signUpButton = new JButton();
        passwordCheck = new JLabel();
        accountDeleteCheck = new JLabel();
        exitButton = new JLabel();
         
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        logoTitle.setBackground(new Color(255, 255, 255));

        titleEscape.setFont(new Font("GeoSlab703 Md BT", 0, 48));
        titleEscape.setHorizontalAlignment(SwingConstants.CENTER);
        titleEscape.setText(" ESCAPE ");

        titleKoç.setFont(new Font("GeoSlab703 Md BT", 0, 48));
        titleKoç.setHorizontalAlignment(SwingConstants.CENTER);
        titleKoç.setText("KOÇ");

        logoGame.setIcon(new ImageIcon(Paths.get("").resolve("assets/logo.png").toAbsolutePath().toString()));
        logoGame.setText("logoGame");

        titleFrom.setFont(new Font("GeoSlab703 Md BT", 0, 48));
        titleFrom.setText("FROM");

        GroupLayout logoTitleLayout = new GroupLayout(logoTitle);
        logoTitle.setLayout(logoTitleLayout);
        logoTitleLayout.setHorizontalGroup(
            logoTitleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(logoTitleLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(logoTitleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, logoTitleLayout.createSequentialGroup()
                        .addComponent(logoGame, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(GroupLayout.Alignment.TRAILING, logoTitleLayout.createSequentialGroup()
                        .addComponent(titleEscape, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(GroupLayout.Alignment.TRAILING, logoTitleLayout.createSequentialGroup()
                        .addGroup(logoTitleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(titleFrom)
                            .addGroup(logoTitleLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(titleKoç, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68))))
        );
        logoTitleLayout.setVerticalGroup(
            logoTitleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(logoTitleLayout.createSequentialGroup()
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

        jTextField1.setBackground(new Color(51, 51, 51));
        jTextField1.setFont(new Font("Dialog", 0, 12));
        jTextField1.setForeground(new Color(204, 204, 204));
        jTextField1.setText("Username");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new Color(51, 51, 51));
        jTextField2.setFont(new Font("Dialog", 0, 12));
        jTextField2.setForeground(new Color(204, 204, 204));
        jTextField2.setText("Email");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        usernameSeparator.setBackground(new Color(255, 255, 255));
        usernameSeparator.setForeground(new Color(255, 255, 255));

        emailSeparator.setBackground(new Color(255, 255, 255));
        emailSeparator.setForeground(new Color(255, 255, 255));

        loginButton.setBackground(new Color(51, 51, 51));
        loginButton.setFont(new Font("Dialog", 0, 12));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setText("Login");

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
        passwordCheck.setText("Forgot username?");
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

        accountDeleteCheck.setFont(new Font("Segoe UI", 1, 12));
        accountDeleteCheck.setForeground(new Color(255, 255, 255));
        accountDeleteCheck.setText("Delete account");
        accountDeleteCheck.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                accountDeleteCheckMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                accountDeleteCheckMouseExited(evt);
            }
            public void mouseClicked(MouseEvent evt) {
            	accountDeleteCheckMouseClicked(evt);
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

        GroupLayout inputScreenLayout = new GroupLayout(inputScreen);
        inputScreen.setLayout(inputScreenLayout);
        inputScreenLayout.setHorizontalGroup(
            inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(inputScreenLayout.createSequentialGroup()
                .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputScreenLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailSeparator, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addGroup(inputScreenLayout.createSequentialGroup()
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                            .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameSeparator, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, inputScreenLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, inputScreenLayout.createSequentialGroup()
                        .addComponent(accountDeleteCheck, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(GroupLayout.Alignment.TRAILING, inputScreenLayout.createSequentialGroup()
                        .addComponent(passwordCheck, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))))
        );
        inputScreenLayout.setVerticalGroup(
            inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(inputScreenLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(usernameSeparator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(emailSeparator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(inputScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addComponent(passwordCheck, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountDeleteCheck)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(inputScreen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(logoTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inputScreen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }                      

    private void jTextField1ActionPerformed(ActionEvent evt) {}                                           
    private void jTextField2ActionPerformed(ActionEvent evt) {}                                           

    private void exitButtonMouseClicked(MouseEvent evt) {                                     
        System.exit(0);
    }                                    

    private void formMouseDragged(MouseEvent evt) {                                  
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx, y-yy);
    }                                 

    private void accountDeleteCheckMouseClicked(MouseEvent evt) {
    	DeleteAccountWindow deleteAccount = new DeleteAccountWindow();
    	deleteAccount.setVisible(true);
    }
    
    
    private void passwordCheckMouseClicked(MouseEvent evt) {                                     
    	ForgotPasswordWindow forgotPassword = new ForgotPasswordWindow();
    	forgotPassword.setVisible(true);
    }                      
    
    private void signUpButtonMouseClicked(MouseEvent evt) {
    	SignUpMenu signUpMenu = new SignUpMenu();
    	signUpMenu.setVisible(true);
    }
    
    private void passwordCheckMouseEntered(MouseEvent evt) {                                     
        passwordCheck.setText("<HTML><u>Forgot username?</u></HTML>");
        passwordCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }                                    

    private void passwordCheckMouseExited(MouseEvent evt) {                                    
        passwordCheck.setText("Forgot username?");
    }                                   

    private void accountDeleteCheckMouseEntered(MouseEvent evt) {                                     
        accountDeleteCheck.setText("<HTML><u>Delete account</u></HTML>");
        accountDeleteCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }                                    

    private void accountDeleteCheckMouseExited(MouseEvent evt) {                                    
        accountDeleteCheck.setText("Delete account");
    }                                   

    private void exitButtonMouseEntered(MouseEvent evt) {                                     
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }                                    

    private void formMousePressed(MouseEvent evt) {                                  
        xx=evt.getX();
        yy=evt.getY();  
    }                                 

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }                            
}
