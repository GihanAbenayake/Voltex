package ButtonTests;

import Units.Humanity.Fighters.FI_Rapier;
import Visuals.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RapierInfo implements MouseListener {
    JTextArea Event;
    MainFrame FFrame;
    public RapierInfo(JTextArea EventLog, MainFrame Frame){
        Event = EventLog;
        FFrame = Frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        FI_Rapier TestRapier = new FI_Rapier("TestingRapier","Testing Rapier");
        FFrame.getEventLog().setText(TestRapier.toString());
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
