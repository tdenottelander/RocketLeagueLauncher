import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiFrame extends JFrame
{

    static JFrame guiFrame;

    public GuiFrame()
    {
        this.guiFrame = new JFrame();
        createWindow();
    }

    private static void createWindow(){
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Example GUI");
        guiFrame.setSize(300,250);
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);

        JPanel textPanel = new JPanel();

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
