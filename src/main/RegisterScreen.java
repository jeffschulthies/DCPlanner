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
                try {
                    handler.pushPanel("startPanel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.registerButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                //TODO USE THE CLASSES WE CREATED!
                //TODO in the main RETRIEVE USERS THEN SAVE TO PRIVATE ARRAY.
                String username = usernameField.getText();
                String password = "";
                char[] passwordArray = passwordField.getPassword();
                for (int i = 0; i < passwordArray.length; i++)
                {
                    password = password + passwordArray[i];
                }

                FileManager files = null;
                try {
                    files = new FileManager();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                //TODO FIX USER
                ArrayList<RegUser> userListTwo = null;
                File regularDirectory = new File("data", "/users/regular/");
                if(regularDirectory.list().length == 0) {
                    RegUser newUser = new RegUser(username, 1, password);
                    files.writeUser(newUser);
                } else {
                    userListTwo = files.readUserFilesTwo();
                    System.out.println("completed");
                    RegUser newUser = new RegUser(username, userListTwo.size() + 1, password);
                    userListTwo.add(newUser);


                    /*for(int i = 0; i < userListTwo.size(); i++) {
                        System.out.println(userListTwo.get(i).getUsername());
                    }*/
                    //files.writeUser(newUser);
                    files.writeUserFiles(userListTwo);
                }
                getMainPanel();
                //userList = files.readUserFiles();
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
