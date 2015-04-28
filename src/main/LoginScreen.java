import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import user.types.RegUser;

public class LoginScreen
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton loginButton;
    private JLabel instructionLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox adminCheckBox;
    private ArrayList<RegUser> userList;

    public LoginScreen(PanelHandler panels) throws Exception
    {
        this.handler = panels;
        this.backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    handler.pushPanel("startPanel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!adminCheckBox.isSelected())
                {
                    try {
                        handler.pushPanel("PlanScreen1");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }

                    // TODO: Sort "userList" alphabetically
                    // TODO: Binary search for user object based on "username"
                    // TODO: If user object is found, compare "password" with correct password. If match, move to planning sequence.
                    // TODO: If no match, clear both fields and print error message.
                    // TODO: If user object is not found, clear both fields and print error message.

                else
                {
                    String username = usernameField.getText();
                    String password = "";
                    char[] passwordArray = passwordField.getPassword();
                    for (int i = 0; i < passwordArray.length; i++)
                    {
                        password = password + passwordArray[i];
                    }
                    if (username.equals("admin") && password.equals("password"))
                    {
                        try {
                            handler.pushPanel("adminPanel");
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

}
