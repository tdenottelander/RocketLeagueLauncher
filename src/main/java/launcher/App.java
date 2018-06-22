package main.java.launcher;

import main.java.launcher.configmodifier.RLConfigModifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class App
{
    static RLConfigModifier configModifier;
    static String settingsFilePath;
    static String executablePath;
    static GuiFrame guiFrame;

    public static void main(String[] args)
    {
        guiFrame = new GuiFrame();

        setButtonActionListeners();
    }

    /**
     * Creates the configModifier with the specified settingsFilePath and
     * reads the file.
     */
    private static void setupRLConfigModifier(){
        configModifier = new RLConfigModifier(settingsFilePath);
        configModifier.readFile();
        configModifier.setOutputFilePath(settingsFilePath);
    }

    /**
     * Sets the settingspath from the settingspage.
     */
    private static void setSettingsFilePath()
    {
        if(settingsFilePath == null) settingsFilePath = guiFrame.getSettingsPath();
    }

    /**
     * Launches the game.
     */
    private static void launchGame(){
        try
        {
            executablePath = guiFrame.getExecutablePath();
            if(executablePath == null) throw new IOException();
            String prefix = guiFrame.isWindows() ? "" : "open ";
            Runtime.getRuntime().exec(prefix + executablePath);
        } catch (IOException e)
        {
            System.out.println("The path to the executable is not properly set.");
        }
    }

    /**
     * Sets the actionlisteners for the resolution buttons and the launch button.
     */
    private static void setButtonActionListeners() {
        guiFrame.mainPanel.setActionButtonNormal(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setSettingsFilePath();
                setupRLConfigModifier();
                configModifier.setNormal();
                configModifier.writeFile();
                System.out.println("Set resolution to 1920x1080");
            }
        });

        guiFrame.mainPanel.setActionButtonWide(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setSettingsFilePath();
                setupRLConfigModifier();
                configModifier.setWide();
                configModifier.writeFile();
                System.out.println("Set resulotion to 3840x1080");
            }
        });

        guiFrame.mainPanel.setActionButtonLaunchGame(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                launchGame();
            }
        });
    }
}
