package main.java.launcher.ui;

import javax.swing.*;

public class GuiFrame extends JFrame
{

    private final JTabbedPane globalPanel;

    private final MainPanel mainPanel;

    private final SettingsPanel settingsPanel;
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

    public boolean isWindows() {
        return settingsPanel.isWindows();
    }

    public MainPanel getMainPanel()
    {
        return mainPanel;
    }

    public SettingsPanel getSettingsPanel()
    {
        return settingsPanel;
    }
}
