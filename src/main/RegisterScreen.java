import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
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
                String enteredUsername = usernameField.getText();
                String enteredPassword = "";
                char[] enteredPasswordArray = passwordField.getPassword();
                for (int i = 0; i < enteredPasswordArray.length; i++)
                {
                    enteredPassword = enteredPassword + enteredPasswordArray[i];
                }
                String verifiedPassword = "";
                char[] verifiedPasswordArray = verifyPasswordField.getPassword();
                for (int i = 0; i < verifiedPasswordArray.length; i++)
                {
                    verifiedPassword = verifiedPassword + verifiedPasswordArray[i];
                }
                FileManager files = new FileManager();
                userList = files.readUserFiles();
                if (userList.size() == 0 && enteredPassword.equals(verifiedPassword))
                {
                    RegUser newUser = new RegUser(enteredUsername, userList.size() + 1, enteredPassword);
                    userList.add(newUser);
                    files.writeUserFiles(userList);
                    handler.pushPanel("startPanel");
                }
                else if (userList.size() != 0 && enteredPassword.equals(verifiedPassword) && !usernameExists(enteredUsername))
                {
                    RegUser newUser = new RegUser(enteredUsername, userList.size() + 1, enteredPassword);
                    userList.add(newUser);
                    files.writeUserFiles(userList);
                    handler.pushPanel("startPanel");
                }
                else
                {
                    usernameField.setText("");
                    passwordField.setText("");
                    verifyPasswordField.setText("");
                }
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

    public boolean usernameExists(String username)
    {
        int low = 0;
        int high = userList.size() - 1;
        int mid = 0;
        while (low <= high)
        {
            mid = (low + high) / 2;
            if (userList.get(mid).getUsername().equalsIgnoreCase(username))
            {
                return true;
            }
            else
            {
                if (userList.get(mid).getUsername().compareToIgnoreCase(username) > 0)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

}
