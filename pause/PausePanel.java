package pause;

import constants.Constants;
import main.controllers.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PausePanel extends JPanel implements ActionListener {

    protected static JButton resumeButton;
    protected static JButton helpButton;
    protected static JButton exitButton;

    protected static JLabel titleLabel;

    protected static int panelWidth = Constants.WINDOW_WIDTH;
    protected static int panelHeight = Constants.WINDOW_HEIGHT;

    protected static int distanceBetweenButtons = 20;
    protected static int buttonHeight = 60;
    protected static int buttonWidth = 200;

    //protected static Image backgroundImage = new ImageIcon("assets/menuBackground.jpeg").getImage();

    JFrame frame;

    GameController panel;

    public PausePanel(JFrame f, GameController panel) {
        this.addMouseListener(null);

        this.setPreferredSize(new Dimension(panelWidth, panelHeight));

        this.frame = f;
        this.panel = panel;

        setLayout(null);

        setButtons();
        setLabels();

    }

    @Override
    protected void paintComponent(Graphics g) {
        //g.drawImage(backgroundImage, 0, 0, panelWidth, panelHeight, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    protected void setLabels() {
        titleLabel = new JLabel("Escape From Koç");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        titleLabel.setBounds((panelWidth - 2 * buttonWidth) / 2,
                (panelHeight - buttonHeight) / 2 - 2 * buttonHeight - 15, 2 * buttonWidth, buttonHeight);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);

        add(titleLabel);
    }

    protected void setButtons() {
        resumeButton = new JButton("RESUME");
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resumeButtonAction();
            }
        });
        resumeButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 - buttonHeight,
                buttonWidth, buttonHeight);

        helpButton = new JButton("HELP");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        helpButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2, buttonWidth,
                buttonHeight);

        exitButton = new JButton("EXIT");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        exitButton.setBounds((panelWidth - buttonWidth) / 2, (panelHeight - buttonHeight) / 2 + buttonHeight,
                buttonWidth, buttonHeight);

        this.add(resumeButton);
        this.add(helpButton);
        this.add(exitButton);
    }

    protected void resumeButtonAction() {
        panel.paused = false;
        frame.add(panel);
        panel.setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        frame.remove(this);
        frame.repaint();

    }

}