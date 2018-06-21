package main.java.launcher;

import javax.swing.*;

public class SettingsPanel extends JPanel
{
    public JLabel pathToSettingsFile;

    public SettingsPanel(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        pathToSettingsFile = new JLabel("Settings");
        add(pathToSettingsFile);

        DemoJFileChooser demoJFileChooser = new DemoJFileChooser();
        demoJFileChooser.setOutputLabel(pathToSettingsFile);
        this.add(demoJFileChooser);
    }
}
