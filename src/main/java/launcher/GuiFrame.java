package main.java.launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GuiFrame extends JFrame
{

    final JFrame guiFrame;
    final JPanel mainPane;
    final JPanel textPanel;
    final JLabel imageLabel;
    final JPanel buttonPanel;
    JButton buttonNormal;
    JButton buttonWide;
    JButton buttonLaunchGame;

    public GuiFrame()
    {
        this.guiFrame = new JFrame();
        this.mainPane = new JPanel();
        this.imageLabel = new JLabel();
        this.textPanel = new JPanel();
        this.buttonPanel = new JPanel();
        setupGuiFrame();
        setupMainPane();
        createImage();
        createTextField();
        createButtons();

        guiFrame.setVisible(true);
    }

    private void setupGuiFrame(){
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("RocketLeagueLauncher");
        guiFrame.setSize(300,350);
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
    }

    private void setupMainPane(){
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
        guiFrame.add(mainPane);
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
        textPanel.add(picLabel);
    }

    private void createTextField(){
        JLabel label = new JLabel("Select resolution:");
        textPanel.add(label);
        mainPane.add(textPanel);
    }

    private void createButtons(){
        buttonNormal = new JButton("1920 x 1024");
        buttonWide = new JButton("3840 x 1024");
        buttonLaunchGame = new JButton("Launch Rocket League");

        buttonPanel.add(buttonNormal);
        buttonPanel.add(buttonWide);

        mainPane.add(buttonPanel);

        JPanel launchGamePanel = new JPanel();
        launchGamePanel.add(buttonLaunchGame);
        mainPane.add(launchGamePanel);
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
