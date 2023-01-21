package helpScreen;

import main.controllers.GameController;
import menu.MenuPanel;
import pause.PausePanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import helpScreen.HelpScreenEventHandler;

public class HelpScreen extends JPanel {

	private JLabel gameInfoLabel;
    private JLabel hintText;
    private JLabel extraTimeText;
    private JLabel extraLifeText;
    private JLabel protectionVestText;
    private JLabel plasticBottleText;
    private JLabel shootingAlienText;
    private JLabel blindAlienText;
    private JLabel timeWastingAlienText;
    private JLabel characterIcon;
    private JLabel infoTextDisplayer;
    private JLabel detailsLabel;
    private JLabel backButton;
    private JLabel bagIcon;
    private JLabel keyIcon;
    private JLabel furnitureIcon;
    private JLabel wallIcon;
    private JLabel doorIcon;
    private JLabel hintIcon;
    private JLabel extraTimeIcon;
    private JLabel extraLifeIcon;
    private JLabel characterText;
    private JLabel protectionVestIcon;
    private JLabel plasticBottleIcon;
    private JLabel shootingAlienIcon;
    private JLabel blindAlienIcon;
    private JLabel timeWastingAlienIcon;
    private JLabel infoText;
    private JLabel bagText;
    private JLabel keyText;
    private JLabel furnitureText;
    private JLabel wallText;
    private JLabel doorText;
    private JPanel infoTextPanel;
    private JPanel infoTextPanelDeco1;
    private JPanel infoTextPanelDeco2;
    private JPanel infoTextPanelDeco3;
    private JPanel infoTextPanelDeco4;
    private JSeparator gameInfoSeparator;
    private JSeparator infoTextSeparatorLeft;
    private JSeparator infoTextSeparatorRight; 
    private HelpScreenEventHandler help;
    
    private JFrame frame;
    private GameController panel;
    private JLabel howToPlay;
    private HowToPlayInfo htpi;
     
    public HelpScreen(JFrame f, GameController p) {
    	this.frame = f;
    	this.panel = p;
    	createHelpScreen();      
    }
    
    public HelpScreen(JFrame f) {
    	this.frame = f;
    	createHelpScreen();
    }
      
    private void createHelpScreen() {
    	help = new HelpScreenEventHandler();
    	setFont();
    	setComponents();
    	setPanelProperties();
    	setLabels();
    	setIcons();
    	setPanelLayout();
    	setDecorations();
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
    private void setComponents() {
    	howToPlay = new JLabel();
    	gameInfoLabel = new JLabel();
        gameInfoSeparator = new JSeparator();
        detailsLabel = new JLabel();
        characterIcon = new JLabel();
        characterText = new JLabel();
        infoTextPanel = new JPanel();
        infoTextPanelDeco1 = new JPanel();
        infoTextPanelDeco2 = new JPanel();
        infoTextPanelDeco3 = new JPanel();
        infoTextPanelDeco4 = new JPanel();
        infoTextDisplayer = new JLabel();
        infoText = new JLabel();
        infoTextSeparatorLeft = new JSeparator();
        infoTextSeparatorRight = new JSeparator();
        bagText = new JLabel();
        bagIcon = new JLabel();
        keyText = new JLabel();
        keyIcon = new JLabel();
        furnitureText = new JLabel();
        furnitureIcon = new JLabel();
        wallText = new JLabel();
        wallIcon = new JLabel();
        doorIcon = new JLabel();
        doorText = new JLabel();
        hintIcon = new JLabel();
        hintText = new JLabel();
        extraTimeIcon = new JLabel();
        extraTimeText = new JLabel();
        extraLifeIcon = new JLabel();
        extraLifeText = new JLabel();
        protectionVestIcon = new JLabel();
        protectionVestText = new JLabel();
        plasticBottleIcon = new JLabel();
        plasticBottleText = new JLabel();
        shootingAlienIcon = new JLabel();
        shootingAlienText = new JLabel();
        blindAlienIcon = new JLabel();
        blindAlienText = new JLabel();
        timeWastingAlienIcon = new JLabel();
        timeWastingAlienText = new JLabel();
        backButton = new JLabel();
    }
    
    private void setPanelProperties() {
    	setBackground(new Color(51, 51, 51));
        setPreferredSize(new Dimension(1280, 720));
    }
    
    private void setLabels() {
    	gameInfoLabel.setBackground(new Color(153, 255, 255));
        gameInfoLabel.setFont(new Font("Pixeloid Sans", 1, 18)); 
        gameInfoLabel.setForeground(new Color(255, 255, 51));
        gameInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameInfoLabel.setText("GAME INFO");
           
        detailsLabel.setFont(new Font("Pixeloid Sans", 1, 12)); 
        detailsLabel.setForeground(new Color(255, 255, 255));
        detailsLabel.setText("Hover over an icon to know more about its controls/details.");
        
        characterText.setBackground(new Color(255, 255, 255));
        characterText.setForeground(new Color(255, 255, 255));
        characterText.setFont(new Font("Pixeloid Sans", 1, 12));
        characterText.setText("Character");
        
        infoTextDisplayer.setFont(new Font("Pixeloid Sans", 1, 14)); 
        infoTextDisplayer.setForeground(new Color(255, 255, 255));
        infoTextDisplayer.setHorizontalAlignment(SwingConstants.CENTER);
        infoTextDisplayer.setHorizontalTextPosition(SwingConstants.CENTER);
        
        infoText.setFont(new Font("Pixeloid Sans", 1, 18)); 
        infoText.setForeground(new Color(255, 255, 255));
        infoText.setText("INFO");

        bagText.setBackground(new Color(255, 255, 255));
        bagText.setForeground(new Color(255, 255, 255));
        bagText.setFont(new Font("Pixeloid Sans", 1, 12));
        bagText.setText("Bag");
        
        keyText.setBackground(new Color(255, 255, 255));
        keyText.setForeground(new Color(255, 255, 255));
        keyText.setFont(new Font("Pixeloid Sans", 1, 12));
        keyText.setText("Key");
        
        furnitureText.setBackground(new Color(255, 255, 255));
        furnitureText.setForeground(new Color(255, 255, 255));
        furnitureText.setFont(new Font("Pixeloid Sans", 1, 12));
        furnitureText.setText("Furniture");

        wallText.setBackground(new Color(255, 255, 255));
        wallText.setForeground(new Color(255, 255, 255));
        wallText.setFont(new Font("Pixeloid Sans", 1, 12));
        wallText.setText("Wall");
        
        doorText.setBackground(new Color(255, 255, 255));
        doorText.setForeground(new Color(255, 255, 255));
        doorText.setFont(new Font("Pixeloid Sans", 1, 12));
        doorText.setText("Door");

        hintText.setBackground(new Color(255, 255, 255));
        hintText.setForeground(new Color(255, 255, 255));
        hintText.setFont(new Font("Pixeloid Sans", 1, 12));
        hintText.setText("Hint");
        
        extraTimeText.setBackground(new Color(255, 255, 255));
        extraTimeText.setForeground(new Color(255, 255, 255));
        extraTimeText.setFont(new Font("Pixeloid Sans", 1, 12));
        extraTimeText.setText("Extra Time");
        
        extraLifeText.setBackground(new Color(255, 255, 255));
        extraLifeText.setForeground(new Color(255, 255, 255));
        extraLifeText.setFont(new Font("Pixeloid Sans", 1, 12));
        extraLifeText.setText("Extra Life");
        
        protectionVestText.setBackground(new Color(255, 255, 255));
        protectionVestText.setForeground(new Color(255, 255, 255));
        protectionVestText.setFont(new Font("Pixeloid Sans", 1, 12));
        protectionVestText.setText("Protection Vest");
        
        plasticBottleText.setBackground(new Color(255, 255, 255));
        plasticBottleText.setForeground(new Color(255, 255, 255));
        plasticBottleText.setFont(new Font("Pixeloid Sans", 1, 12));
        plasticBottleText.setText("Plastic Bottle");
        
        shootingAlienText.setBackground(new Color(255, 255, 255));
        shootingAlienText.setForeground(new Color(255, 255, 255));
        shootingAlienText.setFont(new Font("Pixeloid Sans", 1, 12));
        shootingAlienText.setText("Shooting Alien");
        
        blindAlienText.setBackground(new Color(255, 255, 255));
        blindAlienText.setForeground(new Color(255, 255, 255));
        blindAlienText.setFont(new Font("Pixeloid Sans", 1, 12));
        blindAlienText.setText("Blind Alien");
        
        timeWastingAlienText.setBackground(new Color(255, 255, 255));
        timeWastingAlienText.setForeground(new Color(255, 255, 255));
        timeWastingAlienText.setFont(new Font("Pixeloid Sans", 1, 12));
        timeWastingAlienText.setText("Time-wasting Alien");
    }
    
    private void setDecorations() {
    	infoTextPanel.setBackground(new Color(51, 51, 51));
        infoTextPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        infoTextPanel.setForeground(new Color(51, 51, 51));
    	infoTextPanelDeco1.setBackground(new Color(153, 153, 255));

        GroupLayout infoTextPanelDeco1Layout = new GroupLayout(infoTextPanelDeco1);
        infoTextPanelDeco1.setLayout(infoTextPanelDeco1Layout);
        infoTextPanelDeco1Layout.setHorizontalGroup(
            infoTextPanelDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        infoTextPanelDeco1Layout.setVerticalGroup(
            infoTextPanelDeco1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        infoTextPanelDeco2.setBackground(new Color(153, 255, 153));

        GroupLayout infoTextPanelDeco2Layout = new GroupLayout(infoTextPanelDeco2);
        infoTextPanelDeco2.setLayout(infoTextPanelDeco2Layout);
        infoTextPanelDeco2Layout.setHorizontalGroup(
            infoTextPanelDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        infoTextPanelDeco2Layout.setVerticalGroup(
            infoTextPanelDeco2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        infoTextPanelDeco3.setBackground(new Color(255, 102, 102));

        GroupLayout infoTextPanelDeco3Layout = new GroupLayout(infoTextPanelDeco3);
        infoTextPanelDeco3.setLayout(infoTextPanelDeco3Layout);
        infoTextPanelDeco3Layout.setHorizontalGroup(
            infoTextPanelDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        infoTextPanelDeco3Layout.setVerticalGroup(
            infoTextPanelDeco3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        infoTextPanelDeco4.setBackground(new Color(255, 255, 153));

        GroupLayout infoTextPanelDeco4Layout = new GroupLayout(infoTextPanelDeco4);
        infoTextPanelDeco4.setLayout(infoTextPanelDeco4Layout);
        infoTextPanelDeco4Layout.setHorizontalGroup(
            infoTextPanelDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        infoTextPanelDeco4Layout.setVerticalGroup(
            infoTextPanelDeco4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        
        GroupLayout infoTextPanelLayout = new GroupLayout(infoTextPanel);
        infoTextPanel.setLayout(infoTextPanelLayout);
        infoTextPanelLayout.setHorizontalGroup(
            infoTextPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(infoTextPanelLayout.createSequentialGroup()
                .addComponent(infoTextPanelDeco2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoTextPanelDeco4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(infoTextPanelLayout.createSequentialGroup()
                .addComponent(infoTextPanelDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoTextPanelDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(infoTextPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(infoTextDisplayer, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        infoTextPanelLayout.setVerticalGroup(
            infoTextPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(infoTextPanelLayout.createSequentialGroup()
                .addGroup(infoTextPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(infoTextPanelDeco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoTextPanelDeco3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(infoTextDisplayer, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(infoTextPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(infoTextPanelDeco2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoTextPanelDeco4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );
    }
    private void setIcons() {
    	characterIcon.setForeground(new Color(255, 255, 255));
        characterIcon.setHorizontalAlignment(SwingConstants.CENTER);
        characterIcon.setMaximumSize(new Dimension(25, 25));
        characterIcon.setMinimumSize(new Dimension(25, 25));
        characterIcon.setPreferredSize(new Dimension(25, 25));
        characterIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                characterIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                characterIconMouseExited(evt);
            }
        });
        
        howToPlay.setForeground(new Color(255, 255, 255));
        howToPlay.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent evt) {
        		howToPlayMouseEntered(evt);
        	}
        	public void mouseExited(MouseEvent evt) {
        		howToPlayMouseExited(evt);
        	}
        });
        
        bagIcon.setForeground(new Color(255, 255, 255));
        bagIcon.setHorizontalAlignment(SwingConstants.CENTER);
        bagIcon.setMaximumSize(new Dimension(25, 25));
        bagIcon.setMinimumSize(new Dimension(25, 25));
        bagIcon.setPreferredSize(new Dimension(25, 25));
        bagIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                bagIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                bagIconMouseExited(evt);
            }
        });
        
        keyIcon.setForeground(new Color(255, 255, 255));
        keyIcon.setHorizontalAlignment(SwingConstants.CENTER);
        keyIcon.setMaximumSize(new Dimension(25, 25));
        keyIcon.setMinimumSize(new Dimension(25, 25));
        keyIcon.setPreferredSize(new Dimension(25, 25));
        keyIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                keyIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                keyIconMouseExited(evt);
            }
        });
        
        furnitureIcon.setForeground(new Color(255, 255, 255));
        furnitureIcon.setHorizontalAlignment(SwingConstants.CENTER);
        furnitureIcon.setMaximumSize(new Dimension(25, 25));
        furnitureIcon.setMinimumSize(new Dimension(25, 25));
        furnitureIcon.setPreferredSize(new Dimension(25, 25));
        furnitureIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                furnitureIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                furnitureIconMouseExited(evt);
            }
        });
        
        wallIcon.setForeground(new Color(255, 255, 255));
        wallIcon.setHorizontalAlignment(SwingConstants.CENTER);
        wallIcon.setMaximumSize(new Dimension(25, 25));
        wallIcon.setMinimumSize(new Dimension(25, 25));
        wallIcon.setPreferredSize(new Dimension(25, 25));
        wallIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                wallIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                wallIconMouseExited(evt);
            }
        });

        doorIcon.setForeground(new Color(255, 255, 255));
        doorIcon.setHorizontalAlignment(SwingConstants.CENTER);
        doorIcon.setMaximumSize(new Dimension(25, 25));
        doorIcon.setMinimumSize(new Dimension(25, 25));
        doorIcon.setPreferredSize(new Dimension(25, 25));
        doorIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                doorIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                doorIconMouseExited(evt);
            }
        });
        
        hintIcon.setForeground(new Color(255, 255, 255));
        hintIcon.setHorizontalAlignment(SwingConstants.CENTER);
        hintIcon.setMaximumSize(new Dimension(25, 25));
        hintIcon.setMinimumSize(new Dimension(25, 25));
        hintIcon.setPreferredSize(new Dimension(25, 25));
        hintIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                hintIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                hintIconMouseExited(evt);
            }
        });
        
        extraTimeIcon.setForeground(new Color(255, 255, 255));
        extraTimeIcon.setHorizontalAlignment(SwingConstants.CENTER);
        extraTimeIcon.setMaximumSize(new Dimension(25, 25));
        extraTimeIcon.setMinimumSize(new Dimension(25, 25));
        extraTimeIcon.setPreferredSize(new Dimension(25, 25));
        extraTimeIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                extraTimeIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                extraTimeIconMouseExited(evt);
            }
        });
        
        extraLifeIcon.setForeground(new Color(255, 255, 255));
        extraLifeIcon.setHorizontalAlignment(SwingConstants.CENTER);    
        extraLifeIcon.setMaximumSize(new Dimension(25, 25));
        extraLifeIcon.setMinimumSize(new Dimension(25, 25));
        extraLifeIcon.setPreferredSize(new Dimension(25, 25));
        extraLifeIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                extraLifeIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                extraLifeIconMouseExited(evt);
            }
        });
        
        protectionVestIcon.setForeground(new Color(255, 255, 255));
        protectionVestIcon.setHorizontalAlignment(SwingConstants.CENTER);
        protectionVestIcon.setMaximumSize(new Dimension(25, 25));
        protectionVestIcon.setMinimumSize(new Dimension(25, 25));
        protectionVestIcon.setPreferredSize(new Dimension(25, 25));
        protectionVestIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                protectionVestIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                protectionVestIconMouseExited(evt);
            }
        });
        
        plasticBottleIcon.setForeground(new Color(255, 255, 255));
        plasticBottleIcon.setHorizontalAlignment(SwingConstants.CENTER);
        plasticBottleIcon.setMaximumSize(new Dimension(25, 25));
        plasticBottleIcon.setMinimumSize(new Dimension(25, 25));
        plasticBottleIcon.setPreferredSize(new Dimension(25, 25));
        plasticBottleIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                plasticBottleIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                plasticBottleIconMouseExited(evt);
            }
        });
        
        shootingAlienIcon.setForeground(new Color(255, 255, 255));
        shootingAlienIcon.setHorizontalAlignment(SwingConstants.CENTER);
        shootingAlienIcon.setMaximumSize(new Dimension(25, 25));
        shootingAlienIcon.setMinimumSize(new Dimension(25, 25));
        shootingAlienIcon.setPreferredSize(new Dimension(25, 25));
        shootingAlienIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                shootingAlienIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                shootingAlienIconMouseExited(evt);
            }
        });
        
        blindAlienIcon.setForeground(new Color(255, 255, 255));
        blindAlienIcon.setHorizontalAlignment(SwingConstants.CENTER);
        blindAlienIcon.setMaximumSize(new Dimension(25, 25));
        blindAlienIcon.setMinimumSize(new Dimension(25, 25));
        blindAlienIcon.setPreferredSize(new Dimension(25, 25));
        blindAlienIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                blindAlienIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                blindAlienIconMouseExited(evt);
            }
        });
        
        timeWastingAlienIcon.setForeground(new Color(255, 255, 255));
        timeWastingAlienIcon.setHorizontalAlignment(SwingConstants.CENTER);
        timeWastingAlienIcon.setMaximumSize(new Dimension(25, 25));
        timeWastingAlienIcon.setMinimumSize(new Dimension(25, 25));
        timeWastingAlienIcon.setPreferredSize(new Dimension(25, 25));
        timeWastingAlienIcon.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                timeWastingAlienIconMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                timeWastingAlienIconMouseExited(evt);
            }
        });
        
        backButton.setBackground(new Color(255, 255, 255));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseClicked(MouseEvent evt) {
            	backButtonMouseClicked(evt);
            }
        });
        
        try {
        	characterIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/character_move/boy_down_1.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			bagIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/bagFrame.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			keyIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/key.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			furnitureIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/furnitures/bed.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			wallIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/wall3.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			doorIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/open_door.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			hintIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/hint.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			extraTimeIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/extra-time.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			extraLifeIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/extra-life.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			protectionVestIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/protection-vest.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			plasticBottleIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/plastic-bottle.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			shootingAlienIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/alien2.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			blindAlienIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/alien4.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			timeWastingAlienIcon.setIcon(new ImageIcon(ImageIO.read(new File("assets/alien1.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
			backButton.setIcon(new ImageIcon(ImageIO.read(new File("assets/help-exit.png")).getScaledInstance(40,  40, Image.SCALE_DEFAULT)));
			howToPlay.setIcon(new ImageIcon(ImageIO.read(new File("assets/help.png")).getScaledInstance(40,  40, Image.SCALE_DEFAULT)));
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    private void setPanelLayout() {
    	GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(blindAlienText, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeWastingAlienText)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(characterIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(hintIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(blindAlienIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                            .addComponent(characterText)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(hintText)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(bagIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(extraTimeIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(bagText))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            	.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            	.addComponent(extraTimeText)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(keyIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(extraLifeIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(keyText))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(extraLifeText)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(furnitureIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(protectionVestIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(furnitureText)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(protectionVestText)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(wallIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(plasticBottleIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(wallText))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(plasticBottleText)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(doorIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(shootingAlienIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timeWastingAlienIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(doorText, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
                                .addGap(116, 116, 116))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(shootingAlienText)
                                .addGap(99, 99, 99))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(infoTextPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(infoTextSeparatorLeft, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoText)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoTextSeparatorRight))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(gameInfoLabel, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(gameInfoSeparator, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(detailsLabel, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bagIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bagText))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(characterIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(characterText))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(gameInfoLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gameInfoSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(backButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, 0)
                                .addComponent(detailsLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(keyIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(keyText))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(furnitureIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(furnitureText))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(wallIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(wallText))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(doorIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(doorText)))))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hintIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hintText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(extraTimeIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(extraTimeText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(extraLifeIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(extraLifeText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(protectionVestIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(protectionVestText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(plasticBottleIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(plasticBottleText))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(shootingAlienIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(shootingAlienText)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(blindAlienIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(blindAlienText)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(infoText, GroupLayout.Alignment.TRAILING)
                            .addComponent(infoTextSeparatorLeft, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoTextSeparatorRight, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeWastingAlienIcon, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeWastingAlienText)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoTextPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        
        howToPlay.setBounds(1220, 25, 40, 40);
        add(howToPlay);
    }
     
    private void howToPlayMouseEntered(MouseEvent evt) {
		howToPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
		htpi = new HowToPlayInfo();
		htpi.setVisible(true);

    }
    private void howToPlayMouseExited(MouseEvent evt) {
    	htpi.dispose();
    }
    
    
    protected void backButtonMouseClicked(MouseEvent evt) {
    	help.backButtonPressed(frame, panel, this);
	}
    
	protected void backButtonMouseEntered(MouseEvent evt) {
		help.backButtonEntered(backButton);
	}

	private void characterIconMouseEntered(MouseEvent evt) {                                      
		help.characterIconEntered(infoTextDisplayer);
	}                                     

    private void characterIconMouseExited(MouseEvent evt) {                                     
    	help.characterIconExited(infoTextDisplayer);
    }                                    

    private void keyIconMouseEntered(MouseEvent evt) {                                      
    	help.keyIconEntered(infoTextDisplayer);
    }                                     

    private void keyIconMouseExited(MouseEvent evt) {                                     
        help.keyIconExited(infoTextDisplayer);
    }                                    

    private void bagIconMouseEntered(MouseEvent evt) {                                      
    	help.bagIconEntered(infoTextDisplayer);
    }                                     

    private void bagIconMouseExited(MouseEvent evt) {                                     
    	help.bagIconExited(infoTextDisplayer);
    }                                    

    private void furnitureIconMouseEntered(MouseEvent evt) {                                      
    	help.furnitureIconEntered(infoTextDisplayer);
    }                                     

    private void furnitureIconMouseExited(MouseEvent evt) {                                     
    	help.furnitureIconExited(infoTextDisplayer);
    }                                    

    private void wallIconMouseEntered(MouseEvent evt) {                                      
    	help.wallIconEntered(infoTextDisplayer);
    }                                     

    private void wallIconMouseExited(MouseEvent evt) {                                     
    	help.wallIconExited(infoTextDisplayer);
    }                                    

    private void doorIconMouseExited(MouseEvent evt) {                                     
    	help.doorIconExited(infoTextDisplayer);
    }                                   

    private void doorIconMouseEntered(MouseEvent evt) {                                      
    	help.doorIconEntered(infoTextDisplayer);
    }                                     

    private void hintIconMouseEntered(MouseEvent evt) {                                      
    	help.hintIconEntered(infoTextDisplayer);
    }                                     

    private void hintIconMouseExited(MouseEvent evt) {                                     
    	help.hintIconExited(infoTextDisplayer);
    }                                    

    private void extraTimeIconMouseEntered(MouseEvent evt) {                                      
    	help.extraTimeIconEntered(infoTextDisplayer);
    }                                     

    private void extraTimeIconMouseExited(MouseEvent evt) {                                     
    	help.extraTimeIconExited(infoTextDisplayer);
    }                                    

    private void extraLifeIconMouseEntered(MouseEvent evt) {                                      
    	help.extraLifeIconEntered(infoTextDisplayer);
    }                                     

    private void extraLifeIconMouseExited(MouseEvent evt) {                                     
    	help.extraLifeIconExited(infoTextDisplayer);
    }                                    

    private void protectionVestIconMouseEntered(MouseEvent evt) {                                      
    	help.protectionVestIconEntered(infoTextDisplayer);
    }                                     

    private void protectionVestIconMouseExited(MouseEvent evt) {                                     
    	help.protectionVestIconExited(infoTextDisplayer);
    }                                    

    private void plasticBottleIconMouseEntered(MouseEvent evt) {                                      
    	help.plasticBottleIconEntered(infoTextDisplayer);
    }                                     

    private void plasticBottleIconMouseExited(MouseEvent evt) {                                     
    	help.plasticBottleIconExited(infoTextDisplayer);
    }                                    

    private void shootingAlienIconMouseEntered(MouseEvent evt) {                                      
    	help.shootingAlienIconEntered(infoTextDisplayer);
    }                                     

    private void shootingAlienIconMouseExited(MouseEvent evt) {                                     
    	help.shootingAlienIconExited(infoTextDisplayer);
    }                                    

    private void blindAlienIconMouseEntered(MouseEvent evt) {                                      
    	help.blindAlienIconEntered(infoTextDisplayer);
    }                                     

    private void blindAlienIconMouseExited(MouseEvent evt) {                                     
        help.blindAlienIconExited(infoTextDisplayer);
    }                                    

    private void timeWastingAlienIconMouseEntered(MouseEvent evt) {                                      
    	help.timeWastingAlienIconEntered(infoTextDisplayer);
    }                                     

    private void timeWastingAlienIconMouseExited(MouseEvent evt) {                                     
    	help.timeWastingAlienIconExited(infoTextDisplayer);
    }                  

}
