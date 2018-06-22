package main.java.launcher.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainPanel extends JPanel
{
    final JPanel imagePanel;
    final JPanel textPanel;

    final JPanel buttonPanel;
    JButton buttonNormal;
    JButton buttonWide;
    JButton buttonLaunchGame;
    private JRadioButton radioButtonWin;
    private JRadioButton radioButtonMac;

    public MainPanel(){
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setSize(200, 350);

        this.imagePanel = new JPanel();
        this.textPanel = new JPanel();
        this.buttonPanel = new JPanel();

        createImage();
        createTextField();
        createRadioButtons();
        createButtons();
    }

    private void createImage(){
        BufferedImage img = null;
        try
        {
            img = ImageIO.read(getClass().getResourceAsStream("/main/resources/images/rl_icon_resized.png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(img));
        imagePanel.add(picLabel);
        this.add(imagePanel);
    }

    private void createTextField(){
        JLabel label = new JLabel("Select resolution:");
        textPanel.add(label);
        this.add(textPanel);
    }

    private void createRadioButtons(){
        radioButtonWin = new JRadioButton("Windows");
        radioButtonMac = new JRadioButton("Mac OS X");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonWin);
        buttonGroup.add(radioButtonMac);

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(radioButtonWin);
        radioPanel.add(radioButtonMac);
        this.add(radioPanel);
    }

    private void createButtons(){
        buttonNormal = new JButton("1920 x 1024");
        buttonWide = new JButton("3840 x 1024");
        buttonLaunchGame = new JButton("Launch Rocket League");

        buttonPanel.add(buttonNormal);
        buttonPanel.add(buttonWide);

        this.add(buttonPanel);

        JPanel launchGamePanel = new JPanel();
        launchGamePanel.add(buttonLaunchGame);
        this.add(launchGamePanel);
    }

    public void setActionButtonNormal(ActionListener actionListener){
        buttonNormal.addActionListener(actionListener);
    }

    public void setActionButtonWide(ActionListener actionListener){
        buttonWide.addActionListener(actionListener);
    }

    public void setActionButtonLaunchGame(ActionListener actionListener){
        buttonLaunchGame.addActionListener(actionListener);
    }

    public boolean isWindows(){
        return radioButtonWin.isSelected();
    }
}
