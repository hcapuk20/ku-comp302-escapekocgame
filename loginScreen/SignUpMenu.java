package loginScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class SignUpMenu extends JFrame {
    
	private JButton exitButton;
    private JButton signUpButton;
    private JLabel registerPlayerText;
    private JLabel registerStatus;
    private JPanel menuBorders;
    private JPanel screenDeco1;
    private JPanel screenDeco2;
    private JPanel screenDeco3;
    private JPanel screenDeco4;
    private JPanel screenDeco5;
    private JPanel screenDeco6;
    private JPanel screenDeco7;
    private JPanel screenDeco8;
    private JPanel screenDeco9;
    private JPanel screenDeco10;
    private JPanel screenDeco11;
    private JPanel screenDeco12;
    private JPanel screenDeco13;
    private JPanel screenDeco14;
    private JPanel screenDeco15;
    private JPanel screenDeco16;
    private JPanel screenDeco17;
    private JPanel screenDeco18;
    private JPanel screenDeco19;
    private JPanel screenDeco20;
    private JSeparator registerPlayerTextSeparator;
    private JSeparator usernameSeparator;
    private JSeparator passwordSeparator;
    private JSeparator emailSeparator;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField emailField; 
	
	
    public SignUpMenu() {
        initComponents();
    }
                       
    private void initComponents() {

        menuBorders = new JPanel();
        registerPlayerText = new JLabel();
        screenDeco17 = new JPanel();
        screenDeco18 = new JPanel();
        screenDeco20 = new JPanel();
        screenDeco19 = new JPanel();
        screenDeco1 = new JPanel();
        screenDeco9 = new JPanel();
        screenDeco3 = new JPanel();
        screenDeco11 = new JPanel();
        screenDeco4 = new JPanel();
        screenDeco12 = new JPanel();
        screenDeco5 = new JPanel();
        screenDeco10 = new JPanel();
        screenDeco6 = new JPanel();
        screenDeco13 = new JPanel();
        screenDeco7 = new JPanel();
        screenDeco14 = new JPanel();
        screenDeco8 = new JPanel();
        screenDeco15 = new JPanel();
        screenDeco2 = new JPanel();
        screenDeco16 = new JPanel();
        registerPlayerTextSeparator = new JSeparator();
        exitButton = new JButton();
        signUpButton = new JButton();
        usernameField = new JTextField();
        usernameSeparator = new JSeparator();
        passwordField = new JTextField();
        passwordSeparator = new JSeparator();
        emailField = new JTextField();
        emailSeparator = new JSeparator();
        registerStatus = new JLabel();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register User");
        setBackground(new Color(51, 51, 51));
        setUndecorated(true);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        menuBorders.setBackground(new Color(51, 51, 51));
        menuBorders.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));

        registerPlayerText.setFont(new Font("Segoe UI", 1, 18)); 
        registerPlayerText.setForeground(new Color(255, 255, 255));
        registerPlayerText.setText("Register Player");

        screenDeco17.setBackground(new Color(255, 51, 51));

        GroupLayout screenDeco17Layout = new GroupLayout(screenDeco17);
        screenDeco17.setLayout(screenDeco17Layout);
        screenDeco17Layout.setHorizontalGroup(
            screenDeco17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        screenDeco17Layout.setVerticalGroup(
            screenDeco17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        screenDeco18.setBackground(new Color(255, 51, 51));

        GroupLayout screenDeco18Layout = new GroupLayout(screenDeco18);
        screenDeco18.setLayout(screenDeco18Layout);
        screenDeco18Layout.setHorizontalGroup(
            screenDeco18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        screenDeco18Layout.setVerticalGroup(
            screenDeco18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        screenDeco20.setBackground(new Color(255, 51, 51));

        GroupLayout screenDeco20Layout = new GroupLayout(screenDeco20);
        screenDeco20.setLayout(screenDeco20Layout);
        screenDeco20Layout.setHorizontalGroup(
            screenDeco20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        screenDeco20Layout.setVerticalGroup(
            screenDeco20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        screenDeco19.setBackground(new Color(255, 51, 51));

        GroupLayout screenDeco19Layout = new GroupLayout(screenDeco19);
        screenDeco19.setLayout(screenDeco19Layout);
        screenDeco19Layout.setHorizontalGroup(
            screenDeco19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        screenDeco19Layout.setVerticalGroup(
            screenDeco19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        screenDeco1.setBackground(new Color(255, 51, 51));

        screenDeco9.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco9Layout = new GroupLayout(screenDeco9);
        screenDeco9.setLayout(screenDeco9Layout);
        screenDeco9Layout.setHorizontalGroup(
            screenDeco9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        screenDeco9Layout.setVerticalGroup(
            screenDeco9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        GroupLayout screenDeco1Layout = new GroupLayout(screenDeco1);
        screenDeco1.setLayout(screenDeco1Layout);
        screenDeco1Layout.setHorizontalGroup(
            screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
            .addGroup(screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        screenDeco1Layout.setVerticalGroup(
            screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        screenDeco3.setBackground(new Color(255, 51, 51));

        screenDeco11.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco11Layout = new GroupLayout(screenDeco11);
        screenDeco11.setLayout(screenDeco11Layout);
        screenDeco11Layout.setHorizontalGroup(
            screenDeco11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        screenDeco11Layout.setVerticalGroup(
            screenDeco11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        GroupLayout screenDeco3Layout = new GroupLayout(screenDeco3);
        screenDeco3.setLayout(screenDeco3Layout);
        screenDeco3Layout.setHorizontalGroup(
            screenDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
            .addGroup(screenDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        screenDeco3Layout.setVerticalGroup(
            screenDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(screenDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        screenDeco4.setBackground(new Color(255, 51, 51));

        screenDeco12.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco12Layout = new GroupLayout(screenDeco12);
        screenDeco12.setLayout(screenDeco12Layout);
        screenDeco12Layout.setHorizontalGroup(
            screenDeco12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        screenDeco12Layout.setVerticalGroup(
            screenDeco12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        GroupLayout screenDeco4Layout = new GroupLayout(screenDeco4);
        screenDeco4.setLayout(screenDeco4Layout);
        screenDeco4Layout.setHorizontalGroup(
            screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
            .addGroup(screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        screenDeco4Layout.setVerticalGroup(
            screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        screenDeco5.setBackground(new Color(255, 51, 51));

        screenDeco10.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco10Layout = new GroupLayout(screenDeco10);
        screenDeco10.setLayout(screenDeco10Layout);
        screenDeco10Layout.setHorizontalGroup(
            screenDeco10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        screenDeco10Layout.setVerticalGroup(
            screenDeco10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        GroupLayout screenDeco5Layout = new GroupLayout(screenDeco5);
        screenDeco5.setLayout(screenDeco5Layout);
        screenDeco5Layout.setHorizontalGroup(
            screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
            .addGroup(screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        screenDeco5Layout.setVerticalGroup(
            screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        screenDeco6.setBackground(new Color(255, 51, 51));

        screenDeco13.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco13Layout = new GroupLayout(screenDeco13);
        screenDeco13.setLayout(screenDeco13Layout);
        screenDeco13Layout.setHorizontalGroup(
            screenDeco13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        screenDeco13Layout.setVerticalGroup(
            screenDeco13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        GroupLayout screenDeco6Layout = new GroupLayout(screenDeco6);
        screenDeco6.setLayout(screenDeco6Layout);
        screenDeco6Layout.setHorizontalGroup(
            screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
            .addGroup(screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        screenDeco6Layout.setVerticalGroup(
            screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        screenDeco7.setBackground(new Color(255, 51, 51));

        screenDeco14.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco14Layout = new GroupLayout(screenDeco14);
        screenDeco14.setLayout(screenDeco14Layout);
        screenDeco14Layout.setHorizontalGroup(
            screenDeco14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        screenDeco14Layout.setVerticalGroup(
            screenDeco14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        GroupLayout screenDeco7Layout = new GroupLayout(screenDeco7);
        screenDeco7.setLayout(screenDeco7Layout);
        screenDeco7Layout.setHorizontalGroup(
            screenDeco7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
            .addGroup(screenDeco7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        screenDeco7Layout.setVerticalGroup(
            screenDeco7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(screenDeco7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        screenDeco8.setBackground(new Color(255, 51, 51));

        screenDeco15.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco15Layout = new GroupLayout(screenDeco15);
        screenDeco15.setLayout(screenDeco15Layout);
        screenDeco15Layout.setHorizontalGroup(
            screenDeco15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        screenDeco15Layout.setVerticalGroup(
            screenDeco15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        GroupLayout screenDeco8Layout = new GroupLayout(screenDeco8);
        screenDeco8.setLayout(screenDeco8Layout);
        screenDeco8Layout.setHorizontalGroup(
            screenDeco8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
            .addGroup(screenDeco8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        screenDeco8Layout.setVerticalGroup(
            screenDeco8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(screenDeco8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        screenDeco2.setBackground(new Color(255, 51, 51));

        screenDeco16.setBackground(new Color(255, 255, 255));

        GroupLayout screenDeco16Layout = new GroupLayout(screenDeco16);
        screenDeco16.setLayout(screenDeco16Layout);
        screenDeco16Layout.setHorizontalGroup(
            screenDeco16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        screenDeco16Layout.setVerticalGroup(
            screenDeco16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        GroupLayout screenDeco2Layout = new GroupLayout(screenDeco2);
        screenDeco2.setLayout(screenDeco2Layout);
        screenDeco2Layout.setHorizontalGroup(
            screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
            .addGroup(screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        screenDeco2Layout.setVerticalGroup(
            screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
            .addGroup(screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(screenDeco2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(screenDeco16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        exitButton.setBackground(new Color(51, 51, 51));
        exitButton.setForeground(new Color(255, 255, 255));
        exitButton.setText("    Exit    ");
        exitButton.setHorizontalTextPosition(SwingConstants.CENTER);
        exitButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        signUpButton.setBackground(new Color(51, 51, 51));
        signUpButton.setForeground(new Color(255, 255, 255));
        signUpButton.setText("Sign Up");
        signUpButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                signUpButtonMouseClicked(evt);
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

        usernameSeparator.setBackground(new Color(255, 255, 255));
        usernameSeparator.setForeground(new Color(255, 255, 255));

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

        registerStatus.setFont(new Font("Segoe UI", 3, 12)); 
        registerStatus.setForeground(new Color(255, 51, 51));
        registerStatus.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout menuBordersLayout = new GroupLayout(menuBorders);
        menuBorders.setLayout(menuBordersLayout);
        menuBordersLayout.setHorizontalGroup(
            menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuBordersLayout.createSequentialGroup()
                .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(screenDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuBordersLayout.createSequentialGroup()
                        .addComponent(screenDeco19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(screenDeco5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menuBordersLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(registerPlayerText)
                        .addGap(89, 89, 89))
                    .addGroup(menuBordersLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(registerPlayerTextSeparator, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(menuBordersLayout.createSequentialGroup()
                        .addComponent(screenDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(screenDeco18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(screenDeco4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(menuBordersLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(screenDeco20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenDeco7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(screenDeco8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenDeco17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(menuBordersLayout.createSequentialGroup()
                .addComponent(screenDeco6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(menuBordersLayout.createSequentialGroup()
                        .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GroupLayout.Alignment.LEADING, menuBordersLayout.createSequentialGroup()
                                .addComponent(signUpButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitButton))
                            .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameSeparator, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordSeparator, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailSeparator, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(screenDeco2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuBordersLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(registerStatus, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        menuBordersLayout.setVerticalGroup(
            menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuBordersLayout.createSequentialGroup()
                .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(screenDeco18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(screenDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenDeco4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, menuBordersLayout.createSequentialGroup()
                        .addComponent(screenDeco2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(screenDeco17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(screenDeco8, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(menuBordersLayout.createSequentialGroup()
                .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(screenDeco19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(screenDeco5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerPlayerText, GroupLayout.Alignment.TRAILING))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(screenDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerPlayerTextSeparator, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(usernameSeparator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(passwordSeparator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(emailSeparator, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerStatus, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, menuBordersLayout.createSequentialGroup()
                        .addComponent(screenDeco6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(screenDeco20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, menuBordersLayout.createSequentialGroup()
                        .addGroup(menuBordersLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(signUpButton)
                            .addComponent(exitButton))
                        .addGap(38, 38, 38)
                        .addComponent(screenDeco7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menuBorders, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menuBorders, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        
                                

    private void exitButtonMouseClicked(MouseEvent evt) {                                      
        this.setVisible(false);
    }                                     

    private void usernameFieldActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void passwordFieldActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void emailFieldActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void usernameFieldMouseClicked(MouseEvent evt) {                                         
        if (usernameField.getText().equals("Username")) {
            usernameField.setText("");
        }
        if (passwordField.getText().equals("")) {
            passwordField.setText("Password");
        }
        if (emailField.getText().equals("")) {
            emailField.setText("Email");
        }
    }                                        

    private void passwordFieldMouseClicked(MouseEvent evt) {                                         
        if (passwordField.getText().equals("Password")) {
            passwordField.setText("");
        }
        if (usernameField.getText().equals("")) {
            usernameField.setText("Username");
        }
        if (emailField.getText().equals("")) {
            emailField.setText("Email");
        }
    }                                        

    private void emailFieldMouseClicked(MouseEvent evt) {                                         
        if (emailField.getText().equals("Email")) {
            emailField.setText("");
        }
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
        if (emailField.getText().equals("")) {
            emailField.setText("Email");
        }
    }                                 

    private void signUpButtonMouseClicked(MouseEvent evt) {                                      
    }                                                                         
}
