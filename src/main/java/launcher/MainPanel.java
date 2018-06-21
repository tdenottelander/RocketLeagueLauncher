package main.java.launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JPanel
{
    final JPanel imagePanel;
    final JPanel textPanel;

    final JPanel buttonPanel;
    JButton buttonNormal;
    JButton buttonWide;
    JButton buttonLaunchGame;

    public MainPanel(){
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setSize(200, 350);

        this.imagePanel = new JPanel();
        this.textPanel = new JPanel();
        this.buttonPanel = new JPanel();

        createImage();
        createTextField();
        createButtons();
    }

    private void createImage(){
        BufferedImage img = null;
        try
        {
            img = ImageIO.read(new File("src/main/resources/images/rl_icon_resized.png"));
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
}
