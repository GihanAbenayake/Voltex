package ButtonTests;

import Units.Humanity.Bombers.BO_ZweiHandler;
import Units.Humanity.Fighters.FI_Rapier;
import Visuals.MainFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ZweIHandlerInfo implements MouseListener {
    JTextArea Event;
    MainFrame FFrame;
    public ZweIHandlerInfo(JTextArea EventLog, MainFrame Frame){
        Event = EventLog;
        FFrame = Frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        BO_ZweiHandler TestZwei = new BO_ZweiHandler("TestingZwei","TestZwei");
        FFrame.getEventLog().setText(TestZwei.toString());
        FFrame.validate();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

