import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import user.types.RegUser;
import user.User;

public class RegisterScreen
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton registerButton;
    private JLabel instructionLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel verifyPasswordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField verifyPasswordField;
    private ArrayList<RegUser> userList;

    public RegisterScreen(PanelHandler panels)
    {
        this.handler = panels;
        this.backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("startPanel");
            }
        });
        this.registerButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String username = usernameField.getText();
                String password = "";
                char[] passwordArray = passwordField.getPassword();
                for (int i = 0; i < passwordArray.length; i++)
                {
                    password = password + passwordArray[i];
                }
                String verifyPassword = "";
                char[] verifyPasswordArray = verifyPasswordField.getPassword();
                for (int i = 0; i < verifyPasswordArray.length; i++)
                {
                    verifyPassword = verifyPassword + verifyPasswordArray[i];
                }
                FileManager files = new FileManager();
                userList = files.readUserFiles();
                // TODO: Sort "userList" alphabetically
                // TODO: Binary search for user object based on "username"
                // TODO: If username already exists, return error. If passwords do not match, return error.
                // TODO: Otherwise, create user object, add it to list, and write list to file system.
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

}
