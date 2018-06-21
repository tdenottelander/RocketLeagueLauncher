package main.java.launcher;

import javax.swing.*;

public class SettingsPanel extends JPanel
{
    public JLabel textLabel;

    public SettingsPanel(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        textLabel = new JLabel("Settings");
        add(textLabel);
    }
}
