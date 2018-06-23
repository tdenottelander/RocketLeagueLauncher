package main.java.launcher;

import main.java.launcher.configmodifier.RLConfigModifier;
import main.java.launcher.exception.IncorrectPathException;
import main.java.launcher.ui.GuiFrame;
import main.java.launcher.ui.SettingsPanel;

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
            if(executablePath == null || executablePath.equals(SettingsPanel.UNDEFINED_TEXT)) throw new IncorrectPathException();

            String OS = System.getProperty("os.name");
            String prefix = ""; //Default for Windows
            if(OS.equals("Mac OS X")) prefix = "open "; //Default for Mac

            String command = prefix + executablePath;
            System.out.println("Now running command: " + command);
            guiFrame.getMainPanel().setInfoMessage("Launching game...");
            Runtime.getRuntime().exec(command);
        } catch (IOException e)
        {
            System.out.println("Other exception");
        } catch (IncorrectPathException e)
        {
            String message = "The path to the executable is not properly set.";
            guiFrame.getMainPanel().setErrorMessage(message);
            System.out.println(message);
        }
    }

    /**
     * Sets the actionlisteners for the resolution buttons and the launch button.
     */
    private static void setButtonActionListeners() {
        guiFrame.getMainPanel().setActionButtonNormal(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setSettingsFilePath();
                setupRLConfigModifier();
                configModifier.setNormal();
                configModifier.writeFile();
                String message = "Set resolution to 1920x1080";
                guiFrame.getMainPanel().setInfoMessage(message);
                System.out.println(message);
            }
        });

        guiFrame.getMainPanel().setActionButtonWide(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setSettingsFilePath();
                setupRLConfigModifier();
                configModifier.setWide();
                configModifier.writeFile();
                String message = "Set resolution to 3840x1080";
                guiFrame.getMainPanel().setInfoMessage(message);
                System.out.println(message);
            }
        });

        guiFrame.getMainPanel().setActionButtonLaunchGame(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                launchGame();
            }
        });
    }
}
