package helpScreen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class HowToPlayInfo extends JFrame {

	private JLabel title;
    private JLabel infoText;
    private JPanel howToPlayPanel;
    private JPanel screenDeco1;
    private JPanel screenDeco2;
    private JPanel screenDeco3;
    private JPanel screenDeco4;
    private JPanel screenDeco5;
    private JPanel screenDeco6;
    private JSeparator jSeparator1;
	
    public HowToPlayInfo() {
        setFont();
    	initComponents();
        setLocationRelativeTo(null);
    }
    
    private void setFont() {
    	try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/PixeloidSans-nR3g1.ttf")));
		} catch (IOException|FontFormatException e) {
		     e.printStackTrace();
		}
    }
                       
    private void initComponents() {

        howToPlayPanel = new JPanel();
        title = new JLabel();
        jSeparator1 = new JSeparator();
        infoText = new JLabel();
        screenDeco1 = new JPanel();
        screenDeco2 = new JPanel();
        screenDeco3 = new JPanel();
        screenDeco4 = new JPanel();
        screenDeco5 = new JPanel();
        screenDeco6 = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        howToPlayPanel.setBackground(new Color(51, 51, 51));
        howToPlayPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        howToPlayPanel.setForeground(new Color(0, 255, 0));

        title.setFont(new Font("Pixeloid Sans", 1, 24)); 
        title.setForeground(new Color(255, 102, 102));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("HOW TO PLAY");

        infoText.setFont(new Font("Pixeloid Sans", 1, 17)); 
        infoText.setForeground(new Color(255, 255, 255));
        infoText.setHorizontalAlignment(SwingConstants.CENTER);
        infoText.setText("<HTML><b><center>Welcome to Escape From Koç! In this game, you will try to escape from the school by escaping six different buildings, starting from the Student Center and finishing at the SNA Building. In each building, you will try to find the key hidden in one of the furnitures scattered throughout the building, and unlock the door to the building to escape. You will be able to collect power-ups by right-clicking on them, and you can check furnitures using left-click. The school also has aliens, so beware of them! You can find more information about the game objects and controls by hovering over the icons you see on this menu. Good luck!</center></b></HTML> ");

        screenDeco1.setBackground(new Color(255, 51, 51));

        GroupLayout screenDeco1Layout = new GroupLayout(screenDeco1);
        screenDeco1.setLayout(screenDeco1Layout);
        screenDeco1Layout.setHorizontalGroup(
            screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        screenDeco1Layout.setVerticalGroup(
            screenDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        screenDeco2.setBackground(new Color(255, 51, 51));

        GroupLayout screenDeco2Layout = new GroupLayout(screenDeco2);
        screenDeco2.setLayout(screenDeco2Layout);
        screenDeco2Layout.setHorizontalGroup(
            screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        screenDeco2Layout.setVerticalGroup(
            screenDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        screenDeco3.setBackground(new Color(255, 51, 51));

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

        screenDeco4.setBackground(new Color(255, 51, 51));

        GroupLayout screenDeco4Layout = new GroupLayout(screenDeco4);
        screenDeco4.setLayout(screenDeco4Layout);
        screenDeco4Layout.setHorizontalGroup(
            screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        screenDeco4Layout.setVerticalGroup(
            screenDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        screenDeco5.setBackground(new Color(255, 51, 51));

        GroupLayout screenDeco5Layout = new GroupLayout(screenDeco5);
        screenDeco5.setLayout(screenDeco5Layout);
        screenDeco5Layout.setHorizontalGroup(
            screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        screenDeco5Layout.setVerticalGroup(
            screenDeco5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        screenDeco6.setBackground(new Color(255, 51, 51));

        GroupLayout screenDeco6Layout = new GroupLayout(screenDeco6);
        screenDeco6.setLayout(screenDeco6Layout);
        screenDeco6Layout.setHorizontalGroup(
            screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        screenDeco6Layout.setVerticalGroup(
            screenDeco6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        GroupLayout howToPlayPanelLayout = new GroupLayout(howToPlayPanel);
        howToPlayPanel.setLayout(howToPlayPanelLayout);
        howToPlayPanelLayout.setHorizontalGroup(
            howToPlayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(howToPlayPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(howToPlayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, howToPlayPanelLayout.createSequentialGroup()
                        .addGroup(howToPlayPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(infoText, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(GroupLayout.Alignment.TRAILING, howToPlayPanelLayout.createSequentialGroup()
                        .addComponent(screenDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(screenDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(screenDeco4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(screenDeco2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(screenDeco5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(screenDeco6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        howToPlayPanelLayout.setVerticalGroup(
            howToPlayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(howToPlayPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(howToPlayPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(howToPlayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(screenDeco2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(screenDeco4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(screenDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(screenDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(screenDeco5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(screenDeco6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoText, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(howToPlayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(howToPlayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }  
  }