package Controllers;

import Visuals.MainFrame;

public class VisualController {
    MainFrame MainVisualFrame = new MainFrame();

    public void Initialise(){
        MainVisualFrame.MainFrameStart();
    }

    public void DisplayText(String Text){
        MainVisualFrame.getEventLog().append(Text);
    }
}
