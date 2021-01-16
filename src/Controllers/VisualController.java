package Controllers;

import Visuals.MainFrame;

import javax.swing.*;

public class VisualController {
    MainFrame MainVisualFrame = new MainFrame();

    public void Initialise(){
        MainVisualFrame.MainFrameStart();
    }

    public void DisplayText(String Text){
        MainVisualFrame.getEventLog().append(Text);
    }

    public JTextArea GetEventLog(){
        return MainVisualFrame.getEventLog();
    }
}
