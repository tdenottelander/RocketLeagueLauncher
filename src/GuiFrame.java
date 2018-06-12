import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiFrame extends JFrame
{

    final JFrame guiFrame;
    final JPanel mainPane;
    final JPanel textPanel;
    final JPanel buttonPanel;

    public GuiFrame()
    {
        this.guiFrame = new JFrame();
        this.mainPane = new JPanel();
        this.textPanel = new JPanel();
        this.buttonPanel = new JPanel();
        setupGuiFrame();
        setupMainPane();
        createTextField();
        createButtons();

        guiFrame.setVisible(true);
    }

    private void setupGuiFrame(){
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("RocketLeagueLauncher");
        guiFrame.setSize(300,250);
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
    }

    private void setupMainPane(){
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
        guiFrame.add(mainPane);
    }

    private void createTextField(){
        JLabel label = new JLabel("Select resolution:");
        textPanel.add(label);
        mainPane.add(textPanel);
    }

    private void createButtons(){
        JButton buttonNormal = new JButton("1920 x 1024");
        JButton buttonWide = new JButton("3840 x 1024");

        buttonNormal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Button 1");
            }
        });

        buttonPanel.add(buttonNormal);
        buttonPanel.add(buttonWide);

        mainPane.add(buttonPanel);
    }
}
