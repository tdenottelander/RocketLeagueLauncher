package main.java.launcher;

import main.java.launcher.configmodifier.RLConfigModifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class App
{
    static RLConfigModifier configModifier;
    static final String settingsFilePath = "src/main/resources/settings.txt";
    static String RLSettingsFileLocation;
    static String executablePath;

    public static void main(String[] args)
    {
        readSettings();

        GuiFrame guiFrame = new GuiFrame();

        String filePath = RLSettingsFileLocation + "TASystemSettings.ini";
        configModifier = new RLConfigModifier(filePath);
        configModifier.readFile();
        configModifier.setOutputFilePath(filePath);

        guiFrame.setActionButtonNormal(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                configModifier.setNormal();
                configModifier.writeFile();
                System.out.println("Button Normal Click");
            }
        });

        guiFrame.setActionButtonWide(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                configModifier.setWide();
                configModifier.writeFile();
                runGame();
                System.out.println("Button Wide Click");
            }
        });
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

    private static void runGame(){
        try
        {
            Runtime.getRuntime().exec(executablePath);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
