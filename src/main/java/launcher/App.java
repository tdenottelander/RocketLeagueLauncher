package main.java.launcher;

import main.java.launcher.configmodifier.ConfigModifier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App
{
    static ConfigModifier configModifier;

    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        GuiFrame guiFrame = new GuiFrame();

        String filePath = "src/test/resources/TASystemSettings.ini";
        configModifier = new ConfigModifier(filePath);
        configModifier.readFile();
        configModifier.setOutputFilePath(filePath);

        guiFrame.setActionButton1(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                configModifier.replaceString("ResX=1920","ResX=3840");
//                configModifier.writeFile();
                System.out.println("TEST");
            }
        });
    }
}
