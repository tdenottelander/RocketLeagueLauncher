package main.java.launcher;

import main.java.launcher.configmodifier.RLConfigModifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App
{
    static RLConfigModifier configModifier;

    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        GuiFrame guiFrame = new GuiFrame();

        String filePath = "src/test/resources/TASystemSettings.ini";
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
                System.out.println("Button Wide Click");
            }
        });
    }
}
