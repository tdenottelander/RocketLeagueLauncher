package main.java.launcher;

import javax.swing.*;

public class GuiFrame extends JFrame
{

    final JTabbedPane globalPanel;
    final MainPanel mainPanel;
    final SettingsPanel settingsPanel;

    public GuiFrame()
    {
        this.globalPanel = new JTabbedPane();
        this.mainPanel = new MainPanel();
        this.settingsPanel = new SettingsPanel();

        setupGuiFrame();

        globalPanel.addTab("Main", mainPanel);
        globalPanel.addTab("Settings", settingsPanel);

        this.add(globalPanel);

        this.setVisible(true);
    }

    private void setupGuiFrame(){
        //make sure the program exits when the frame closes
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RocketLeagueLauncher");
        this.setSize(500,600);
        //This will center the JFrame in the middle of the screen
        this.setLocationRelativeTo(null);
    }

    public String getExecutablePath()
    {
        return settingsPanel.getPathToExecutable();
    }

    public String getSettingsPath(){
        return settingsPanel.getPathToSettingsFile();
    }
}
