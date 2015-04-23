import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanScreen1
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JButton continueButton;
    private JLabel titleLabel;
    private JLabel instructionLabel1;
    private JLabel startLabel;
    private JLabel endLabel;
    private JLabel instructionLabel2;
    private JComboBox startTime;
    private JComboBox endTime;
    private JComboBox startPeriod;
    private JComboBox endPeriod;
    private JCheckBox museumsCheckBox;
    private JCheckBox monumentsCheckBox;
    private JCheckBox collegesCheckBox;
    private JCheckBox theatersCheckBox;
    private JCheckBox historicalSitesCheckBox;
    private JCheckBox parksCheckBox;

    public PlanScreen1(PanelHandler panels)
    {
        this.handler = panels;
        this.continueButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("plan2Panel");
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

}
