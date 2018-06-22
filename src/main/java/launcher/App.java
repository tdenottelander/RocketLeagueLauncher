package main.java.launcher;

import main.java.launcher.configmodifier.RLConfigModifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class App
{
    static RLConfigModifier configModifier;
    static String settingsFilePath;
    static String RLSettingsFileLocation;
    static String executablePath;
    static GuiFrame guiFrame;

    public static void main(String[] args)
    {
        guiFrame = new GuiFrame();

        guiFrame.mainPanel.setActionButtonNormal(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(settingsFilePath == null) setSettingsFilePath();
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
                if(settingsFilePath == null) setSettingsFilePath();
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

    private static void setupRLConfigModifier(){
        configModifier = new RLConfigModifier(settingsFilePath);
        configModifier.readFile();
        configModifier.setOutputFilePath(settingsFilePath);
    }

    private static void setSettingsFilePath()
    {
        settingsFilePath = guiFrame.getSettingsPath();
    }

    /**
     * Reading the settings from the settings.txt file
     */
    private static void readSettings(){
        File file = new File(settingsFilePath);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = bufferedReader.readLine()) != null)
            if(line.contains("settingslocation")){
                RLSettingsFileLocation = line.split("=")[1];
            } else if (line.contains("executablepath")){
                executablePath = line.split("=")[1];
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void launchGame(){
        try
        {
            executablePath = guiFrame.getExecutablePath();
            Runtime.getRuntime().exec("open " + executablePath);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
