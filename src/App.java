import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class App
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        createWindow();
    }

    private static void createWindow(){
        JFrame guiFrame = new JFrame();
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Example GUI");
        guiFrame.setSize(300,250);
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);

        JPanel textPanel = new JPanel();

        BufferedImage myPicture = null;
        try
        {
            myPicture = ImageIO.read(new File("src/rl_icon.png"));
            
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setSize(new Dimension(5, 5));
        textPanel.add(picLabel);

        JLabel label = new JLabel("Select resolution:");

        JButton buttonNormal = new JButton("1920 x 1024");
        JButton buttonWide = new JButton("3840 x 1024");
        buttonWide.setSize(40,40);

        buttonNormal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Button 1");
            }
        });


        guiFrame.add(textPanel);

        textPanel.add(label);
        textPanel.add(buttonNormal);
        textPanel.add(buttonWide);

        guiFrame.setVisible(true);
    }
}
