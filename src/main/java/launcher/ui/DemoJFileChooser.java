package main.java.launcher.ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class DemoJFileChooser extends JPanel implements ActionListener
{
    JButton go;

    JLabel outputLabel;

    JFileChooser chooser;
    String choosertitle;

    public DemoJFileChooser() {
        go = new JButton("Choose File...");
        go.addActionListener(this);
        add(go);
    }

    public void setOutputLabel(JLabel outputLabel){
        this.outputLabel = outputLabel;
    }

    public void actionPerformed(ActionEvent e) {
        int result;

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            System.out.println("getCurrentDirectory(): "
//                +  chooser.getCurrentDirectory());
            System.out.println("set path to: "
                +  chooser.getSelectedFile());
            outputLabel.setText(chooser.getSelectedFile().toString());
        }
        else {
            System.out.println("No Selection ");
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(200, 200);
    }

    public static void main(String s[]) {
        JFrame frame = new JFrame("");
        DemoJFileChooser panel = new DemoJFileChooser();
        frame.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        frame.getContentPane().add(panel,"Center");
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);
    }
}