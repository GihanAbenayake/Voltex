package Visuals;

import ButtonTests.DiceTest;
import ButtonTests.EventLogCleaner;
import ButtonTests.RapierInfoAdaptor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;

public class MainFrame extends JFrame {
    private JFrame MainFrame = new JFrame("Voltex Test MainFrame");
    private JPanel MainPanel1;
    private JPanel MenuPanel;
    private JTextArea EventLog;
    private String TurnSeperator ="===============================================================================================================================================";
    private Container cont;

    //JButtons
    JButton Button1 = new JButton();
    JButton Button2 = new JButton();
    JButton Button3 = new JButton();
    JButton Button4 = new JButton();
    JButton Button5 = new JButton();
    JButton Button6 = new JButton();
    JButton Button7 = new JButton();
    JButton Button8 = new JButton();
    JButton Button9 = new JButton();
    JButton Button10 = new JButton();

    //Creation and parameters of the EventLog
    public void EventLogCreation(JPanel panel){
        //EventLog and Turn Separator initialisation
        EventLog = new JTextArea(TurnSeperator);

        //Allows Line wrapping
        EventLog.setLineWrap(true);
        EventLog.setWrapStyleWord(true);

        EventLog.setEditable(false);

        //Allows for font size changing
        EventLog.setFont(new Font(EventLog.getFont().getName(),Font.PLAIN,15));

        //Addition of EventLog to panel
        panel.add(EventLog);

        //EventLog Debug Border
        //EventLog.setBorder(new LineBorder(Color.CYAN));

        //EventLog Background and Foreground(text)
        EventLog.setBackground(panel.getBackground());
        EventLog.setForeground(Color.white);

        //Visibility setting
        EventLog.setVisible(true);

    }

    public void ButtonCreation(JPanel panel){
        //Array containing all JButtons
        JButton[] ButtonList ={Button1,Button2,Button3,Button4,Button5,Button6,Button7,Button8,Button9,Button10};

        //For Loop for adding Buttons to Panels
        for(int x = 0;x < ButtonList.length;x++){
            ButtonList[x].setText("Button " + (x+1));
            panel.add(ButtonList[x]);

            //Debug for button addition
            //System.out.println("Button " + (x+1) + " added");
        }

        //Success message
        System.out.println("\nButtons added Successfully");


    }

    //Creation and initialisation of the Main Panel and Menu Panel
    public void MainPanelStart(){
        //Panel Initialisation
        MainPanel1 = new JPanel();
        MenuPanel = new JPanel();

        //Setting Maximum size for Box Layout
        MainPanel1.setMaximumSize(new Dimension(1280, 840));
        MenuPanel.setMaximumSize(new Dimension(1280,120));

        //Setting Backgrounds for the Panels
        MainPanel1.setBackground(Color.DARK_GRAY);
        MenuPanel.setBackground(Color.DARK_GRAY);

        //Setting Layouts for MainPanels
        MainPanel1.setLayout(new BoxLayout(MainPanel1,BoxLayout.PAGE_AXIS));
        MenuPanel.setLayout(new GridLayout(2,5,5,5));

        //Adding EventLog to MainPanel 1
        EventLogCreation(MainPanel1);

        //Added Cleaner to reduce compression of other elements due to extra text
        EventLog.addMouseListener(new EventLogCleaner(EventLog,cont));

        //Adding Buttons to Menu Panel
        ButtonCreation(MenuPanel);

        //Main Menu Button hiding
        Button1.setVisible(false);
        Button2.setVisible(false);
        Button4.setVisible(false);
        Button5.setVisible(false);
        Button6.setVisible(false);
        Button7.setVisible(false);
        Button9.setVisible(false);
        Button10.setVisible(false);

        // Mouse Listener tests
/*
        Button3.setText("Rapier Information display");
        Button3.addMouseListener(new RapierInfoAdaptor(EventLog,Button3));
        Button8.setText("Dice Test");
        Button8.addMouseListener(new DiceTest(EventLog));

 */




        //Debug Borders for Panels
        /*
        MainPanel1.setBorder(new LineBorder(Color.BLUE,2));
        MenuPanel.setBorder(new LineBorder(Color.GREEN,2));

         */

        //Success Menu
        System.out.println("Main Panels started successfully");
    }

    public void MainFrameStart(){

        //Setting Frame Size
        MainFrame.setSize(1280,840);

        //Setting way to close
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Changing background color to black
        MainFrame.getContentPane().setBackground(Color.BLACK);

        //Applying content pane to a container entity
        cont = MainFrame.getContentPane();

        //Applying a box layout to the container for panel addition
        cont.setLayout(new BoxLayout(cont,BoxLayout.PAGE_AXIS));
        MainFrame.setVisible(true);

        //Creating Panels and applying their parameters
        this.MainPanelStart();

        //Adding Objects to the container and setting visible
        cont.add(MainPanel1);
        cont.add(MenuPanel);
        cont.setVisible(true);
        cont.validate();

    }
}
