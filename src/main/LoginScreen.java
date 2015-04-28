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

    public LoginScreen(PanelHandler panels)
    {
        this.handler = panels;
        this.backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("startPanel");
            }
        });
        this.loginButton.addActionListener(new ActionListener()
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
                FileManager files = new FileManager();
                userList = files.readUserFiles();
                if (!adminCheckBox.isSelected() && enteredPassword.equals(getUserPassword(enteredUsername)))
                {
                    handler.pushPanel("plan1Panel");
                }
                else if (adminCheckBox.isSelected() && enteredUsername.equals("admin") && enteredPassword.equals("password"))
                {
                    handler.pushPanel("adminPanel");
                }
                else
                {
                    usernameField.setText("");
                    passwordField.setText("");
                    adminCheckBox.setSelected(false);
                }
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

    public String getUserPassword(String username)
    {
        int low = 0;
        int high = userList.size() - 1;
        int mid = 0;
        while (low <= high)
        {
            mid = (low + high) / 2;
            if (userList.get(mid).getUsername().equalsIgnoreCase(username))
            {
                return userList.get(mid).getPassword();
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
        return null;
    }

}
