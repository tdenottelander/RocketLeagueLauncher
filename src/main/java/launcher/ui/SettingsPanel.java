package main.java.launcher.ui;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel
{
    private JRadioButton radioButtonWin;
    private JRadioButton radioButtonMac;

    private JLabel pathToSettingsFile;
    private JLabel pathToExecutable;
    private final static String UNDEFINED_TEXT = "- undefined - ";

    public SettingsPanel(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        createRadioButtons();

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

    private void createRadioButtons(){
        radioButtonWin = new JRadioButton("Windows");
        radioButtonMac = new JRadioButton("Mac OS X");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonWin);
        buttonGroup.add(radioButtonMac);

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(radioButtonWin);
        radioPanel.add(radioButtonMac);
        this.add(radioPanel);
    }

    public String getPathToSettingsFile(){
        return pathToSettingsFile.getText();
    }

    public String getPathToExecutable(){
        return pathToExecutable.getText();
    }

    public boolean isWindows(){
        return radioButtonWin.isSelected();
    }
}
