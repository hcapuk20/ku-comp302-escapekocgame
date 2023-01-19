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

public class HelpScreen extends JPanel {

	private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3; 
    
    JFrame frame;
    GameController panel;
     
    public HelpScreen(JFrame f, GameController p) {
    	this.frame = f;
    	this.panel = p;
    	setFont();
    	initComponents();       
    }
    
    public HelpScreen(JFrame f) {
    	this.frame = f;
    	setFont();
    	initComponents();
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

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        jLabel18 = new JLabel();
        jLabel3 = new JLabel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jLabel19 = new JLabel();
        jLabel4 = new JLabel();
        jSeparator2 = new JSeparator();
        jSeparator3 = new JSeparator();
        jLabel5 = new JLabel();
        jLabel22 = new JLabel();
        jLabel6 = new JLabel();
        jLabel23 = new JLabel();
        jLabel7 = new JLabel();
        jLabel24 = new JLabel();
        jLabel8 = new JLabel();
        jLabel25 = new JLabel();
        jLabel26 = new JLabel();
        jLabel9 = new JLabel();
        jLabel27 = new JLabel();
        jLabel10 = new JLabel();
        jLabel28 = new JLabel();
        jLabel11 = new JLabel();
        jLabel29 = new JLabel();
        jLabel12 = new JLabel();
        jLabel30 = new JLabel();
        jLabel13 = new JLabel();
        jLabel31 = new JLabel();
        jLabel14 = new JLabel();
        jLabel32 = new JLabel();
        jLabel15 = new JLabel();
        jLabel33 = new JLabel();
        jLabel16 = new JLabel();
        jLabel34 = new JLabel();
        jLabel17 = new JLabel();
        jLabel20 = new JLabel();

        setBackground(new Color(51, 51, 51));
        setPreferredSize(new Dimension(1280, 720));

        jLabel1.setBackground(new Color(153, 255, 255));
        jLabel1.setFont(new Font("Pixeloid Sans", 1, 18)); 
        jLabel1.setForeground(new Color(255, 255, 51));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("GAME INFO");

        jLabel2.setFont(new Font("Pixeloid Sans", 1, 12)); 
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Hover over an icon to know more about its controls/details.");

        jLabel18.setForeground(new Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel18.setIcon(new ImageIcon("assets/powerUps/boy_down_1.png"));

        BufferedImage charImage;
		try {
			charImage = ImageIO.read(new File("assets/character_move/boy_down_1.png"));
			Image newImage = charImage.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon im = new ImageIcon(newImage);
			jLabel18.setIcon(im);
		} catch (IOException e) {
			e.printStackTrace();
		}
         
        jLabel18.setMaximumSize(new Dimension(25, 25));
        jLabel18.setMinimumSize(new Dimension(25, 25));
        jLabel18.setPreferredSize(new Dimension(25, 25));
        jLabel18.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });

        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setFont(new Font("Pixeloid Sans", 1, 12));
        jLabel3.setText("Character");

        jPanel1.setBackground(new Color(51, 51, 51));
        jPanel1.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
        jPanel1.setForeground(new Color(51, 51, 51));

        jPanel2.setBackground(new Color(153, 153, 255));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new Color(153, 255, 153));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new Color(255, 102, 102));

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new Color(255, 255, 153));

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jLabel19.setFont(new Font("Pixeloid Sans", 1, 14)); 
        jLabel19.setForeground(new Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel19.setHorizontalTextPosition(SwingConstants.CENTER);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );

        jLabel4.setFont(new Font("Pixeloid Sans", 1, 18)); 
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("INFO");

        jLabel5.setBackground(new Color(255, 255, 255));
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel5.setText("Bag");

        jLabel22.setForeground(new Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel22.setIcon(new ImageIcon(ImageIO.read(new File("assets/bagFrame.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        jLabel22.setMaximumSize(new Dimension(25, 25));
        jLabel22.setMinimumSize(new Dimension(25, 25));
        jLabel22.setPreferredSize(new Dimension(25, 25));
        jLabel22.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });

        jLabel6.setBackground(new Color(255, 255, 255));
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel6.setText("Key");

        jLabel23.setForeground(new Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel23.setIcon(new ImageIcon(ImageIO.read(new File("assets/key.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        jLabel23.setMaximumSize(new Dimension(25, 25));
        jLabel23.setMinimumSize(new Dimension(25, 25));
        jLabel23.setPreferredSize(new Dimension(25, 25));
        jLabel23.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });

        jLabel7.setBackground(new Color(255, 255, 255));
        jLabel7.setForeground(new Color(255, 255, 255));
        jLabel7.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel7.setText("Furniture");

        jLabel24.setForeground(new Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(SwingConstants.CENTER);
    	try {
			jLabel24.setIcon(new ImageIcon(ImageIO.read(new File("assets/furnitures/bed.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
        jLabel24.setMaximumSize(new Dimension(25, 25));
        jLabel24.setMinimumSize(new Dimension(25, 25));
        jLabel24.setPreferredSize(new Dimension(25, 25));
        jLabel24.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });

        jLabel8.setBackground(new Color(255, 255, 255));
        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel8.setText("Wall");

        jLabel25.setForeground(new Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel25.setIcon(new ImageIcon(ImageIO.read(new File("assets/wall3.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        jLabel25.setMaximumSize(new Dimension(25, 25));
        jLabel25.setMinimumSize(new Dimension(25, 25));
        jLabel25.setPreferredSize(new Dimension(25, 25));
        jLabel25.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
        });

        jLabel26.setForeground(new Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel26.setIcon(new ImageIcon(ImageIO.read(new File("assets/open_door.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        jLabel26.setMaximumSize(new Dimension(25, 25));
        jLabel26.setMinimumSize(new Dimension(25, 25));
        jLabel26.setPreferredSize(new Dimension(25, 25));
        jLabel26.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });

        jLabel9.setBackground(new Color(255, 255, 255));
        jLabel9.setForeground(new Color(255, 255, 255));
        jLabel9.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel9.setText("Door");

        jLabel27.setForeground(new Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel27.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/hint.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        jLabel27.setMaximumSize(new Dimension(25, 25));
        jLabel27.setMinimumSize(new Dimension(25, 25));
        jLabel27.setPreferredSize(new Dimension(25, 25));
        jLabel27.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });

        jLabel10.setBackground(new Color(255, 255, 255));
        jLabel10.setForeground(new Color(255, 255, 255));
        jLabel10.setFont(new Font("Pixeloid Sans", 1, 12));
        jLabel10.setText("Hint");

        jLabel28.setForeground(new Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel28.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/extra-time.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        jLabel28.setMaximumSize(new Dimension(25, 25));
        jLabel28.setMinimumSize(new Dimension(25, 25));
        jLabel28.setPreferredSize(new Dimension(25, 25));
        jLabel28.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        jLabel11.setBackground(new Color(255, 255, 255));
        jLabel11.setForeground(new Color(255, 255, 255));
        jLabel11.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel11.setText("Extra Time");

        jLabel29.setForeground(new Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel29.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/extra-life.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        jLabel29.setMaximumSize(new Dimension(25, 25));
        jLabel29.setMinimumSize(new Dimension(25, 25));
        jLabel29.setPreferredSize(new Dimension(25, 25));
        jLabel29.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });

        jLabel12.setBackground(new Color(255, 255, 255));
        jLabel12.setForeground(new Color(255, 255, 255));
        jLabel12.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel12.setText("Extra Life");

        jLabel30.setForeground(new Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel30.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/protection-vest.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        jLabel30.setMaximumSize(new Dimension(25, 25));
        jLabel30.setMinimumSize(new Dimension(25, 25));
        jLabel30.setPreferredSize(new Dimension(25, 25));
        jLabel30.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
        });

        jLabel13.setBackground(new Color(255, 255, 255));
        jLabel13.setForeground(new Color(255, 255, 255));
        jLabel13.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel13.setText("Protection Vest");

        jLabel31.setForeground(new Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel31.setIcon(new ImageIcon(ImageIO.read(new File("assets/powerUps/plastic-bottle.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        jLabel31.setMaximumSize(new Dimension(25, 25));
        jLabel31.setMinimumSize(new Dimension(25, 25));
        jLabel31.setPreferredSize(new Dimension(25, 25));
        jLabel31.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel31MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel31MouseExited(evt);
            }
        });

        jLabel14.setBackground(new Color(255, 255, 255));
        jLabel14.setForeground(new Color(255, 255, 255));
        jLabel14.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel14.setText("Plastic Bottle");

        jLabel32.setForeground(new Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel32.setIcon(new ImageIcon(ImageIO.read(new File("assets/alien2.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        jLabel32.setMaximumSize(new Dimension(25, 25));
        jLabel32.setMinimumSize(new Dimension(25, 25));
        jLabel32.setPreferredSize(new Dimension(25, 25));
        jLabel32.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel32MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel32MouseExited(evt);
            }
        });

        jLabel15.setBackground(new Color(255, 255, 255));
        jLabel15.setForeground(new Color(255, 255, 255));
        jLabel15.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel15.setText("Shooting Alien");

        jLabel33.setForeground(new Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel33.setIcon(new ImageIcon(ImageIO.read(new File("assets/alien4.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        jLabel33.setMaximumSize(new Dimension(25, 25));
        jLabel33.setMinimumSize(new Dimension(25, 25));
        jLabel33.setPreferredSize(new Dimension(25, 25));
        jLabel33.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel33MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel33MouseExited(evt);
            }
        });

        jLabel16.setBackground(new Color(255, 255, 255));
        jLabel16.setForeground(new Color(255, 255, 255));
        jLabel16.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel16.setText("Blind Alien");

        jLabel34.setForeground(new Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel34.setIcon(new ImageIcon(ImageIO.read(new File("assets/alien1.png")).getScaledInstance(50,  50, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        jLabel34.setMaximumSize(new Dimension(25, 25));
        jLabel34.setMinimumSize(new Dimension(25, 25));
        jLabel34.setPreferredSize(new Dimension(25, 25));
        jLabel34.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel34MouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                jLabel34MouseExited(evt);
            }
        });

        jLabel17.setBackground(new Color(255, 255, 255));
        jLabel17.setForeground(new Color(255, 255, 255));
        jLabel17.setFont(new Font("Pixeloid Sans", 1, 12));

        jLabel17.setText("Time-wasting Alien");

        jLabel20.setBackground(new Color(255, 255, 255));
        jLabel20.setForeground(new Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(SwingConstants.CENTER);
        try {
			jLabel20.setIcon(new ImageIcon(ImageIO.read(new File("assets/help-exit.png")).getScaledInstance(40,  40, Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        jLabel20.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseClicked(MouseEvent evt) {
            	jLabel20MouseClicked(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel10)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel5))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            	.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            	.addComponent(jLabel11)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jLabel6))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jLabel13)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel14)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
                                .addGap(116, 116, 116))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(99, 99, 99))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))))))
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
                                        .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, 0)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)))))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel27, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel28, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel29, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel30, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel31, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel32, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel34, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
    }                      
    protected void jLabel20MouseClicked(MouseEvent evt) {
    	if (PausePanel.getHelpPressed()) {
    		PausePanel pausePanel = new PausePanel(frame, panel);
    		frame.add(pausePanel);
    		PausePanel.setHelpPressed();
    	} else {
    		MenuPanel menuPanel = new MenuPanel(frame);
    		frame.add(menuPanel);
    	}    	
    	frame.pack();
    	frame.setVisible(true);
    	frame.remove(this);
	}
    
	protected void jLabel20MouseEntered(MouseEvent evt) {
		jLabel20.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jLabel20.setToolTipText("Click here to go back to the game or main menu.");
		
	}

	private void jLabel18MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is your character! You control them by pressing the arrow keys on the keyboard, and they move around. Their only hope lies within your skills, so try your best to escape!</center></b></HTML>");
    }                                     

    private void jLabel18MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel23MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is a key, which you can find one of in each building to escape the bulidings of the school, and then the school itself! It can be tricky to find, since one of the aliens likes to mess with it.</center></b></HTML>");
    }                                     

    private void jLabel23MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel22MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is your bag! This is one of the three slots you have as inventory, in which you can store the collectible power-ups. You can also stack them, where the counts will be displayed next to the slots. Use your power-ups wisely!</center></b></HTML>");
    }                                     

    private void jLabel22MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel24MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>These are the furnitures scattered throughout the buildings, and they contain the keys you need to find to escape! One of these furnitures in your current building will have the key, so good luck finding it!</center></b></HTML>");
    }                                     

    private void jLabel24MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel25MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>These are the walls that form the school buildings. Don't try to go through them to escape, as they won't be allowing that!</center></b></HTML>");
    }                                     

    private void jLabel25MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel26MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel26MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is part of the doors that you need to escape from after finding the key. You can't speak to the door to convince it to let you through, so make sure to find the key and get close enough to unlock it!</center></b></HTML>");
    }                                     

    private void jLabel27MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is the hint power-up. It will tell you if the key is located in the current room you're in. If the key is found, then the furniture containing the key will be clearly highlighted, so mind your surroundings!</center></b></HTML>");
    }                                     

    private void jLabel27MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel28MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is the extra time power-up. It will add 5 more seconds to your remaining time. You will need these, as the time can run out quickly if you are unlucky. Be sure to collect them!</center></b></HTML>");
    }                                     

    private void jLabel28MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel29MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is the extra life power-up. You will get one more life if you collect it. Try to get them whenever you see them, because the aliens surrounding you won't be forgiving!</center></b></HTML>");
    }                                     

    private void jLabel29MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel30MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is the protection vest power-up. You will get a shield of defense for the shooter alien, so you won't take damage if you get near one. It doesn't last forever, though, so be wary of your surroundings while you bask in the glory of your armor.</center></b></HTML>");
    }                                     

    private void jLabel30MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel31MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is the plastic bottle power-up. You can use it to distract a blind alien by pressing \"P\" on your keyboard, and then throw it based on this key configuration: (\"A\": west, \"D\": east, \"W\": north, \"X\": south). Make sure to watch out where you throw it!</center></b></HTML>");
    }                                     

    private void jLabel31MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel32MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is a shooting alien. It will shoot bullets within a certain range, so try not to get too close to it as you will lose a life in doing so. Be careful!");
    }                                     

    private void jLabel32MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel33MouseEntered(MouseEvent evt) {                                      
        jLabel19.setText("<HTML><b><center>This is a blind alien. It will randomly roam around in the room that it spawns, and it will kill you instantly if you come in contact with it. So mind where you are going; even a glorious armor won't be saving you!</center></b></HTML>");
    }                                     

    private void jLabel33MouseExited(MouseEvent evt) {                                     
        jLabel19.setText("");
    }                                    

    private void jLabel34MouseEntered(MouseEvent evt) {                                      
        jLabel19.setFont(new Font("Pixeloid Sans", 1, 11));
    	jLabel19.setText("<HTML><b><center>This is a time-wasting alien. It will try changing the location of the key based on your remaining time. If you have more than 70% of your time remaining, then it is every 5 seconds. If it is between the 30%-70% range, then this guy becomes confused and disappears without doing anything. Things get fierce if it is less than 30%, as it will change the key location every 3 seconds. So try not to lose too much time!</center></b></HTML>");
    }                                     

    private void jLabel34MouseExited(MouseEvent evt) {                                     
    	jLabel19.setFont(new Font("Pixeloid Sans", 1, 14));
    	jLabel19.setText("");
    }                  

}
