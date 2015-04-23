import javax.swing.*;

public class PlanScreen2
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel mealOneLabel;
    private JLabel mealTwoLabel;
    private JLabel mealThreeLabel;
    private JButton continueButton;
    private JCheckBox enableOneCheckBox;
    private JCheckBox enableThreeCheckBox;
    private JCheckBox enableTwoCheckBox;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;

    public PlanScreen2(PanelHandler panels)
    {
        this.handler = panels;
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

}
