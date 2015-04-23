import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel titleLabel;
    private JLabel logoLabel;

    public StartScreen(PanelHandler panels)
    {
        this.handler = panels;
        this.logoLabel.setIcon(new ImageIcon("resources/logo.png"));
        this.loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("loginPanel");
            }
        });
        this.registerButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("registerPanel");
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

}
