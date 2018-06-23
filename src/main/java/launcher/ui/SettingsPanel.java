package main.java.launcher.ui;

import javax.swing.*;

public class SettingsPanel extends JPanel
{
    private JLabel pathToSettingsFile;
    private JLabel pathToExecutable;
    public final static String UNDEFINED_TEXT = "- undefined - ";

    public SettingsPanel(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        addFileChooserField(pathToSettingsFile = new JLabel(), "Path to settings file:");
        addFileChooserField(pathToExecutable = new JLabel(), "Path to executable:");
    }

    private void addFileChooser(JLabel labelToSet){
        DemoJFileChooser demoJFileChooser = new DemoJFileChooser();
        demoJFileChooser.setOutputLabel(labelToSet);
        this.add(demoJFileChooser);
    }

    private void addFileChooserField(JLabel labelToSet, String subject){

        JLabel label = new JLabel(subject);
        add(label);

        labelToSet.setText(UNDEFINED_TEXT);
        add(labelToSet);

        addFileChooser(labelToSet);
    }

    public String getPathToSettingsFile(){
        return pathToSettingsFile.getText();
    }

    public String getPathToExecutable(){
        return pathToExecutable.getText();
    }
}
